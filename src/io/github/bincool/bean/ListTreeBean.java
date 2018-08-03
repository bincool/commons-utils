/**
* @FileName: ListTreeBean.java
* @Package: io.github.bincool.bean
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: ListTreeBean.java: List树形数据基类bean.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午8:49:27.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.bean;

import java.io.Serializable;
import java.util.List;

/**
* @ClassName: ListTreeBean.java
* 
* @Description: 
* <p>
* List树形数据基类bean.
* </p>
* <p>
* 详细描述：List树形数据基类bean：菜单森林、组织结构树、多级联动(省市县区乡)、分销推广层级森林.
* </p>
* <p>
* 示例代码.
* </p>
*
* @Author: wchy，技术交流(891946049).
* 
* @Date: 2018年6月12日 下午8:49:27.
* 
*/
@SuppressWarnings("rawtypes")
public class ListTreeBean<T extends ListTreeBean> implements Serializable 
{

	/**
	 * 序列版本号.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID.
	 */
	private String id;

	/**
	 * 父级ID.
	 */
	private String parentId;

	/**
	 * 孩子列表.
	 */
	private List<T> childList;

	/**
	 * 获取ID.
	 * @return
	 */
	public String getId() 
	{
		return id;
	}

	/**
	 * 设置ID.
	 * @param id
	 */
	public void setId(String id) 
	{
		this.id = id;
	}

	/**
	 * 获取父级ID.
	 * @return
	 */
	public String getParentId() 
	{
		return parentId;
	}

	/**
	 * 设置父级ID.
	 * @param parentId
	 */
	public void setParentId(String parentId) 
	{
		this.parentId = parentId;
	}

	/**
	 * 获取孩子列表.
	 * @return
	 */
	public List<T> getChildList() 
	{
		return childList;
	}

	/**
	 * 设置孩子列表.
	 * @param childList
	 */
	public void setChildList(List<T> childList) 
	{
		this.childList = childList;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "ListTreeBean [id=" + id + ", parentId=" + parentId + ", childList=" + childList + "]";
	}

}
