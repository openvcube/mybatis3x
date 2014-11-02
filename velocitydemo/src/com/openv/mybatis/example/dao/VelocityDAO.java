package com.openv.mybatis.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.openv.mybatis.example.mapper.VelocityMapper;
import com.openv.mybatis.example.vo.CustomerVO;

/**
 * <pre>
 * 程序的中文名称。
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
public class VelocityDAO {

	private static final Log log = LogFactory.getLog(VelocityDAO.class);

	public void selectCustomerWithParam() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		VelocityMapper vMapper = session.getMapper(VelocityMapper.class);
		try {
			CustomerVO param = new CustomerVO();
			param.setLastName("MART%");
			List<CustomerVO> customerList = vMapper.getNameWithParam(param);
			for (CustomerVO customerVO : customerList) {
				log.info(customerVO.toString());
			}
		} finally {
			session.close();
		}
	}

	public void selectCustomerWithExpression() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		VelocityMapper vMapper = session.getMapper(VelocityMapper.class);
		try {
			CustomerVO param = new CustomerVO();
			param.setLastName("MART%");
			List<CustomerVO> customerList = vMapper
					.getNameWithExpression(param);
			for (CustomerVO customerVO : customerList) {
				log.info(customerVO.toString());
			}
		} finally {
			session.close();
		}
	}

	public void selectCustomerWithIterExpression() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		VelocityMapper vMapper = session.getMapper(VelocityMapper.class);
		try {
			CustomerVO param = new CustomerVO();
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(1);
			ids.add(2);
			ids.add(3);
			param.setIds(ids);
			List<CustomerVO> customerList = vMapper
					.getNameWithIterExpression(param);
			for (CustomerVO customerVO : customerList) {
				log.info(customerVO.toString());
			}
		} finally {
			session.close();
		}
	}

}
