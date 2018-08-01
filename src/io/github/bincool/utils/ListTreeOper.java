/**
* @FileName: ListTreeOper.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: ListTreeOper.java: List�������ݲ�����.
* @Author wchy����������(891946049).
* @Date 2018��6��12�� ����8:57:36.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.utils;

import java.util.ArrayList;
import java.util.List;

import io.github.bincool.bean.ListTreeBean;
import io.github.bincool.utils.commons.StringUtils;

/**
* @ClassName: ListTreeOper.java
* 
* @Description: 
* <p>
* List�������ݲ�����.
* </p>
* <p>
* ��ϸ������List�������ݲ����࣬��Ҫ���ڽ���ɢ�ľ���id-parentId��ϵ�����ݼ��Ϸ�װ��List�������ݽṹ.
* </p>
* <p>
* ʾ������.
* </p>
*
* @Author: wchy����������(891946049).
* 
* @Date: 2018��6��12�� ����8:57:36.
* 
*/
@SuppressWarnings("rawtypes")
public class ListTreeOper<T extends ListTreeBean> 
{

	/**
     * ���ݸ��ڵ�ʹ����������б��ѯ��.
     * @param rootList
     *      ���ڵ��б�.
     * @param dataList
     *      �����������б�.
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<T> getListTree(List<T> rootList, List<T> dataList)
    {
        // Ϊһ�����˵������Ӳ˵���getChild�ǵݹ���õ�.
        for (T root : rootList)
        {
            root.setChildList(getChild(root.getId(), dataList));
        }
        return rootList;
    }

    /**
     * �ݹ�����Ӳ˵�.
     * @param rootId
     * 		��ǰ�˵�id.
     * @param dataList
     * 		Ҫ���ҵ��б�.
     * @return
     */
    @SuppressWarnings("unchecked")
	private List<T> getChild(String rootId, List<T> dataList)
    {
        // �Ӳ˵�.
        List<T> childList = new ArrayList<>();
        for (T data : dataList)
        {
            // �������нڵ㣬�����˵�id�봫������id�Ƚ�.
            if (StringUtils.isNotEmpty(data.getParentId()) && data.getParentId().equals(rootId))
            {
                childList.add(data);
            }
        }

        // ���Ӳ˵����Ӳ˵���ѭ��һ��.
        for (T child : childList)
        {
            // �ݹ�.
            child.setChildList(getChild(child.getId(), dataList));
        }

        // �ݹ��˳�����.
        if (childList.isEmpty())
        {
            return null;
        }

        return childList;
    }
    
}
