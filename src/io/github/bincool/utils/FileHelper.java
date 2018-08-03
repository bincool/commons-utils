/**
* @FileName: FileHelper.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: FileHelper.java: 文件帮助类.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月22日 上午11:00:10.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import io.github.bincool.utils.commons.StringUtils;
import io.github.bincool.utils.commons.UtilRuntimeException;

/**
* @ClassName: FileHelper.java
* 
* @Description: 
* <p>
* 文件帮助类.
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
* @Date: 2018年6月22日 上午11:00:10.
* 
*/
public class FileHelper 
{

	/**
	 * 私有构造函数.
	 */
	private FileHelper() 
	{
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 拼接路径名.
	 * @param pathnames
	 * 		路径名数组.
	 */
	public static String splicePathname(String... pathnames) 
	{
		return StringUtils.spliceStr(File.separator, pathnames);
	}

	/**
	 * 创建文件,当文件已经存在时不创建.
	 * @param fileName
	 * 		文件全路径.
	 * @throws IOException
	 * 		创建文件异常.
	 */
	public static void createFile(String pathname) throws IOException 
	{
		File file = new File(pathname);

		// 创建路径.
		File parentFile = file.getParentFile();
		if (!parentFile.exists() && !parentFile.mkdirs()) 
		{
			throw new UtilRuntimeException("The tool is running abnormally. Make dirs fail.");
		}

		// 创建文件.
		if (!file.exists() && !file.createNewFile()) 
		{
			throw new IOException("Create file fail.");
		}
	}

	/**
	 * 复制srcFile文件到destFile文件.
	 * @param srcPathname
	 * 		srcFile文件的全路径.
	 * @param destPathname
	 * 		destFile文件的全路径.
	 * @throws IOException
	 * 		文件操作异常.
	 */
	public static void copyFile(String srcPathname, String destPathname) throws IOException 
	{
		createFile(srcPathname);
		File srcFile = new File(srcPathname);
		File destFile = new File(destPathname);
		FileUtils.copyFile(srcFile, destFile);
	}

	/**
	 * 移动srcFile文件到destFile文件.
	 * @param srcPathname
	 * 		srcFile文件的全路径.
	 * @param destPathname
	 * 		destFile文件的全路径.
	 * @throws IOException
	 * 		文件操作异常.
	 */
	public static void moveFile(String srcPathname, String destPathname) throws IOException 
	{
		File srcFile = new File(srcPathname);
		File destFile = new File(destPathname);
		FileUtils.moveFile(srcFile, destFile);
	}

	/**
	 * 删除文件.
	 * @param delPathname
	 * 		delFile文件的全路径.
	 * @throws IOException
	 * 		文件操作异常.
	 */
	public static void deleteFile(String delPathname) throws IOException 
	{
		File delFile = new File(delPathname);
		FileUtils.forceDelete(delFile);
	}

	/**
	 * 写入文件内容.
	 * @param srcPathname
	 * 		srcFile文件的全路径.
	 * @param context
	 * 		内容.
	 * @param append
	 * 		追加.
	 * @throws IOException
	 * 		文件操作异常.
	 */
	public static void writeStringToFile(String srcPathname, String context, boolean append) throws IOException 
	{
		File srcFile = new File(srcPathname);
		FileUtils.writeStringToFile(srcFile, context, append);
	}

	/**
	 * 读取文件到字符串.
	 * @param srcPathname
	 * 		srcFile文件的全路径.
	 * @throws IOException
	 * 		文件操作异常.
	 */
	public static String readFileToString(String srcPathname) throws IOException 
	{
		File srcFile = new File(srcPathname);
		return FileUtils.readFileToString(srcFile);
	}

	/**
	 * 读取文件到list.
	 * @param srcPathname
	 * 		srcFile文件的全路径.
	 * @throws IOException
	 * 		文件操作异常.
	 */
	public static List<String> readLines(String srcPathname) throws IOException 
	{
		File srcFile = new File(srcPathname);
		return FileUtils.readLines(srcFile);
	}

}
