/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.service.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

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
public class CustomerServiceImpl extends SqlSessionDaoSupport implements ICustomerService{
	
	@Override
	public Customer selectOneCustomer(String customerId){
		String statementId ="com.openv.mybatis.example.Customer.selectById";
		Customer customer = this.getSqlSession().selectOne(statementId, customerId);
		return customer;
	}

}
