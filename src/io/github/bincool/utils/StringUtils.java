/**
* @FileName: StringUtils.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: StringUtils.java: �ַ���������.
* @Author wchy����������(891946049).
* @Date 2018��6��12�� ����9:01:03.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.utils;

/**
* @ClassName: StringUtils.java
* 
* @Description: 
* <p>
* �ַ���������.
* </p>
* <p>
* �ַ��������ࣺ�������ַ���������.
* </p>
* <p>
* ʾ������.
* </p>
*
* @Author: wchy����������(891946049).
* 
* @Date: 2018��6��12�� ����9:01:03.
* 
*/
public class StringUtils 
{
	
	/**
	 * �ַ���Ϊ��.
	 * @param str
	 * 		�ַ���.
	 * @return
	 */
	public static boolean isEmpty(String str) 
	{
		return null == str || "".equals(str);
	}
	
	/**
	 * �ַ�����Ϊ��.
	 * @param str
	 * 		�ַ���.
	 * @return
	 */
	public static boolean isNotEmpty(String str) 
	{
		return !isEmpty(str);
	}
	
	/**
     * ��ȡ�����滻�ַ���������.
     * @param str
     * 		�������滻���ַ���.
     * @param regex
     * 		������ʽ.
     * @return
     */
    public static int regexCount(String str, String regex) 
    {
    	return str.length() - str.replaceAll(regex, "").length();
    }
    
}
