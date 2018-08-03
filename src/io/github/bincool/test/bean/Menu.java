/**
* @FileName: Menu.java
* @Package: io.github.bincool.test.bean
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: Menu.java: 菜单bean-测试.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午9:29:25.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.test.bean;

import io.github.bincool.bean.ListTreeBean;

/**
* @ClassName: Menu.java
* 
* @Description: 
* <p>
* 菜单bean-测试.
* </p>
* <p>
* 详细描述:测试用的bean.
* </p>
* <p>
* 示例代码.
* </p>
*
* @Author: wchy，技术交流(891946049).
* 
* @Date: 2018年6月12日 下午9:29:25.
* 
*/
@SuppressWarnings("rawtypes")
public class Menu extends ListTreeBean 
{

	/**
	 * 序列版本号.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 菜单名.
	 */
	private String name;
	
	/**
	 * 菜单链接.
	 */
	private String url;
	
	/**
	 * 菜单图标.
	 */
	private String icon;

	/**
	 * 构造方法.
	 * @param id
	 * @param parentId
	 * @param name
	 * @param url
	 * @param icon
	 */
	public Menu(String id, String parentId, String name, String url, String icon) 
	{
		super();
		super.setId(id);
		super.setParentId(parentId);
		this.name = name;
		this.url = url;
		this.icon = icon;
	}

	/**
	 * 获取name.
	 * @return
	 *     name.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * 设置name.
	 * @param
	 *     name.
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * 获取url.
	 * @return
	 *     url.
	 */
	public String getUrl() 
	{
		return url;
	}

	/**
	 * 设置url.
	 * @param
	 *     url.
	 */
	public void setUrl(String url) 
	{
		this.url = url;
	}

	/**
	 * 获取icon.
	 * @return
	 *     icon.
	 */
	public String getIcon() 
	{
		return icon;
	}

	/**
	 * 设置icon.
	 * @param
	 *     icon.
	 */
	public void setIcon(String icon) 
	{
		this.icon = icon;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Menu [name=" + name + ", url=" + url + ", icon=" + icon + ", getId()=" + getId() + ", getParentId()="
				+ getParentId() + ", getChildList()=" + getChildList() + "]";
	}

}
