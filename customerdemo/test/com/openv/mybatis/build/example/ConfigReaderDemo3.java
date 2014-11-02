/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.build.example;

import java.io.IOException;
import java.io.Reader;
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
 * 使用SqlSessionFactory   build(Reader reader, Properties properties)加载配置文件。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ConfigReaderDemo3 {
 
	private static final Log log = LogFactory.getLog(ConfigReaderDemo3.class);
	
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		//定义数据库用户名及密码
		Properties properties = new Properties();
		properties.put("username", "root");
		properties.put("password", "");
		//使用开发环境：developer
		String environment = "developer";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,environment,properties);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statementId ="com.openv.mybatis.example.selectById";
		String customerId = "1";//客户ID
		Customer customer = sqlSession.selectOne(statementId, customerId);
		
		sqlSession.close();
		//输出customer对象的内容。
		log.info(customer.toString());
	}

}
