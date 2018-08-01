/**
* @FileName: ListTreeOper.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: ListTreeOper.java: List树形数据操作类.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月12日 下午8:57:36.
* @Content: 新增.
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
* List树形数据操作类.
* </p>
* <p>
* 详细描述：List树形数据操作类，主要用于将离散的具有id-parentId关系的数据集合封装成List树形数据结构.
* </p>
* <p>
* 示例代码.
* </p>
*
* @Author: wchy，技术交流(891946049).
* 
* @Date: 2018年6月12日 下午8:57:36.
* 
*/
@SuppressWarnings("rawtypes")
public class ListTreeOper<T extends ListTreeBean> 
{

	/**
     * 根据根节点和待构造树的列表查询树.
     * @param rootList
     *      根节点列表.
     * @param dataList
     *      待构造树的列表.
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<T> getListTree(List<T> rootList, List<T> dataList)
    {
        // 为一级根菜单设置子菜单，getChild是递归调用的.
        for (T root : rootList)
        {
            root.setChildList(getChild(root.getId(), dataList));
        }
        return rootList;
    }

    /**
     * 递归查找子菜单.
     * @param rootId
     * 		当前菜单id.
     * @param dataList
     * 		要查找的列表.
     * @return
     */
    @SuppressWarnings("unchecked")
	private List<T> getChild(String rootId, List<T> dataList)
    {
        // 子菜单.
        List<T> childList = new ArrayList<>();
        for (T data : dataList)
        {
            // 遍历所有节点，将父菜单id与传过来的id比较.
            if (StringUtils.isNotEmpty(data.getParentId()) && data.getParentId().equals(rootId))
            {
                childList.add(data);
            }
        }

        // 把子菜单的子菜单再循环一遍.
        for (T child : childList)
        {
            // 递归.
            child.setChildList(getChild(child.getId(), dataList));
        }

        // 递归退出条件.
        if (childList.isEmpty())
        {
            return null;
        }

        return childList;
    }
    
}
