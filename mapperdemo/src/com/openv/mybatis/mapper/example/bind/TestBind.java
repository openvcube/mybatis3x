/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.mapper.example.bind;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.openv.mybatis.mapper.example.Customer;

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
public class TestBind {
	private static final Log log = LogFactory.getLog(TestBind.class);
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/mapper/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statement ="com.openv.mybatis.mapper.example.bind.select";
		
		
		Customer customer = new Customer();
		customer.setCustomerId(1);
		
		Customer c = sqlSession.selectOne(statement,customer);
		
		//输出customer对象的内容。
		log.info(c.toString());
		
		sqlSession.close();
	}
}
