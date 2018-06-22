/**
* @FileName: FileHelperTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: FileHelperTest.java: 文件帮助类测试.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月22日 下午4:42:49.
* @Content: 新增.
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
* 文件帮助类测试.
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
* @Date: 2018年6月22日 下午4:42:49.
* 
*/
public class FileHelperTest extends BaseTest 
{

	/**
	 * 基路径.
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
	 * 删除文件测试.
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
	 * 移动文件测试.
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
