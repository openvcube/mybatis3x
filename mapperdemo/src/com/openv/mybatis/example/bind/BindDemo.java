/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.bind;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
public class BindDemo {
	private static final Log log = LogFactory.getLog(BindDemo.class);
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		Properties props = new Properties();
		props.put("custId", "77");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,props);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statement ="com.openv.mybatis.example.bind.select";
		
		
		Customer customer = new Customer();
		customer.setCustomerId(1);
		
		Customer c = sqlSession.selectOne(statement,customer);
		
		//输出customer对象的内容。
		log.info(c.toString());
		
		sqlSession.close();
	}
}
