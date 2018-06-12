/**
* @FileName: ListTreeOperTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: ListTreeOperTest.java: List�������ݲ��������.
* @Author wchy����������(891946049).
* @Date 2018��6��12�� ����9:21:21.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.test;

import java.util.ArrayList;
import java.util.List;

import io.github.bincool.test.base.BaseTest;
import io.github.bincool.test.bean.Menu;
import io.github.bincool.utils.ListTreeOper;

/**
* @ClassName: ListTreeOperTest.java
* 
* @Description: 
* <p>
* List�������ݲ��������.
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
* @Date: 2018��6��12�� ����9:21:21.
* 
*/
public class ListTreeOperTest extends BaseTest 
{
	
	/**
     * list�������ݹ�����.
     */
	private ListTreeOper<Menu> listTreeOper;

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#setUp()
	 */
	@Override
	public void setUp() throws Exception 
	{
		listTreeOper = new ListTreeOper<Menu>();
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#tearDown()
	 */
	@Override
	public void tearDown() throws Exception 
	{
		listTreeOper = null;
	}

	/* (non-Javadoc)
	 * @see io.github.bincool.test.base.BaseTest#test()
	 */
	@Override
	public void test() 
	{
		List<Menu> rootList = new ArrayList<Menu>();
		rootList.add(new Menu("1", "0", "ϵͳ�˵�", "", "menu_icon_1001_bulletin.png"));
		
		List<Menu> dataList = new ArrayList<Menu>();
		dataList.add(new Menu("2", "1", "Ȩ������", "", "icon-user"));
		dataList.add(new Menu("3", "2", "��ɫȨ�޹���", "role/list", ""));
		dataList.add(new Menu("4", "2", "�û�����", "", ""));
		
		
		List<Menu> menuList = listTreeOper.getListTree(rootList, dataList);
		System.out.println(menuList);
	}

}
