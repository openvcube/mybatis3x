/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.configuration;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.BeanWrapper;

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
public class MyCustomerBeanWrapper extends BeanWrapper {

	public MyCustomerBeanWrapper(MetaObject metaObject, Object object) {
		super(metaObject, object);
	}

}
