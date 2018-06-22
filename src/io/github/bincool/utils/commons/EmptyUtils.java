/**
* @FileName: EmptyUtils.java
* @Package: io.github.bincool.utils.commons
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: EmptyUtils.java: �ռ�鹤����.
* @Author wchy����������(891946049).
* @Date 2018��6��22�� ����2:11:07.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.utils.commons;

import java.util.Collection;

/**
* @ClassName: EmptyUtils.java
* 
* @Description: 
* <p>
* �ռ�鹤����.
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
* @Date: 2018��6��22�� ����2:11:07.
* 
*/
public class EmptyUtils 
{
	
	/**
	 * �ж��ַ����Ƿ�Ϊ�գ�����Ϊ0����Ϊ�ǿ��ַ���.
	 * @param str
	 * 		�ַ���.
	 * @return
	 */
    public static boolean isEmpty(String str) 
    {
        return StringUtils.isEmpty(str);
    }
    
    /**
     * �ж��б��Ƿ�Ϊ�գ��б�û��Ԫ��Ҳ����Ϊ�ǿ�.
     * @param collection
     * 		����.
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) 
    {
        return null == collection || collection.size() == 0;
    }
    
    /**
     * �ж������Ƿ�Ϊ��.
     * @param array
     * 		����.
     * @return
     */
    public static boolean isEmpty(Object[] array) 
    {
        return null == array || array.length == 0;
    }
    
    /**
     * �ж϶����Ƿ�Ϊ��.
     * @param obj
     * 		����.
     * @return
     */
    public static boolean isEmpty(Object obj) 
    {
        return null == obj;
    }
    
}
