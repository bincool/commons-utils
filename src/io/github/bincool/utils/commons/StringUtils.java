/**
* @FileName: StringUtils.java
* @Package: io.github.bincool.utils.commons
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: StringUtils.java: �ַ���������.
* @Author wchy����������(891946049).
* @Date 2018��6��12�� ����9:01:03.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.utils.commons;

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
    
    /**
     * ��spliceSignƴ���ַ���.
     * @param spliceSign
     * 		ƴ�ӷ���.
     * @param strs
     * 		��ƴ�ӵ��ַ�������.
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
		
		StringBuffer sb = new StringBuffer();
		for(String str : strs) 
		{
			sb.append(str).append(spliceSign);
		}
		
		return sb.toString();
	}
    
}
