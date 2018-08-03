/**
* @FileName: EncodingUtil.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: EncodingUtil.java: �ַ����빤����.
* @Author wchy����������(891946049).
* @Date 2018��8��2�� ����2:10:23.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

import io.github.bincool.encodingdetect.CharsetEncoding;
import io.github.bincool.encodingdetect.EncodingDetect;

/**
* @ClassName: EncodingUtil.java
* 
* @Description: 
* <p>
* �ַ����빤����.
* </p>
* <p>
* ��ϸ����.
* </p>
* <p>
* ʾ������.
* </p>
*
* @Author: wchy����������(891946049).
* 
* @Date: 2018��8��2�� ����2:10:23.
* 
*/
public class EncodingUtil 
{
	
	/**
	 * ˽�й��캯��.
	 */
	private EncodingUtil() 
	{
	}
	
	/**
	 * �ļ�����ת��.
	 * @param srcPathname
	 * 		Դ�ļ�·��.
	 * @param destPathname
	 * 		ת������ļ�·��.
	 * @param destEncoding
	 * 		ת������ļ�����.
	 * @throws IOException
	 */
	public static void conversionEncoding(String srcPathname, String destPathname, String destEncoding) throws IOException 
	{
		String srcEncoding = getJavaEncode(srcPathname);
		List<String> context = FileUtils.readLines(new File(srcPathname), srcEncoding);
		FileUtils.writeLines(new File(destPathname), destEncoding, context);
	}
	
	/**
	 * ��ȡ�ļ�����.��ȡʧ���򷵻�UTF_8.
	 * @param pathname
	 * 		�ļ�·��.
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String getJavaEncode(String pathname) throws FileNotFoundException 
	{
		String encoding = null;
		
		// ��ȡ�ļ���������������.
		InputStream fInputStream = new FileInputStream(pathname);
		InputStream buffIn = new BufferedInputStream(fInputStream);
		
		// ��ȡ�ļ�����.
		try 
		{
			Charset charset = EncodingDetect.getEncoding(buffIn);
			encoding = charset.name();
		} 
		catch (IOException e) 
		{
			encoding = CharsetEncoding.UTF_8;
		}
		
		return encoding;
	}
	
}
