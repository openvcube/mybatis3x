/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.openv.mybatis.example.bean.Customer;
import com.openv.mybatis.example.paged.PageResult;
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
public class CustomerServiceImpl extends SqlSessionDaoSupport  implements ICustomerService{
	
	@Override
	public PageResult<Customer> queryCustomer(Customer customer, int pageIndex,
			int pageSize) {
		PageResult<Customer> pr = new PageResult<Customer>();
		pr.setPageIndex(pageIndex);
		pr.setPageSize(pageSize);
		int offset = (pageIndex-1)*pageSize;
		RowBounds rowBounds = new RowBounds(offset,pageSize);
		List<Customer> customerList = this.getSqlSession().selectList("bean.queryCustomer",customer,rowBounds);
		
		Integer totalNum =this.getSqlSession().selectOne("bean.queryCustomer_count", customer);
		
		pr.setTotalNum(totalNum);
		pr.setData(customerList);
		return pr;
	}
	
}
