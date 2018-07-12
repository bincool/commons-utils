/**
* @FileName: JepHelperTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: JepHelperTest.java: JepHelper�����.
* @Author wchy����������(891946049).
* @Date 2018��7��12�� ����4:59:21.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import io.github.bincool.test.base.BaseTest;
import io.github.bincool.utils.JepHelper;

/**
* @ClassName: JepHelperTest.java
* 
* @Description: 
* <p>
* JepHelper�����.
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
* @Date: 2018��7��12�� ����4:59:21.
* 
*/
public class JepHelperTest extends BaseTest 
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
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("x", 3);
		Object obj1 = JepHelper.smartCal("20*5+123");
		Object obj2 = JepHelper.smartCal("200%2==0", "1/3*25");
		Object obj3 = JepHelper.smartCal("999999999999999+x", params);
		BigDecimal bg = new BigDecimal(obj3.toString());
		
		Object obj4 = JepHelper.smartCal("x!=0", "(2*x^2+x+1)/x", params);
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(bg.toPlainString());
		System.out.println(obj4.toString());
	}

}
