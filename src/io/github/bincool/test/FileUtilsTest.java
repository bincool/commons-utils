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
import io.github.bincool.utils.commons.StringUtils;

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
	
	/**
	 * 基路径.
	 */
	private String basePath = "";

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
		
		FileHelper.createFile(srcPathname);
		
		File srcFile = new File(srcPathname);
		
		File destFile = new File(destPathname);
		FileUtils.copyFile(srcFile, destFile);
	}

}
