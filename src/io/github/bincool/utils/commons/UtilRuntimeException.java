/**
* @FileName: UtilRuntimeException.java
* @Package: io.github.bincool.utils.commons
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: UtilRuntimeException.java: 自定义工具jar包运行时异常.
* @Author wchy，技术交流(891946049).
* @Date 2018年7月31日 下午3:53:04.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.utils.commons;

/**
* @ClassName: UtilRuntimeException.java
* 
* @Description: 
* <p>
* 自定义工具jar包运行时异常.
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
* @Date: 2018年7月31日 下午3:53:04.
* 
*/
public class UtilRuntimeException extends RuntimeException 
{

	/**
	 * 序列版本号.
	 */
	private static final long serialVersionUID = -8977334559091740930L;
	
	/**
	 * 构造函数.
	 */
	public UtilRuntimeException() 
	{
		super();
	}
	
	/**
	 * 构造函数.
	 * @param message
	 * 		异常信息.
	 */
	public UtilRuntimeException(String message) 
	{
		super(message);
	}
	
	/**
	 * 构造函数.
	 * @param cause
	 * 		异常原因.
	 */
	public UtilRuntimeException(Throwable cause) 
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
	public UtilRuntimeException(String message, Throwable cause) 
	{
		super(message, cause);
	}

}
