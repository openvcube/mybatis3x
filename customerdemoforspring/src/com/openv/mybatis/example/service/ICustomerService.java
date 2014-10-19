/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.service;

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
public interface ICustomerService {

	/**
	 *  获取客户信息。
	 * @param customerId 客户ID
	 * @return Customer
	 */
	public Customer selectOneCustomer(String customerId);

}
