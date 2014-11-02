/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * MapperFactoryBean使用示例。
 * </pre>
 * 
 * @author http://www.open-v.com
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
public class CustomerDemoForMapperFactoryBean {

	private static final Log log = LogFactory
			.getLog(CustomerDemoForMapperFactoryBean.class);

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext-mapperfactorybean.xml");
		CustomerMapper customerMapper = (CustomerMapper) context
				.getBean("customerMapper");
		String customerId = "1";// 客户ID
		Customer customer = customerMapper.selectById(customerId);

		// 输出customer对象的内容。
		log.info(customer.toString());
	}

}
