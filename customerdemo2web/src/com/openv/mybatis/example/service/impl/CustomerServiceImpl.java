/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
public class CustomerServiceImpl implements ICustomerService{
	
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public PageResult<Customer> queryCustomer(Customer customer, int pageIndex,
			int pageSize) {
		PageResult<Customer> pr = new PageResult<Customer>();
		pr.setPageIndex(pageIndex);
		pr.setPageSize(pageSize);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int offset = (pageIndex-1)*pageSize;
		RowBounds rowBounds = new RowBounds(offset,pageSize);
		List<Customer> customerList = sqlSession.selectList("bean.queryCustomer",customer,rowBounds);
		
		Integer totalNum =sqlSession.selectOne("bean.queryCustomer_count", customer);
		
		pr.setTotalNum(totalNum);
		pr.setData(customerList);
		sqlSession.close();
		return pr;
	}

	@Override
	public int insertCustomer(Customer customer) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int i =sqlSession.insert("bean.insertCustomer", customer);
		sqlSession.close();
		return i;
	}

 
	@Override
	public int updateCustomer(Customer customer) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int u =sqlSession.update("bean.updateCustomer", customer);
		sqlSession.close();
		return u;
	}

	@Override
	public int deleteCustomer(String customerId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int d =sqlSession.delete("bean.deleteCustomer", customerId);
		sqlSession.close();
		return d;
	}

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
