/**
* @FileName: Menu.java
* @Package: io.github.bincool.test.bean
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: Menu.java: �˵�bean-����.
* @Author wchy����������(891946049).
* @Date 2018��6��12�� ����9:29:25.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.test.bean;

import io.github.bincool.bean.ListTreeBean;

/**
* @ClassName: Menu.java
* 
* @Description: 
* <p>
* �˵�bean-����.
* </p>
* <p>
* ��ϸ����:�����õ�bean.
* </p>
* <p>
* ʾ������.
* </p>
*
* @Author: wchy����������(891946049).
* 
* @Date: 2018��6��12�� ����9:29:25.
* 
*/
@SuppressWarnings("rawtypes")
public class Menu extends ListTreeBean 
{

	/**
	 * ���а汾��.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * �˵���.
	 */
	private String name;
	
	/**
	 * �˵�����.
	 */
	private String url;
	
	/**
	 * �˵�ͼ��.
	 */
	private String icon;

	/**
	 * ���췽��.
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
	 * ��ȡname.
	 * @return
	 *     name.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * ����name.
	 * @param
	 *     name.
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * ��ȡurl.
	 * @return
	 *     url.
	 */
	public String getUrl() 
	{
		return url;
	}

	/**
	 * ����url.
	 * @param
	 *     url.
	 */
	public void setUrl(String url) 
	{
		this.url = url;
	}

	/**
	 * ��ȡicon.
	 * @return
	 *     icon.
	 */
	public String getIcon() 
	{
		return icon;
	}

	/**
	 * ����icon.
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
