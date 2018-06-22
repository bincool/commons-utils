/**
* @FileName: FileHelperTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: FileHelperTest.java: TODO 一句话描述文件的作用.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月22日 下午4:42:49.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.test;

import io.github.bincool.test.base.BaseTest;
import io.github.bincool.utils.FileHelper;
import io.github.bincool.utils.commons.StringUtils;

/**
* @ClassName: FileHelperTest.java
* 
* @Description: 
* <p>
* TODO 一句话对这个类进行描述.
* </p>
* <p>
* TODO 详细描述.
* </p>
* <p>
* TODO 示例代码.
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

		System.out.println(srcPathname);
		FileHelper.copyFile(srcPathname, destPathname);
	}

}
