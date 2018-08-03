/**
* @FileName: EncodingUtil.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: EncodingUtil.java: 字符编码工具类.
* @Author wchy，技术交流(891946049).
* @Date 2018年8月2日 下午2:10:23.
* @Content: 新增.
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
* 字符编码工具类.
* </p>
* <p>
* 详细描述.
* </p>
* <p>
* 示例代码.
* </p>
*
* @Author: wchy，技术交流(891946049).
* 
* @Date: 2018年8月2日 下午2:10:23.
* 
*/
public class EncodingUtil 
{
	
	/**
	 * 私有构造函数.
	 */
	private EncodingUtil() 
	{
	}
	
	/**
	 * 文件编码转换.
	 * @param srcPathname
	 * 		源文件路径.
	 * @param destPathname
	 * 		转换后的文件路径.
	 * @param destEncoding
	 * 		转换后的文件编码.
	 * @throws IOException
	 */
	public static void conversionEncoding(String srcPathname, String destPathname, String destEncoding) throws IOException 
	{
		String srcEncoding = getJavaEncode(srcPathname);
		List<String> context = FileUtils.readLines(new File(srcPathname), srcEncoding);
		FileUtils.writeLines(new File(destPathname), destEncoding, context);
	}
	
	/**
	 * 获取文件编码.获取失败则返回UTF_8.
	 * @param pathname
	 * 		文件路径.
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String getJavaEncode(String pathname) throws FileNotFoundException 
	{
		String encoding = null;
		
		// 读取文件到缓存输入流中.
		InputStream fInputStream = new FileInputStream(pathname);
		InputStream buffIn = new BufferedInputStream(fInputStream);
		
		// 获取文件编码.
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
