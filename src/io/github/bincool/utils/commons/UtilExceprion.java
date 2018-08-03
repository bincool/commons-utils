/**
* @FileName: UtilExceprion.java
* @Package: io.github.bincool.utils.commons
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: UtilExceprion.java: 自定义工具jar包异常.
* @Author wchy，技术交流(891946049).
* @Date 2018年8月1日 下午1:18:01.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.utils.commons;

/**
* @ClassName: UtilExceprion.java
* 
* @Description: 
* <p>
* 自定义工具jar包异常.
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
* @Date: 2018年8月1日 下午1:18:01.
* 
*/
public class UtilExceprion extends Exception 
{

	/**
	 * 序列版本号.
	 */
	private static final long serialVersionUID = 6537250181271003019L;
	
	/**
	 * 构造函数.
	 */
	public UtilExceprion() 
	{
		super();
	}
	
	/**
	 * 构造函数.
	 * @param message
	 * 		异常信息.
	 */
	public UtilExceprion(String message) 
	{
		super(message);
	}
	
	/**
	 * 构造函数.
	 * @param cause
	 * 		异常原因.
	 */
	public UtilExceprion(Throwable cause) 
	{
		super(cause);
	}

	/**
	 * 构造函数.
	 * @param message
	 * 		异常信息.
	 * @param cause
	 * 		异常原因.
	 */
	public UtilExceprion(String message, Throwable cause) 
	{
		super(message, cause);
	}
	
}
