/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * <pre>
 * customer表的注解接口定义。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public interface ICustomerMapper {

	final String selectById = "SELECT * FROM customer WHERE customer_id =#{customerId}";

	@Select(selectById)
	@Results(value = {
			@Result(property="customerId",column="customer_id"),
			@Result(property="firstName",column="first_name"),
			@Result(property="lastName",column="last_name")
	})
	public Customer selectById(String customerId);

}
