/**
* @FileName: StringUtils.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: StringUtils.java: 字符串工具类.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午9:01:03.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.utils;

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
    
}
