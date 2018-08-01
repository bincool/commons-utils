/**
* @FileName: EngineEvalTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: EngineEvalTest.java: 智能算法，Js引擎执行计算表达式测试.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午10:09:43.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.test;

import java.util.HashMap;
import java.util.Map;

import io.github.bincool.test.base.BaseTest;
import io.github.bincool.utils.EngineEvalUtils;

/**
* @ClassName: EngineEvalTest.java
* 
* @Description: 
* <p>
* 智能算法，Js引擎执行计算表达式测试.
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
* @Date: 2018年6月12日 下午10:09:43.
* 
*/
public class EngineEvalTest extends BaseTest 
{
	
	/**
	 * 1 参数准备.
	 */
	private Map<String, Object> params;
	
	/**
	 * 2 表达式准备：可通过数据查询或自主构造，其中return的表达式后需用英文逗号结束(用于匹配具体计算过程).
	 * return主要用于if条件分支和function函数之中，当只有一个表达式(没有分支判断也不是函数)时直接书写一行表达式即可毋须添加结束符.
	 * 例如：formula = "if([长]>300){return 5;}else{return 6;}";
	 * 例如：formula = "function cal() { return 100;}";
	 */
	private static final String FORMULA = "[个数]*[长]*[高]";
	
	

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#setUp()
	 */
	@Override
	public void setUp()
	{
		params = new HashMap<>();
		params.put("个数", 6);
		params.put("长", 5);
		params.put("高", 3);
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#tearDown()
	 */
	@Override
	public void tearDown()
	{
		params = null;
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#test()
	 */
	@Override
	public void test() throws Exception
	{
		// 3.1 智能计算结果.
		Object calResult = EngineEvalUtils.smartCal(FORMULA, params);
		LOGGER.info(calResult);
		
		// 3.2 智能获取表达式计算过程.
		Object formulaResult = EngineEvalUtils.smartFormula(FORMULA, params);
		LOGGER.info(formulaResult);
	}

}
