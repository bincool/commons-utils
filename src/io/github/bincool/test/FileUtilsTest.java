/**
* @FileName: FileUtilsTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: FileUtilsTest.java: common-io文件工具类测试.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月22日 上午10:35:42.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.test;

import java.io.File;

import org.apache.commons.io.FileUtils;

import io.github.bincool.test.base.BaseTest;
import io.github.bincool.utils.FileHelper;

/**
* @ClassName: FileUtilsTest.java
* 
* @Description: 
* <p>
* common-io文件工具类测试.
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
* @Date: 2018年6月22日 上午10:35:42.
* 
*/
public class FileUtilsTest extends BaseTest 
{
	
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
		String srcPathname = FileHelper.splicePathname(basePath, "a.txt");
		String destPathname = FileHelper.splicePathname(basePath, "b.txt");
		
		FileHelper.createFile(srcPathname);
		File srcFile = new File(srcPathname);
		
		File destFile = new File(destPathname);
		FileUtils.copyFile(srcFile, destFile);
	}

}
