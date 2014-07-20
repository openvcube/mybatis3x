/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.mapper.example.cache;

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
public class TestCacheSelect {
	private static final Log log = LogFactory.getLog(TestCacheSelect.class);
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/mapper/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statement ="com.openv.mybatis.mapper.example.cache.selectById";
		String customerId = "1";//客户ID MARY SMITH
		Customer customer = sqlSession.selectOne(statement, customerId);
		log.info("第一次查询："+customer.getFirstName() +" "+customer.getLastName());
		
		customer = sqlSession.selectOne(statement, customerId);
		log.info("第二次查询："+customer.getFirstName() +" " +customer.getLastName());
		
		sqlSession.close();
	}
}
