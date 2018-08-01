/**
* @FileName: UtilExceprion.java
* @Package: io.github.bincool.utils.commons
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: UtilExceprion.java: �Զ��幤��jar���쳣.
* @Author wchy����������(891946049).
* @Date 2018��8��1�� ����1:18:01.
* @Content: ����.
* @Version: V1.0.
*/
package io.github.bincool.utils.commons;

/**
* @ClassName: UtilExceprion.java
* 
* @Description: 
* <p>
* �Զ��幤��jar���쳣.
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
* @Date: 2018��8��1�� ����1:18:01.
* 
*/
public class UtilExceprion extends Exception 
{

	/**
	 * ���а汾��.
	 */
	private static final long serialVersionUID = 6537250181271003019L;
	
	/**
	 * ���캯��.
	 */
	public UtilExceprion() 
	{
		super();
	}
	
	/**
	 * ���캯��.
	 * @param message
	 * 		�쳣��Ϣ.
	 */
	public UtilExceprion(String message) 
	{
		super(message);
	}
	
	/**
	 * ���캯��.
	 * @param cause
	 * 		�쳣ԭ��.
	 */
	public UtilExceprion(Throwable cause) 
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
	public UtilExceprion(String message, Throwable cause) 
	{
		super(message, cause);
	}
	
}
