/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.set;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.openv.mybatis.example.Customer;

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
public class SetDemo {
	private static final Log log = LogFactory.getLog(SetDemo.class);
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statement ="com.openv.mybatis.example.set.updateCustomer";
		
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("TOM");
		customer.setLastName("Brook");
		
		sqlSession.update(statement,customer);
		sqlSession.commit();
		
		//输出customer对象的内容。
		log.info(customer.toString());
		
		sqlSession.close();
	}
}
