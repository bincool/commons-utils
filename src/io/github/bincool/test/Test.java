/**
* @FileName: Test.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: Test.java: 测试类.
* @Author wchy，技术交流(891946049).
* @Date 2018年8月7日 上午10:04:11.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.test;

import java.io.File;
import java.util.Collection;

import io.github.bincool.test.base.BaseTest;
import io.github.bincool.utils.FileHelper;

/**
* @ClassName: Test.java
* 
* @Description: 
* <p>
* 测试类.
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
* @Date: 2018年8月7日 上午10:04:11.
* 
*/
public class Test extends BaseTest 
{
	
	/**
	 * 基路径.
	 */
	private String srcDirectory = null;

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#setUp()
	 */
	@Override
	public void setUp() throws Exception 
	{
		srcDirectory = FileHelper.splicePathname(PROJECT_ROOT_PATH , "src");
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#tearDown()
	 */
	@Override
	public void tearDown() throws Exception 
	{
		srcDirectory = null;
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#test()
	 */
	@Override
	public void test() throws Exception 
	{
		Collection<File> files = FileHelper.listDirs(srcDirectory);
		for (File file : files) 
		{
			LOGGER.info(file.getAbsolutePath());
		}
		
		LOGGER.warn("{}{}", System.getProperty("user.home"), "sss");
		LOGGER.error("{}{}", System.getProperty("user.home"), "sss");
	}

}
