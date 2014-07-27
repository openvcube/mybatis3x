/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.configuration.example;

import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class MyObjectFactory extends DefaultObjectFactory{

	/**
	 * 序列化ID。
	 */
	private static final long serialVersionUID = -4151798774298155924L;
	
	public void setProperties(Properties properties) {
		// no props for default
	}
}
