package com.openv.mybatis.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.openv.mybatis.example.mapper.SPMapper;
import com.openv.mybatis.example.vo.SpManyVO;
import com.openv.mybatis.example.vo.SpOneVO;


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
public class StoreProcedureDAO {

	public void callGetLastName() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		SPMapper spMapper = session.getMapper(SPMapper.class);
		try {
			SpOneVO param=new SpOneVO();
			param.setEmail("MARY.SMITH@sakilacustomer.org");
			spMapper.callGetLastName(param);
			String lastName=param.getLastName();
			System.out.println(lastName);
			 
		} finally {
			session.close();
		}
	}

	public void callGetMany() {

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		SPMapper spMapper = session.getMapper(SPMapper.class);
		
		try {
			List<SpManyVO> voList= spMapper.callGetMany();
			if(voList!=null && voList.size()>0){
				for (SpManyVO spManyVO : voList) {
					System.out.println(spManyVO);
				}
			}
		} finally {
			session.close();
		}
 	}

	public void callGetLastNameAnnotations() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		SPMapper spMapper = session.getMapper(SPMapper.class);
		try {
			SpOneVO param=new SpOneVO();
			param.setEmail("MARY.SMITH@sakilacustomer.org");
			spMapper.callGetLastName(param);
			String lastName=param.getLastName();
			System.out.println(lastName);
			 
		} finally {
			session.close();
		}
	}

	public void callGetManyAnnotations() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		SPMapper spMapper = session.getMapper(SPMapper.class);
		
		try {
			List<SpManyVO> voList= spMapper.callGetManyAnnotations();
			if(voList!=null && voList.size()>0){
				for (SpManyVO spManyVO : voList) {
					System.out.println(spManyVO);
				}
			}
		} finally {
			session.close();
		}
	}

	
}
