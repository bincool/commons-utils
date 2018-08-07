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
	private String basePath = null;

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#setUp()
	 */
	@Override
	public void setUp()
	{
		basePath = FileHelper.splicePathname(PROJECT_ROOT_PATH , "file" , "test");
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
		
		// 拷贝文件测试.
		FileHelper.copyFile(srcPathname, destPathname);
		
		// 删除文件测试.
		FileHelper.deleteFile(srcPathname);
		
		// 移动文件测试.
		srcPathname = StringUtils.spliceStr("", basePath, "a1.txt");
		destPathname = StringUtils.spliceStr("", basePath, "b1.txt");
		
		FileHelper.createFile(srcPathname);
		FileHelper.moveFile(srcPathname, destPathname);
		
		// 写文件测试.
		srcPathname = StringUtils.spliceStr("", basePath, "a11.txt");
		
		FileHelper.createFile(srcPathname);
		FileHelper.writeStringToFile(srcPathname, "Hello ", true);
		FileHelper.writeStringToFile(srcPathname, "World!\n", false);
	}
	
	/**
	 * 测试FileUtils.
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
