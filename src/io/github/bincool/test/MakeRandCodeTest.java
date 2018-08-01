/**
* @FileName: MakeRandCodeTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: MakeRandCodeTest.java: 随机码生成器测试类.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午3:50:56.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.test;

import io.github.bincool.test.base.BaseTest;
import io.github.bincool.utils.MakeRandCode;

/**
* @ClassName: MakeRandCodeTest.java
* 
* @Description: 
* <p>
* 随机码生成器测试类.
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
* @Date: 2018年6月12日 下午3:50:56.
* 
*/
public class MakeRandCodeTest extends BaseTest
{
	
	/**
	 * 随机仓库对象.
	 */
	private MakeRandCode randCodes;

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#setUp()
	 */
	@Override
	public void setUp()
	{
		randCodes = new MakeRandCode(1, 0);
		
		// 初始化随机码仓库.
		randCodes.createRandCode(100);
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#tearDown()
	 */
	@Override
	public void tearDown()
	{
		randCodes = null;
		
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#test()
	 */
	@Override
	public void test() 
	{
		for (int i = 0; i < 100; i++) 
		{
			LOGGER.info(randCodes.obtainRandCode());
		}
		
	}

}
