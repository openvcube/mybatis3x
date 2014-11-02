/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.sqlsession.example;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.openv.mybatis.example.Customer;

/**
 * <pre>
 * SqlSession接口的selectOne()使用示例。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class SelectOneDemo {
 
	private static final Log log = LogFactory.getLog(SelectOneDemo.class);
	
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statementId ="com.openv.mybatis.example.selectById";
		String customerId = "1";//客户ID
		Customer customer = sqlSession.selectOne(statementId, customerId);
		
		sqlSession.close();
		//输出customer对象的内容。
		log.info(customer.toString());
	}

}
