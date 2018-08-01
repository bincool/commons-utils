/**
* @FileName: JepHelper.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: JepHelper.java: Jep������.
* @Author wchy����������(891946049).
* @Date 2018��7��12�� ����3:18:58.
* @Content: ����.
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
* Jep������(Java expression parser).
* </p>
* <p>
* ��ϸ����.
* </p>
* <p>
* ʾ������.
* </p>
*
* @Author: wchy����������(891946049).
* 
* @Date: 2018��7��12�� ����3:18:58.
* 
*/
public class JepHelper 
{
	
	/**
	 * ˽�й��캯��.
	 */
	private JepHelper() 
	{
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * ���ܼ��㲻�������ı��ʽ��ֵ.
	 * @param formula
	 * 		���ʽ.
	 * @return
	 * 		������.
	 * @throws ParseException
	 * 		���ʽ���������쳣.
	 */
	public static Object smartCal(String formula) throws ParseException 
	{
		Map<String, Object> params = null;
		return smartCal(formula, params);
	}
	
	/**
	 * ���ݲ����������������ʽ���ܼ��㲻�������ı��ʽ��ֵ.
	 * @param formula
	 * 		�������ʽ.
	 * @param formula
	 * 		���ʽ.
	 * @return
	 * 		������.
	 * @throws ParseException
	 * 		���ʽ���������쳣.
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
	 * ���ܼ���������ı��ʽ��ֵ.
	 * @param formula
	 * 		���ʽ.
	 * @param params
	 * 		��������ֵ.
	 * @return
	 * 		������.
	 * @throws ParseException
	 * 		���ʽ���������쳣.
	 */
	public static Object smartCal(String formula, Map<String, Object> params) throws ParseException 
	{
		JEP jep = createJEP(params);
		Node node = jep.parse(formula);
		return jep.evaluate(node);
	}
	
	/**
	 * �����������ʽ���ܼ���������ı��ʽ��ֵ.
	 * @param formula
	 * 		�������ʽ.
	 * @param formula
	 * 		���ʽ.
	 * @param params
	 * 		��������ֵ.
	 * @return
	 * 		������.
	 * @throws ParseException
	 * 		���ʽ���������쳣.
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
	 * �������������������ж�.
	 * @param condFormula
	 * 		�������ʽ.
	 * @return
	 * 		������.
	 * @throws ParseException
	 * 		���ʽ���������쳣.
	 */
	private static boolean smartCond(String condFormula) throws ParseException 
	{
		double result = (double)smartCal(condFormula);
		return result > 0;
	}
	
	/**
	 * �����������������ж�.
	 * @param condFormula
	 * 		�������ʽ.
	 * @param params
	 * 		��������ֵ.
	 * @return
	 * 		������.
	 * @throws ParseException
	 * 		���ʽ���������쳣.
	 */
	private static boolean smartCond(String condFormula, Map<String, Object> params) throws ParseException 
	{
		double result = (double)smartCal(condFormula, params);
		return result > 0;
	}
	
	/**
	 * ����jep���󣬵�params��Ϊ��ʱ�����ñ���.
	 * @param params
	 * 		��������ֵ.
	 * @return
	 * 		jep����.
	 */
	private static JEP createJEP(Map<String, Object> params) 
	{
		JEP jep = new JEP();
		
		// ���ж�.
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
