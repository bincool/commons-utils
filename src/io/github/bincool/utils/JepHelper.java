/**
* @FileName: JepHelper.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: JepHelper.java: Jep帮助类.
* @Author wchy，技术交流(891946049).
* @Date 2018年7月12日 下午3:18:58.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.utils;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

import io.github.bincool.utils.commons.StringUtils;

/**
* @ClassName: JepHelper.java
* 
* @Description: 
* <p>
* Jep帮助类(Java expression parser).
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
* @Date: 2018年7月12日 下午3:18:58.
* 
*/
public class JepHelper 
{
	
	/**
	 * 私有构造函数.
	 */
	private JepHelper() 
	{
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * 智能计算不带参数的表达式的值.
	 * @param formula
	 * 		表达式.
	 * @return
	 * 		计算结果.
	 * @throws ParseException
	 * 		表达式解析计算异常.
	 */
	public static Object smartCal(String formula) throws ParseException 
	{
		Map<String, Object> params = null;
		return smartCal(formula, params);
	}
	
	/**
	 * 根据不带参数的条件表达式智能计算不带参数的表达式的值.
	 * @param formula
	 * 		条件表达式.
	 * @param formula
	 * 		表达式.
	 * @return
	 * 		计算结果.
	 * @throws ParseException
	 * 		表达式解析计算异常.
	 */
	public static Object smartCal(String condFormula, String formula) throws ParseException 
	{
		if (StringUtils.isNotEmpty(condFormula) && !smartCond(condFormula)) 
		{
			return null;
		} 
		
		return smartCal(formula);
	}
		
	/**
	 * 智能计算带参数的表达式的值.
	 * @param formula
	 * 		表达式.
	 * @param params
	 * 		参数变量值.
	 * @return
	 * 		计算结果.
	 * @throws ParseException
	 * 		表达式解析计算异常.
	 */
	public static Object smartCal(String formula, Map<String, Object> params) throws ParseException 
	{
		JEP jep = createJEP(params);
		Node node = jep.parse(formula);
		return jep.evaluate(node);
	}
	
	/**
	 * 根据条件表达式智能计算带参数的表达式的值.
	 * @param formula
	 * 		条件表达式.
	 * @param formula
	 * 		表达式.
	 * @param params
	 * 		参数变量值.
	 * @return
	 * 		计算结果.
	 * @throws ParseException
	 * 		表达式解析计算异常.
	 */
	public static Object smartCal(String condFormula, String formula, Map<String, Object> params) throws ParseException 
	{
		if (StringUtils.isNotEmpty(condFormula) && !smartCond(condFormula, params)) 
		{
			return null;
		} 
		
		return smartCal(formula, params);
	}
	
	/**
	 * 不带参数的智能条件判断.
	 * @param condFormula
	 * 		条件表达式.
	 * @return
	 * 		计算结果.
	 * @throws ParseException
	 * 		表达式解析计算异常.
	 */
	private static boolean smartCond(String condFormula) throws ParseException 
	{
		double result = (double)smartCal(condFormula);
		return result > 0;
	}
	
	/**
	 * 带参数的智能条件判断.
	 * @param condFormula
	 * 		条件表达式.
	 * @param params
	 * 		参数变量值.
	 * @return
	 * 		计算结果.
	 * @throws ParseException
	 * 		表达式解析计算异常.
	 */
	private static boolean smartCond(String condFormula, Map<String, Object> params) throws ParseException 
	{
		double result = (double)smartCal(condFormula, params);
		return result > 0;
	}
	
	/**
	 * 创建jep对象，当params不为空时，填充好变量.
	 * @param params
	 * 		参数变量值.
	 * @return
	 * 		jep对象.
	 */
	private static JEP createJEP(Map<String, Object> params) 
	{
		JEP jep = new JEP();
		
		// 空判断.
		if (null != params) 
		{
			Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
			while (iterator.hasNext()) 
			{
				Map.Entry<String, Object> entry = iterator.next();
				jep.addVariable(entry.getKey(), new BigDecimal(entry.getValue().toString()));
			}
		}
		
		return jep;
	}
	
}
