/**
* @FileName: BaseTest.java
* @Package: io.github.bincool.test.base
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: BaseTest.java: 测试基类.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午3:52:14.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.test.base;


import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* @ClassName: BaseTest.java
* 
* @Description: 
* <p>
* 测试基类.
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
* @Date: 2018年6月12日 下午3:52:14.
* 
*/
public abstract class BaseTest 
{
	
	/**
	 * 日志对象.
	 */
	protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
	
	/**
	 * 项目根路径.
	 */
	protected static final String PROJECT_ROOT_PATH = System.getProperty("user.dir");
	
	/**
	 * 参数map.
	 */
	protected static final Map<String, Object> PARAMS = new HashMap<>();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public abstract void setUp() throws Exception;

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public abstract void tearDown() throws Exception;

	@Test
	public abstract void test() throws Exception;

}
