/**
* @FileName: MakeRandCodeTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: MakeRandCodeTest.java: �����������������.
* @Author wchy����������(891946049).
* @Date 2018��6��12�� ����3:50:56.
* @Content: ����.
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
* �����������������.
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
* @Date: 2018��6��12�� ����3:50:56.
* 
*/
public class MakeRandCodeTest extends BaseTest
{
	
	/**
	 * ����ֿ����.
	 */
	private MakeRandCode randCodes;

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#setUp()
	 */
	@Override
	public void setUp()
	{
		randCodes = new MakeRandCode(1, 0);
		
		// ��ʼ�������ֿ�.
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
