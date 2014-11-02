/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.delete;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
public class DeleteDemo {
	private static final Log log = LogFactory.getLog(DeleteDemo.class);
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statement1 ="com.openv.mybatis.example.delete.deleteCustomer";
		String statement2 ="com.openv.mybatis.example.delete.deletePayment";
		String statement3 ="com.openv.mybatis.example.delete.deleteRental";
		//要删除的客户ID
		String customerId = "99";
		sqlSession.delete(statement3,customerId);
		sqlSession.delete(statement2,customerId);
		sqlSession.delete(statement1, customerId);
		
		sqlSession.commit();
		sqlSession.close();
	}
}
