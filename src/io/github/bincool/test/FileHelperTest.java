/**
* @FileName: FileHelperTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: FileHelperTest.java: �ļ����������.
* @Author wchy����������(891946049).
* @Date 2018��6��22�� ����4:42:49.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import io.github.bincool.test.base.BaseTest;
import io.github.bincool.utils.FileHelper;
import io.github.bincool.utils.commons.StringUtils;

/**
* @ClassName: FileHelperTest.java
* 
* @Description: 
* <p>
* �ļ����������.
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
* @Date: 2018��6��22�� ����4:42:49.
* 
*/
public class FileHelperTest extends BaseTest 
{

	/**
	 * ��·��.
	 */
	private String basePath = null;

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#setUp()
	 */
	@Override
	public void setUp()
	{
		basePath = FileHelper.splicePathname(System.getProperty("user.dir") , "file" , "test");
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#tearDown()
	 */
	@Override
	public void tearDown()
	{
		basePath = null;
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#test()
	 */
	@Override
	public void test() throws Exception 
	{
		String srcPathname = StringUtils.spliceStr("", basePath, "a.txt");
		String destPathname = StringUtils.spliceStr("", basePath, "b.txt");
		
		// �����ļ�����.
		FileHelper.copyFile(srcPathname, destPathname);
		
		// ɾ���ļ�����.
		FileHelper.deleteFile(srcPathname);
		
		// �ƶ��ļ�����.
		srcPathname = StringUtils.spliceStr("", basePath, "a1.txt");
		destPathname = StringUtils.spliceStr("", basePath, "b1.txt");
		
		FileHelper.createFile(srcPathname);
		FileHelper.moveFile(srcPathname, destPathname);
		
		// д�ļ�����.
		srcPathname = StringUtils.spliceStr("", basePath, "a11.txt");
		
		FileHelper.createFile(srcPathname);
		FileHelper.writeStringToFile(srcPathname, "Hello ", true);
		FileHelper.writeStringToFile(srcPathname, "World!\n", false);
	}
	
	/**
	 * ����FileUtils.
	 * @throws IOException
	 */
	@Test
	public void testFileUtils() throws IOException 
	{
		String srcPathname = StringUtils.spliceStr("", basePath, "a.txt");
		String destPathname = StringUtils.spliceStr("", basePath, "b.txt");
		
		FileHelper.createFile(srcPathname);
		
		File srcFile = new File(srcPathname);
		
		File destFile = new File(destPathname);
		FileUtils.copyFile(srcFile, destFile);
	}

}
