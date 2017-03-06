/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * <pre>
 * ReflectorFactory示例。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class MyCustomerReflectorFactoryDemo{
	private static final Log log = LogFactory.getLog(MyCustomerReflectorFactoryDemo.class);
	private String name;

	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		ReflectorFactory reflectorFactory =sqlSessionFactory.getConfiguration().getReflectorFactory();
		
		reflectorFactory.setClassCacheEnabled(true);//启用缓存
		Reflector reflector = reflectorFactory.findForClass(MyCustomerReflectorFactoryDemo.class);
		log.info(reflector.getGetterType("name"));
		Reflector reflector2 = reflectorFactory.findForClass(MyCustomerReflectorFactoryDemo.class);//第二次读缓存
		log.info(reflector2.getGetterType("name"));
	}
}
