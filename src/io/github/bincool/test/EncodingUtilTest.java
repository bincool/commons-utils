/**
* @FileName: EncodingUtilTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: EncodingUtilTest.java: 字符集编码工具测试类.
* @Author wchy，技术交流(891946049).
* @Date 2018年8月3日 下午5:06:00.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.test;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

import io.github.bincool.encodingdetect.CharsetEncoding;
import io.github.bincool.test.base.BaseTest;
import io.github.bincool.utils.EncodingUtil;

/**
* @ClassName: EncodingUtilTest.java
* 
* @Description: 
* <p>
* 字符集编码工具测试类.
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
* @Date: 2018年8月3日 下午5:06:00.
* 
*/
public class EncodingUtilTest extends BaseTest 
{
	
	/**
	 * 源码路径.
	 */
	private static final String SRC_DIR_PATH = System.getProperty("user.dir").replace("commons-utils", "{project-name}\\src");
	
	/**
	 * 待转换编码的项目名.
	 */
	private static final String[] PROJECT_NAMES = 
		{
			"commons-encoding",
			"commons-utils", 
			"data-structure",
			"horserace",
			"javase-study",
			"notepad",
			"qrdoc",
			"tools-secret",
			};
	
	/**
	 * 转换后的文件编码.
	 */
	private static final String DEST_ENCODING = CharsetEncoding.UTF_8;
	
	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#setUp()
	 */
	@Override
	public void setUp() 
	{
		LOGGER.info("setUp");
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#tearDown()
	 */
	@Override
	public void tearDown() 
	{
		LOGGER.info("tearDown");
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#test()
	 */
	@Override
	public void test() throws Exception 
	{
		// 将项目编码格式转换成UTF-8.
		for (String PROJECT_NAME : PROJECT_NAMES) 
		{
			String scanPath = SRC_DIR_PATH.replace("{project-name}", PROJECT_NAME);
			
			Collection<File> javaFiles =  FileUtils.listFiles(new File(scanPath), new String[]{"java"}, true);
			
			for (File javaFile : javaFiles) 
			{
				LOGGER.info(javaFile.getPath());
				// 编码转换成UTF-8.
				EncodingUtil.conversionEncoding(javaFile.getPath(), javaFile.getPath(), DEST_ENCODING);
			}
		}
		
	}

}
