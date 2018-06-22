/**
* @FileName: EmptyUtils.java
* @Package: io.github.bincool.utils.commons
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: EmptyUtils.java: 空检查工具类.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月22日 下午2:11:07.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.utils.commons;

import java.util.Collection;

/**
* @ClassName: EmptyUtils.java
* 
* @Description: 
* <p>
* 空检查工具类.
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
* @Date: 2018年6月22日 下午2:11:07.
* 
*/
public class EmptyUtils 
{
	
	/**
	 * 判断字符串是否为空，长度为0被认为是空字符串.
	 * @param str
	 * 		字符串.
	 * @return
	 */
    public static boolean isEmpty(String str) 
    {
        return StringUtils.isEmpty(str);
    }
    
    /**
     * 判断列表是否为空，列表没有元素也被认为是空.
     * @param collection
     * 		集合.
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) 
    {
        return null == collection || collection.size() == 0;
    }
    
    /**
     * 判断数组是否为空.
     * @param array
     * 		数组.
     * @return
     */
    public static boolean isEmpty(Object[] array) 
    {
        return null == array || array.length == 0;
    }
    
    /**
     * 判断对象是否为空.
     * @param obj
     * 		对象.
     * @return
     */
    public static boolean isEmpty(Object obj) 
    {
        return null == obj;
    }
    
}
