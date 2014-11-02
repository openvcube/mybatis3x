package com.openv.mybatis.example.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.openv.mybatis.example.mapper.AnnotationMapper;
import com.openv.mybatis.example.vo.CountryVO;


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
public class AnnotationDAO {
    /**
     * 新增国家
     */
	public void insertCountry() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		AnnotationMapper aMapper = session.getMapper(AnnotationMapper.class);
		try {
 			 CountryVO country=new CountryVO();
 			 country.setCountryName("dd");
 			 aMapper.insertCountry(country);
 			 session.commit();
		} catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	/**
     * 更新国家
     */
	public void updateCountry() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		AnnotationMapper aMapper = session.getMapper(AnnotationMapper.class);
		try {
 			 CountryVO country=new CountryVO();
 			 country.setCountryName("ee");
 			 country.setCountryId(126);
 			 aMapper.updateCountry(country);
 			 session.commit();
		} catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	
	/**
     * 更新国家
     */
	public void delCountry() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		AnnotationMapper aMapper = session.getMapper(AnnotationMapper.class);
		try {
  			 aMapper.deleteCountry(126);
 			 session.commit();
		} catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	
	/**
     * 查询国家
     */
	public void selectCountry() {
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		AnnotationMapper aMapper = session.getMapper(AnnotationMapper.class);
		try {
  			CountryVO country= aMapper.findCountryById(125);
  			if(country!=null){
  	  			System.out.println(country.getCountryName());
  			}
 		} catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
