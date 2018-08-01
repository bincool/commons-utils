/**
* @FileName: MakeRandCode.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: MakeRandCode.java: 不重复随机码仓库生成器.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午2:59:44.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import io.github.bincool.utils.commons.StringUtils;

/**
* @ClassName: MakeRandCode.java
* 
* @Description: 
* <p>
* 不重复随机码仓库生成器,每个任务对应一个生成器对象.
* </p>
* <p>
* 详细描述:
* 1 无参构造函数，默认为6位随机码仓库，4位数字2位字母.
* 2 有参数构造函数，参数为随机码长度和字母个数，其中随机码长度约束为1~256，字母长度约束为0~length.
* 3 生产(单个/批量/自定义)随机码放入随机码仓库，当仓库中有此随机码时不放入.
* 4 获取当前随机码，是最近一次生成成功的随机码.
* 5 获取随机码，随机码来自随机码仓库.
* </p>
* <p>
* 示例代码:
* MakeRandCode randCodeHouses = new MakeRandCode(2, 0);
* // 初始化随机码仓库.
* randCodes.createRandCode(10);
* randCodes.obtainCurrentCode();
* randCodes.obtainRandCode();
* </p>
*
* @Author: wchy，技术交流(891946049).
* 
* @Date: 2018年6月12日 下午2:59:44.
* 
*/
public class MakeRandCode
{

    /**
     * 大写字母集.
     */
    private static final String LETTER_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 随机生成器.
     */
    private static final Random random = new Random();
    
    /**
     * 当前随机码，生成随机码成功后，用户可以通过方法接口获取该值;生成失败则为上一次成功的随机码.
     */
    private StringBuffer code = new StringBuffer();

    /**
     * 随机码仓库,每个任务使用一个内存对象.
     */
    private Map<String, String> codeMap = new HashMap<>();
    
    /**
     * 随机码下标索引顺序随机打乱,每个任务使用一个内存对象.
     */
    private List<Integer> codeOrder = new ArrayList<>();

    /**
     * 缓存数据快,每个任务使用一个内存对象.
     */
    private StringBuffer sb = new StringBuffer();
    
    /**
     * 随机码长度.
     */
    private int length = 6;
    
    /**
     * 字母个数:.
     */
    private int letterCount = 2;
    
    /**
     * 数字个数:长度-字母个数.
     */
    private int digitCount = 4;

    /**
     * 无参构造函数，初始化随机码下标索引顺序.
     */
    public MakeRandCode()
    {
    	this(6, 2);
    }
    
    /**
     * 有参构造函数，初始化随机码下标索引顺序.
     * @param length
     * 		随机码长度:1~256.
     * @param letterCount
     * 		字母个数:0~length.
     */
    public MakeRandCode(int length, int letterCount)
    {
    	// length长度必须大于0小于等于256.
    	if (length < 1 && length > 256) 
    	{
    		throw new IllegalArgumentException("Length must be greater than 0 and less than or equal to 256.");
    	}
    	
    	// letterCount长度必须大于等于0小于等于256.
    	if (letterCount < 0 && letterCount > length) 
    	{
    		throw new IllegalArgumentException("Length must be greater than 0 and less than or equal to 256.");
    	}
    	
    	this.length = length;
    	this.letterCount = letterCount;
    	this.digitCount = length - letterCount;
    	
    	for (int i = 0; i < length; i++) 
    	{
    		codeOrder.add(i);
    	}
    }

    /**
     * 生产随机码放入随机码仓库,保证仓库随机码不重复,成功返回true.
     * @return
     */
    public boolean createRandCode()
    {
        boolean ret = true;

        sb.delete(0, sb.length());
        for (int i = 0; i < letterCount; i++) 
        {
        	sb.append(LETTER_UPPER.charAt(random.nextInt(26)));
        }
        for (int i = 0; i < digitCount; i++) 
        {
        	sb.append(random.nextInt(10));
        }

        // 随机打乱随机码下标索引顺序.
        Collections.shuffle(codeOrder);

        // 保存随机码.
        code.delete(0, code.length());
        for (int i = 0; i < length; i++) 
        {
        	code.append(sb.charAt(codeOrder.get(i)));
        }

        // 已经存在此随机码则返回false，task不操作，继续while.
        if (codeMap.containsKey(code.toString()))
        {
            ret = false;
        }
        else
        {
            codeMap.put(code.toString(), code.toString());
        }

        return ret;
    }
    
    /**
     * 批量生产随机码放入随机码仓库,实际存入仓库的随机码数为0~maxCount,2/3原则.
     * @param maxCount
     * 		批次生产的随机码最大个数.
     */
    public void createRandCode(int maxCount)
    {
    	int count = 0;
    	for (int i = 0; count < maxCount && i < 1.5 * maxCount; i++) 
    	{
    		if (createRandCode()) 
    		{
    			count++;
    		}
    	}
    }
    
    /**
     * 外部随机码放入随机码仓库,保证仓库随机码不重复,成功返回true.
     * @param randCode
     * 		
     */
    public boolean createRandCode(String randCode) 
    {
    	boolean ret = true;
    	
		// 校验code是否符合随机码仓库的随机码规则.
    	if (StringUtils.isEmpty(randCode) || 
    			length != randCode.length() || 
    			digitCount != StringUtils.regexCount(randCode, "\\d") || 
    			letterCount != StringUtils.regexCount(randCode, "[A-Z]")) 
    	{
    		throw new IllegalArgumentException("The data entered is illegal.");
    	} 
    	
    	// 已经存在此随机码则返回false，task不操作，继续while.
        if (codeMap.containsKey(randCode))
        {
            ret = false;
        }
        else
        {
            codeMap.put(randCode, randCode);
        }

        return ret;
	}

    /**
     * 获取当前随机码，是最近一次生成成功的随机码.
     * @return
     */
    public String obtainCurrentCode()
    {
    	if (code.length() == 0) 
    	{
    		throw new IllegalArgumentException("Please execute the createRandCode method.");
    	}
    	
        return code.toString();
    }
    
    /**
     * 获取随机码，随机码来自随机码仓库.
     * @return
     */
    public String obtainRandCode() 
    {
    	if (code.length() == 0) 
    	{
    		throw new IllegalArgumentException("Please init the random code warehouse by the method of createRandCode.");
    	}
    	
    	String[] keys = codeMap.keySet().toArray(new String[0]);
    	return codeMap.get(keys[random.nextInt(keys.length)]);
	}

}

