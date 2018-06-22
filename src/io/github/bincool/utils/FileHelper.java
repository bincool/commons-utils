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

import org.apache.commons.io.FileUtils;

import io.github.bincool.utils.commons.StringUtils;

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
		
		File parentFile = file.getParentFile();
        if (!parentFile.exists()) 
        {
            parentFile.mkdirs();
        }
		
		if (!file.exists()) 
		{
			file.createNewFile();
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
	
}
