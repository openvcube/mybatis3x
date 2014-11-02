package com.openv.mybatis.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.openv.mybatis.example.vo.AddressVO;
import com.openv.mybatis.example.vo.CountryVO;
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
public interface AnnotationMapper {

	@Insert("INSERT INTO country(country) VALUES(#{countryName})")
	int insertCountry(CountryVO country);
	
	@Update("UPDATE country SET country=#{countryName} WHERE country_id =#{countryId}")
	int updateCountry(CountryVO country);
	
	@Delete("DELETE FROM country WHERE country_id=#{countryId}")
	int deleteCountry(int countryId);
	@Select("SELECT country_id AS countryId, country AS countryName, "
			+ "last_update AS updateTime  FROM country WHERE country_id =#{countryId}")
	CountryVO findCountryById(int countryId);
	
	
	@Select("SELECT country_id,country,last_update FROM country WHERE country_id =#{countryId}")
	@Results(
	  {
		  @Result(id=true, column="country_id", property="countryId"),
		  @Result(column="country", property="countryName"),
		  @Result(column="last_update", property="updateTime")
	 }
	)
	CountryVO findCountryByIdWithResults(int countryId);
	
	@Select("SELECT country_id,country,last_update FROM country WHERE country like #{countryName}")
	@Results(
	  {
		  @Result(id=true, column="country_id", property="countryId"),
		  @Result(column="country", property="countryName"),
		  @Result(column="last_update", property="updateTime")
	 }
	)
	CountryVO findCountryByName(String countryName);
	
	

	@Select("SELECT address_id, address,district from address where address_id=#{addressId}")
	@Results({
		@Result(id=true, column="address_id", property="addressId"),
		@Result(column="address", property="addressName"),
		@Result(column="district", property="district")
 	})
	AddressVO selectAddressById(int addressId);

	@Select("SELECT first_name, last_name from customer where customer_id=#{id}")
	@Results({
		@Result(id=true, column="customer_id", property="id"),
		@Result(column="first_name", property="firstName"),
		@Result(column="last_name", property="lastName"),
		@Result(property="address", column="address_id",one=@One(select="com.openv.mybatis.example.mapper.selectAddressById"))		
	})
	CustomerVO selectCustomersById(int id);
 }
