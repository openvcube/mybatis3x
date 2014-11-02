package com.openv.mybatis.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.openv.mybatis.example.vo.AddressVO;
import com.openv.mybatis.example.vo.CountryVO;
import com.openv.mybatis.example.vo.CustomerVO;
import com.openv.mybatis.example.vo.StoreVO;


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
public interface AnnotationMapper {
    //插入国家信息
	@Insert("INSERT INTO country(country) VALUES(#{countryName})")
	@Options(useGeneratedKeys=true, keyProperty="countryId")
	int insertCountry(CountryVO country);
	
	//更新国家信息
	@Update("UPDATE country SET country=#{countryName} WHERE country_id =#{countryId}")
	int updateCountry(CountryVO country);
	
	//删除国家信息
	@Delete("DELETE FROM country WHERE country_id=#{countryId}")
	int deleteCountry(int countryId);
	@Select("SELECT country_id AS countryId, country AS countryName, "
			+ "last_update AS updateTime  FROM country WHERE country_id =#{countryId}")
	CountryVO findCountryById(int countryId);
	
	//根据Id查询国家信息
	@Select("SELECT country_id,country,last_update FROM country WHERE country_id =#{countryId}")
	@Results(
	  {
		  @Result(id=true, column="country_id", property="countryId"),
		  @Result(column="country", property="countryName"),
		  @Result(column="last_update", property="updateTime")
	 }
	)
	CountryVO findCountryByIdWithResults(int countryId);

	//根据国家名字查找国家信息
	@Select("SELECT country_id,country,last_update FROM country WHERE country like #{countryName}")
	@Results(
	  {
		  @Result(id=true, column="country_id", property="countryId"),
		  @Result(column="country", property="countryName"),
		  @Result(column="last_update", property="updateTime")
	 }
	)
	CountryVO findCountryByName(String countryName);
	
	
    //根据地址Id查找地址
	@Select("SELECT address_id, address,district from address where address_id=#{addressId}")
	@Results({
		@Result(id=true, column="address_id", property="addressId"),
		@Result(column="address", property="addressName"),
		@Result(column="district", property="district")
 	})
	AddressVO selectAddressById(int addressId);
	
	
	//根据店铺Id查询客户信息
	@Select("SELECT first_name, last_name from customer where store_id=#{id}")
	@Results({
		@Result(column="first_name", property="firstName"),
		@Result(column="last_name", property="lastName")
	})
	List<CustomerVO> selectCustomersByStoreId(int storeId);
 
	//一对一查询
	@Select("SELECT first_name, last_name,address_id from customer where customer_id=#{id}")
	@Results({
 		@Result(column="first_name", property="firstName"),
		@Result(column="last_name", property="lastName"),
		@Result(property="address", column="address_id",one=@One(select="com.openv.mybatis.example.mapper.AnnotationMapper.selectAddressById"))		
	})
	CustomerVO selectCustomersById(int id);
	
	//一对多查询
	@Select("SELECT store_id, address_id from store where store_id =#{storeId}")
	@Results({
		@Result(id=true,column="store_id", property="id"),
		@Result(column="address_id", property="addressId"),
		@Result(property="customers", column="store_id", many=@Many(select="com.openv.mybatis.example.mapper.AnnotationMapper.selectCustomersByStoreId"))
	})
	StoreVO selectStoreByStoreId(int storeId);
	
	
	//以下是动态SQL Provider
	@InsertProvider(type=SQLProvider.class, method="insertCountry")
 	int insertCountryWithProvider(CountryVO country);
	
	@UpdateProvider(type=SQLProvider.class, method="updateCountry")
	int updateCountryWithProvider(CountryVO country);
	
	@DeleteProvider(type=SQLProvider.class, method="deleteCountry")
	int deleteCountryWithProvider(int countryId);
	
	@SelectProvider(type=SQLProvider.class, method="findCountryByName")
	CountryVO selectCountryWithProvider(String countryName);
	
 }
