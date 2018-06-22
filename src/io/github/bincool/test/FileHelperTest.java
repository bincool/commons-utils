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
	private String basePath = "";

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#setUp()
	 */
	@Override
	public void setUp() throws Exception 
	{
		basePath = FileHelper.splicePathname(System.getProperty("user.dir") , "file" , "test");
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#tearDown()
	 */
	@Override
	public void tearDown() throws Exception 
	{
		basePath = "";
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#test()
	 */
	@Override
	public void test() throws Exception 
	{
		String srcPathname = StringUtils.spliceStr("", basePath, "a.txt");
		String destPathname = StringUtils.spliceStr("", basePath, "b.txt");
		
		FileHelper.copyFile(srcPathname, destPathname);
	}
	
	/**
	 * ɾ���ļ�����.
	 * @throws Exception
	 */
	@Test
	public void testDeleteFile() throws Exception 
	{
		String srcPathname = StringUtils.spliceStr("", basePath, "a.txt");
		String destPathname = StringUtils.spliceStr("", basePath, "b.txt");
		
		FileHelper.copyFile(srcPathname, destPathname);
		FileHelper.deleteFile(srcPathname);
	}
	
	/**
	 * �ƶ��ļ�����.
	 * @throws Exception
	 */
	@Test
	public void testMoveFile() throws Exception 
	{
		String srcPathname = StringUtils.spliceStr("", basePath, "a1.txt");
		String destPathname = StringUtils.spliceStr("", basePath, "b1.txt");
		
		FileHelper.createFile(srcPathname);
		FileHelper.moveFile(srcPathname, destPathname);
	}
	
	@Test
	public void testWriteFile() throws Exception 
	{
		String srcPathname = StringUtils.spliceStr("", basePath, "a11.txt");
		
		FileHelper.createFile(srcPathname);
		FileHelper.writeStringToFile(srcPathname, "Hello ");
		FileHelper.writeStringToFile(srcPathname, "World!\n");
	}

}
