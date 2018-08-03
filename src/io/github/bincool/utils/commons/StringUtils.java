/**
* @FileName: StringUtils.java
* @Package: io.github.bincool.utils.commons
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: StringUtils.java: 字符串工具类.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午9:01:03.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.utils.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @ClassName: StringUtils.java
* 
* @Description: 
* <p>
* 字符串工具类.
* </p>
* <p>
* 字符串工具类：常见的字符串处理方法.
* </p>
* <p>
* 示例代码.
* </p>
*
* @Author: wchy，技术交流(891946049).
* 
* @Date: 2018年6月12日 下午9:01:03.
* 
*/
public class StringUtils 
{
	
	/**
	 * 私有构造函数.
	 */
	private StringUtils() 
	{
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * 字符串为空.
	 * @param str
	 * 		字符串.
	 * @return
	 */
	public static boolean isEmpty(String str) 
	{
		return null == str || "".equals(str);
	}
	
	/**
	 * 字符串不为空.
	 * @param str
	 * 		字符串.
	 * @return
	 */
	public static boolean isNotEmpty(String str) 
	{
		return !isEmpty(str);
	}
	
	/**
	 * 获取正则替换字符数量长度.
	 * @param str
	 * 		待正则替换的字符串.
	 * @param regex
	 * 		正则表达式.
	 * @return
	 */
	public static int regexCount(String str, String regex) 
	{
		return str.length() - str.replaceAll(regex, "").length();
	}
    
	/**
	 * 用spliceSign拼接字符串.
	 * @param spliceSign
	 * 		拼接符号.
	 * @param strs
	 * 		待拼接的字符串数组.
	 * @return
	 */
	public static String spliceStr(String spliceSign, String ...strs)  
	{
		if(EmptyUtils.isEmpty(strs)) 
		{
			throw new IllegalArgumentException("pathnames is null");
		}
		
		if (EmptyUtils.isEmpty(spliceSign)) 
		{
			spliceSign = "";
		}
		
		StringBuilder sb = new StringBuilder();
		for(String str : strs) 
		{
			sb.append(str).append(spliceSign);
		}
		
		return sb.toString();
	}
	
	/**
	 * 判断str是否是正整数.
	 * @param str
	 * @return
	 */
	public static boolean isPosInt(String str) 
	{
		Pattern pattern = Pattern.compile("^([1-9]\\d*)");
		Matcher isNum = pattern.matcher(str);
		return isNum.matches();
	}
	
	/**
	 * 判断str是否是负整数.
	 * @param str
	 * @return
	 */
	public static boolean isNegInt(String str) 
	{
		Pattern pattern = Pattern.compile("^(\\-?[1-9]\\d*)");
		Matcher isNum = pattern.matcher(str);
		return isNum.matches();
	}
	
	/**
	 * 判断str是否是整数.
	 * @param str
	 * @return
	 */
	public static boolean isInt(String str) 
	{
		Pattern pattern = Pattern.compile("^(0|\\-?[1-9]\\d*)");
		Matcher isNum = pattern.matcher(str);
		return isNum.matches();
	}
    
}
