/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.openv.mybatis.example.Customer;
import com.openv.mybatis.example.service.ICustomerService;

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
public class CustomerServiceImpl implements ICustomerService{
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public Customer selectOneCustomer(String customerId){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statementId ="com.openv.mybatis.example.Customer.selectById";
		Customer customer = sqlSession.selectOne(statementId, customerId);
		sqlSession.close();
		return customer;
	}

	/**
	 * @return 返回 sqlSessionFactory。
	 */
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	/**
	 * @param sqlSessionFactory 设置 sqlSessionFactory。
	 */
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
}
