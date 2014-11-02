/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.build.example;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.openv.mybatis.example.Customer;
import com.openv.mybatis.example.ICustomerMapper;

/**
 * <pre>
 * 使用纯Java方式构建SqlSessionFactory。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ConfigBuildDemo {
 
	private static final Log log = LogFactory.getLog(ConfigBuildDemo.class);
	
	public static void main(String[] args) throws IOException {
	 
		Configuration config = new Configuration();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		//数据库驱动、url、用户名、密码
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sakila";
		String username = "root";
		String password = "";
		PooledDataSource dataSource = new PooledDataSource(driver, url, username, password);
		//配置环境
		String environmentId = "test";
		Environment environment = new Environment(environmentId, transactionFactory, dataSource);
		config.setEnvironment(environment);
		//注册接口
		config.addMapper(ICustomerMapper.class);
		//构建SqlSessionFactory实例
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//查询
		ICustomerMapper customerMapper = sqlSession.getMapper(ICustomerMapper.class);
		String customerId = "1";//客户ID
		Customer customer = customerMapper.selectById(customerId);
		
		sqlSession.close();
		//输出customer对象的内容。
		log.info(customer.toString());
	}

}
