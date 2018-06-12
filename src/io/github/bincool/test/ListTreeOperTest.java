/**
* @FileName: ListTreeOperTest.java
* @Package: io.github.bincool.test
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: ListTreeOperTest.java: List树形数据操作类测试.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午9:21:21.
* @Content: 新增.
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
* List树形数据操作类测试.
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
* @Date: 2018年6月12日 下午9:21:21.
* 
*/
public class ListTreeOperTest extends BaseTest 
{
	
	/**
     * list树形数据工具类.
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
		rootList.add(new Menu("1", "0", "系统菜单", "", "menu_icon_1001_bulletin.png"));
		
		List<Menu> dataList = new ArrayList<Menu>();
		dataList.add(new Menu("2", "1", "权限配置", "", "icon-user"));
		dataList.add(new Menu("3", "2", "角色权限管理", "role/list", ""));
		dataList.add(new Menu("4", "2", "用户管理", "", ""));
		
		
		List<Menu> menuList = listTreeOper.getListTree(rootList, dataList);
		System.out.println(menuList);
	}

}
