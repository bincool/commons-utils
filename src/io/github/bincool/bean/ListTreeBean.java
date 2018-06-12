/**
* @FileName: ListTreeBean.java
* @Package: io.github.bincool.bean
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: ListTreeBean.java: List�������ݻ���bean.
* @Author wchy����������(891946049).
* @Date 2018��6��12�� ����8:49:27.
* @Content: ����.
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
* List�������ݻ���bean.
* </p>
* <p>
* ��ϸ������List�������ݻ���bean���˵�ɭ�֡���֯�ṹ�����༶����(ʡ��������)�������ƹ�㼶ɭ��.
* </p>
* <p>
* ʾ������.
* </p>
*
* @Author: wchy����������(891946049).
* 
* @Date: 2018��6��12�� ����8:49:27.
* 
*/
@SuppressWarnings("rawtypes")
public class ListTreeBean<T extends ListTreeBean> implements Serializable
{

	/**
	 * ���а汾��.
	 */
	private static final long serialVersionUID = 1L;
	
	 /**
     * ID.
     */
    private String id;

    /**
     * ����ID.
     */
    private String parentId;

    /**
     * �����б�.
     */
    private List<T> childList;

    /**
     * ��ȡID.
     * @return
     */
    public String getId()
    {
        return id;
    }

    /**
     * ����ID.
     * @param id
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * ��ȡ����ID.
     * @return
     */
    public String getParentId()
    {
        return parentId;
    }

    /**
     * ���ø���ID.
     * @param parentId
     */
    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    /**
     * ��ȡ�����б�.
     * @return
     */
    public List<T> getChildList()
    {
        return childList;
    }

    /**
     * ���ú����б�.
     * @param childList
     */
    public void setChildList(List<T> childList)
    {
        this.childList = childList;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "ListTreeBean [id=" + id + ", parentId=" + parentId + ", childList=" + childList + "]";
	}

}
