/**
* @FileName: FileHelper.java
* @Package: io.github.bincool.utils
* @Copyright: 2018 bincool.github.io Inc. All Rights Reserved.
* @Description: FileHelper.java: 文件帮助类.
* @Author wchy，技术交流(891946049).
* @Date 2018年6月22日 上午11:00:10.
* @Content: 新增.
* @Version: V1.0.
*/
package io.github.bincool.utils;

import java.io.File;
import java.io.IOException;

import io.github.bincool.utils.commons.StringUtils;

/**
* @ClassName: FileHelper.java
* 
* @Description: 
* <p>
* 文件帮助类.
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
* @Date: 2018年6月22日 上午11:00:10.
* 
*/
public class FileHelper 
{
	
	/**
	 * 拼接路径名.
	 * @param pathnames
	 * 		路径名数组.
	 */
	public static String splicePathname(String ...pathnames)  
	{
		return StringUtils.spliceStr(File.separator, pathnames);
	}
	
	/**
	 * 创建文件.
	 * @param fileName
	 * 		文件全路径.
	 * @throws IOException 
	 * 		创建文件异常.
	 */
	public static void createFile(String pathname) throws IOException 
	{
		File file = new File(pathname);
		
		File parentFile = file.getParentFile();
        if (!parentFile.exists()) 
        {
            parentFile.mkdirs();
        }
		
		if (!file.exists()) 
		{
			file.createNewFile();
		}
	}
	
}
