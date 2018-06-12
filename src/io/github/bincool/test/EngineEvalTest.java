/**
* @FileName: EngineEvalTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: EngineEvalTest.java: �����㷨��Js����ִ�м�����ʽ����.
* @Author wchy����������(891946049).
* @Date 2018��6��12�� ����10:09:43.
* @Content: ����.
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
* �����㷨��Js����ִ�м�����ʽ����.
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
* @Date: 2018��6��12�� ����10:09:43.
* 
*/
public class EngineEvalTest extends BaseTest 
{

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#setUp()
	 */
	@Override
	public void setUp() throws Exception 
	{
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#tearDown()
	 */
	@Override
	public void tearDown() throws Exception 
	{
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#test()
	 */
	@Override
	public void test() throws Exception 
	{
		// 1 ����׼��.
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("����", 6);
		params.put("��", 5);
		params.put("��", 3);
		
		// 2 ���ʽ׼������ͨ�����ݲ�ѯ���������죬����return�ı��ʽ������Ӣ�Ķ��Ž���(����ƥ�����������).
		// return��Ҫ����if������֧��function����֮�У���ֻ��һ�����ʽ(û�з�֧�ж�Ҳ���Ǻ���)ʱֱ����дһ�б��ʽ����������ӽ�����.
		// formula = "if([��]>300){return 5;}else{return 6;}";
		// formula = "function cal() { return 100;}";
		String formula = "[����]*[��]*[��]";
		
		// 3.1 ���ܼ�����.
		Object calResult = EngineEvalUtils.smartCal(formula, params);
		System.out.println(calResult);
		
		
		// 3.2 ���ܻ�ȡ���ʽ�������.
		Object formulaResult = EngineEvalUtils.smartFormula(formula, params);
		System.out.println(formulaResult);
	}

}
