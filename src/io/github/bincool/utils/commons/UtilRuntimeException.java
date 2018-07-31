/**
* @FileName: UtilRuntimeException.java
* @Package: io.github.bincool.utils.commons
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: UtilRuntimeException.java: �Զ��幤��jar������ʱ�쳣.
* @Author wchy����������(891946049).
* @Date 2018��7��31�� ����3:53:04.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.utils.commons;

/**
* @ClassName: UtilRuntimeException.java
* 
* @Description: 
* <p>
* �Զ��幤��jar������ʱ�쳣.
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
* @Date: 2018��7��31�� ����3:53:04.
* 
*/
public class UtilRuntimeException extends RuntimeException 
{

	/**
	 * ���а汾��.
	 */
	private static final long serialVersionUID = -8977334559091740930L;
	
	/**
	 * ���캯��.
	 */
	public UtilRuntimeException() 
	{
		super();
	}
	
	/**
	 * ���캯��.
	 * @param message
	 * 		�쳣��Ϣ.
	 */
	public UtilRuntimeException(String message) 
	{
		super(message);
	}
	
	/**
	 * ���캯��.
	 * @param cause
	 * 		�쳣ԭ��.
	 */
	public UtilRuntimeException(Throwable cause) 
	{
		super(cause);
	}
	
	/**
	 * ���캯��.
	 * @param message
	 * 		�쳣��Ϣ.
	 * @param cause
	 * 		�쳣ԭ��.
	 */
	public UtilRuntimeException(String message, Throwable cause) 
	{
		super(message, cause);
	}

}
