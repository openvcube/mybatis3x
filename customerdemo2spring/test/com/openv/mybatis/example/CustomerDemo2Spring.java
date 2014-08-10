/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.openv.mybatis.example.service.ICustomerService;

/**
 * <pre>
 * CustomerDemo测试类。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class CustomerDemo2Spring {
 
	private static final Log log = LogFactory.getLog(CustomerDemo2Spring.class);
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICustomerService customerService = (ICustomerService)context.getBean("customerService");
		String customerId = "1";//客户ID
		Customer customer = customerService.selectOneCustomer(customerId);
		
		//输出customer对象的内容。
		log.info(customer.toString());
	}

}
