/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.insert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

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
public class InsertDemo {
	private static final Log log = LogFactory.getLog(InsertDemo.class);
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statement ="com.openv.mybatis.example.insert.insertCustomer";
		Customer customer = new Customer();
		customer.setFirstName("TOM");
		customer.setLastName("Brook");
		customer.setActive((short)1);
		customer.setAddressId("5");
		customer.setStoreId((short)1);
		customer.setCreateDate(new Date());
		sqlSession.insert(statement, customer);
		log.info("输出自动生成的customerId:"+customer.getCustomerId());
		
		sqlSession.close();
	}
}
