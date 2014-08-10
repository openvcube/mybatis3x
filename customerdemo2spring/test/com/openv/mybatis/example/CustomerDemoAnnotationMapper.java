/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example;

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
 * customer表的注解接口测试类。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class CustomerDemoAnnotationMapper {

	private static final Log log = LogFactory.getLog(CustomerDemoAnnotationMapper.class);
	
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//注册带注解的接口
		sqlSessionFactory.getConfiguration().addMapper(ICustomerMapper.class);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//取该接口实例
		ICustomerMapper customerMapper = sqlSession.getMapper(ICustomerMapper.class);
		String customerId = "1";//客户ID
		Customer customer = customerMapper.selectById(customerId);
		sqlSession.close();
		log.info(customer.toString());
	}

}
