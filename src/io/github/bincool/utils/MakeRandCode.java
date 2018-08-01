/**
* @FileName: MakeRandCode.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: MakeRandCode.java: ���ظ������ֿ�������.
* @Author wchy����������(891946049).
* @Date 2018��6��12�� ����2:59:44.
* @Content: ����.
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
* ���ظ������ֿ�������,ÿ�������Ӧһ������������.
* </p>
* <p>
* ��ϸ����:
* 1 �޲ι��캯����Ĭ��Ϊ6λ�����ֿ⣬4λ����2λ��ĸ.
* 2 �в������캯��������Ϊ����볤�Ⱥ���ĸ��������������볤��Լ��Ϊ1~256����ĸ����Լ��Ϊ0~length.
* 3 ����(����/����/�Զ���)�������������ֿ⣬���ֿ����д������ʱ������.
* 4 ��ȡ��ǰ����룬�����һ�����ɳɹ��������.
* 5 ��ȡ����룬��������������ֿ�.
* </p>
* <p>
* ʾ������:
* MakeRandCode randCodeHouses = new MakeRandCode(2, 0);
* // ��ʼ�������ֿ�.
* randCodes.createRandCode(10);
* randCodes.obtainCurrentCode();
* randCodes.obtainRandCode();
* </p>
*
* @Author: wchy����������(891946049).
* 
* @Date: 2018��6��12�� ����2:59:44.
* 
*/
public class MakeRandCode
{

    /**
     * ��д��ĸ��.
     */
    private static final String LETTER_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * ���������.
     */
    private static final Random random = new Random();
    
    /**
     * ��ǰ����룬���������ɹ����û�����ͨ�������ӿڻ�ȡ��ֵ;����ʧ����Ϊ��һ�γɹ��������.
     */
    private StringBuffer code = new StringBuffer();

    /**
     * �����ֿ�,ÿ������ʹ��һ���ڴ����.
     */
    private Map<String, String> codeMap = new HashMap<>();
    
    /**
     * ������±�����˳���������,ÿ������ʹ��һ���ڴ����.
     */
    private List<Integer> codeOrder = new ArrayList<>();

    /**
     * �������ݿ�,ÿ������ʹ��һ���ڴ����.
     */
    private StringBuffer sb = new StringBuffer();
    
    /**
     * ����볤��.
     */
    private int length = 6;
    
    /**
     * ��ĸ����:.
     */
    private int letterCount = 2;
    
    /**
     * ���ָ���:����-��ĸ����.
     */
    private int digitCount = 4;

    /**
     * �޲ι��캯������ʼ��������±�����˳��.
     */
    public MakeRandCode()
    {
    	this(6, 2);
    }
    
    /**
     * �вι��캯������ʼ��������±�����˳��.
     * @param length
     * 		����볤��:1~256.
     * @param letterCount
     * 		��ĸ����:0~length.
     */
    public MakeRandCode(int length, int letterCount)
    {
    	// length���ȱ������0С�ڵ���256.
    	if (length < 1 && length > 256) 
    	{
    		throw new IllegalArgumentException("Length must be greater than 0 and less than or equal to 256.");
    	}
    	
    	// letterCount���ȱ�����ڵ���0С�ڵ���256.
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
     * �����������������ֿ�,��֤�ֿ�����벻�ظ�,�ɹ�����true.
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

        // �������������±�����˳��.
        Collections.shuffle(codeOrder);

        // ���������.
        code.delete(0, code.length());
        for (int i = 0; i < length; i++) 
        {
        	code.append(sb.charAt(codeOrder.get(i)));
        }

        // �Ѿ����ڴ�������򷵻�false��task������������while.
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
     * ���������������������ֿ�,ʵ�ʴ���ֿ���������Ϊ0~maxCount,2/3ԭ��.
     * @param maxCount
     * 		���������������������.
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
     * �ⲿ�������������ֿ�,��֤�ֿ�����벻�ظ�,�ɹ�����true.
     * @param randCode
     * 		
     */
    public boolean createRandCode(String randCode) 
    {
    	boolean ret = true;
    	
		// У��code�Ƿ���������ֿ����������.
    	if (StringUtils.isEmpty(randCode) || 
    			length != randCode.length() || 
    			digitCount != StringUtils.regexCount(randCode, "\\d") || 
    			letterCount != StringUtils.regexCount(randCode, "[A-Z]")) 
    	{
    		throw new IllegalArgumentException("The data entered is illegal.");
    	} 
    	
    	// �Ѿ����ڴ�������򷵻�false��task������������while.
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
     * ��ȡ��ǰ����룬�����һ�����ɳɹ��������.
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
     * ��ȡ����룬��������������ֿ�.
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

