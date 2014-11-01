package com.openv.mybatis.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.openv.mybatis.example.mapper.VelocityMapper;
import com.openv.mybatis.example.vo.CustomerVO;


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
public class VelocityDAO {
    /**
     * 引用参数查询
     */
	public void slectCustomerWithParam() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		VelocityMapper vMapper = session.getMapper(VelocityMapper.class);
		try {
 			 CustomerVO param=new CustomerVO();
			param.setLastName("MART%");
			List<CustomerVO> customerList=	vMapper.getNameWithParam(param);
			for (CustomerVO customerVO : customerList) {
			 System.out.println(customerVO.toString());
			}
		} finally {
			session.close();
		}
	}

	 /**
	 *
     * 引用表达式查询
     */
	   
	public void slectCustomerWithExpression() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		VelocityMapper vMapper = session.getMapper(VelocityMapper.class);
		try {
 			 CustomerVO param=new CustomerVO();
			param.setLastName("MART%");
			List<CustomerVO> customerList=	vMapper.getNameWithExpression(param);
			for (CustomerVO customerVO : customerList) {
			 System.out.println(customerVO.toString());
			}
		} finally {
			session.close();
		}
	}
	
	 /**
	 *
    * 引用迭代表达式查询
    */
	public void slectCustomerWithIterExpression() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		VelocityMapper vMapper = session.getMapper(VelocityMapper.class);
		try {
 			 CustomerVO param=new CustomerVO();
 			 List<Integer> ids=new ArrayList<Integer>();
             ids.add(1);
             ids.add(2);
             ids.add(3);
             param.setIds(ids);
			List<CustomerVO> customerList=	vMapper.getNameWithIterExpression(param) ;
			for (CustomerVO customerVO : customerList) {
			 System.out.println(customerVO.toString());
			}
		} finally {
			session.close();
		}
	}
	
}
