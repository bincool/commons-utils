/**
* @FileName: FileHelper.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: FileHelper.java: �ļ�������.
* @Author wchy����������(891946049).
* @Date 2018��6��22�� ����11:00:10.
* @Content: ����.
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
* �ļ�������.
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
* @Date: 2018��6��22�� ����11:00:10.
* 
*/
public class FileHelper 
{
	
	/**
	 * ˽�й��캯��.
	 */
	private FileHelper() 
	{
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * ƴ��·����.
	 * @param pathnames
	 * 		·��������.
	 */
	public static String splicePathname(String ...pathnames)  
	{
		return StringUtils.spliceStr(File.separator, pathnames);
	}
	
	/**
	 * �����ļ�,���ļ��Ѿ�����ʱ������.
	 * @param fileName
	 * 		�ļ�ȫ·��.
	 * @throws IOException 
	 * 		�����ļ��쳣.
	 */
	public static void createFile(String pathname) throws IOException 
	{
		File file = new File(pathname);
		
		// ����·��.
		File parentFile = file.getParentFile();
		if (!parentFile.exists() && !parentFile.mkdirs()) 
		{
			throw new UtilRuntimeException("The tool is running abnormally. Make dirs fail.");
		}
		
		// �����ļ�.
		if (!file.exists() && !file.createNewFile()) 
		{
			throw new IOException("Create file fail.");
		}
	}
	
	/**
	 * ����srcFile�ļ���destFile�ļ�.
	 * @param srcPathname
	 * 		srcFile�ļ���ȫ·��.
	 * @param destPathname
	 * 		destFile�ļ���ȫ·��.
	 * @throws IOException
	 * 		�ļ������쳣.
	 */
	public static void copyFile(String srcPathname, String destPathname) throws IOException 
	{
		createFile(srcPathname);
		File srcFile = new File(srcPathname);
		File destFile = new File(destPathname);
        FileUtils.copyFile(srcFile, destFile);
    }
	
	/**
	 * �ƶ�srcFile�ļ���destFile�ļ�.
	 * @param srcPathname
	 * 		srcFile�ļ���ȫ·��.
	 * @param destPathname
	 * 		destFile�ļ���ȫ·��.
	 * @throws IOException
	 * 		�ļ������쳣.
	 */
	public static void moveFile(String srcPathname, String destPathname) throws IOException 
	{
		File srcFile = new File(srcPathname);
		File destFile = new File(destPathname);
		FileUtils.moveFile(srcFile, destFile);
	}
	
	/**
	 * ɾ���ļ�.
	 * @param delPathname
	 * 		delFile�ļ���ȫ·��.
	 * @throws IOException
	 * 		�ļ������쳣.
	 */
	public static void deleteFile(String delPathname) throws IOException 
	{
		File delFile = new File(delPathname);
		FileUtils.forceDelete(delFile);
	}
	
	/**
	 * д���ļ�����.
	 * @param srcPathname
	 * 		srcFile�ļ���ȫ·��.
	 * @param context
	 * 		����.
	 * @param append
	 * 		׷��.
	 * @throws IOException
	 * 		�ļ������쳣.
	 */
	public static void writeStringToFile(String srcPathname, String context, boolean append) throws IOException 
	{
		File srcFile = new File(srcPathname);
		FileUtils.writeStringToFile(srcFile, context, append);
	}
	
	/**
	 * ��ȡ�ļ����ַ���.
	 * @param srcPathname
	 * 		srcFile�ļ���ȫ·��.
	 * @throws IOException
	 * 		�ļ������쳣.
	 */
	public static String readFileToString(String srcPathname) throws IOException 
	{
		File srcFile = new File(srcPathname);
        return FileUtils.readFileToString(srcFile);
	}
	
	/**
	 * ��ȡ�ļ���list.
	 * @param srcPathname
	 * 		srcFile�ļ���ȫ·��.
	 * @throws IOException
	 * 		�ļ������쳣.
	 */
	public static List<String> readLines(String srcPathname) throws IOException 
	{
		File srcFile = new File(srcPathname);
		return FileUtils.readLines(srcFile);
	}
	
}
