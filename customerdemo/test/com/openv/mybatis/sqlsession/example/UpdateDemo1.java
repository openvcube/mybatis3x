/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.sqlsession.example;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.openv.mybatis.example.Customer;

/**
 * <pre>
 * SqlSession接口的update()使用示例。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class UpdateDemo1 {
	
	private static final Log log = LogFactory.getLog(UpdateDemo1.class);
	
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statement ="com.openv.mybatis.example.updateCustomer";
		Customer customer = new Customer();
		customer.setCustomerId(5);
		customer.setFirstName("open-v");
		customer.setLastName("www");
		customer.setActive((short)1);
		customer.setEmail("support@open-v.com");
		sqlSession.update(statement, customer);
		sqlSession.commit();
		sqlSession.close();
	}

}
