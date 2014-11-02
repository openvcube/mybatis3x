package com.openv.mybatis.example.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.openv.mybatis.example.vo.CountryVO;

public class SQLProvider {
	
	
	
	public String findCountryByName(String name) 
	{
		return new SQL() {{
			SELECT("country_id as countryId, country as countryName, last_update as updateTime");
		    FROM("country");
		    WHERE("country =#{countryName}");
		}}.toString();
	}
	
	public String insertCountry(final CountryVO country) {
		
		return new SQL() {{
			INSERT_INTO("country");
		    
		    if (country.getCountryName() != null) {
		        VALUES("country", "#{countryName}");
		    }
		    
		    if (country.getUpdateTime()!= null) {
		        VALUES("last_update", "#{updateTime}");
		    }
		}}.toString();
		
	}
	
	public String updateCountry(final CountryVO country) 
	{
		
		return new SQL() {{
			UPDATE("country");
			 if (country.getCountryName() != null) {
			        SET("country = #{countryName}");
			 }
		    WHERE("country_id = #{countryId}");
		}}.toString();
	}
	
	public String deleteCountry(int countryId) 
	{
		return new SQL() {{
			DELETE_FROM("country");
		     WHERE("country_id = #{countryId}");
		}}.toString();
		
	}
	
	
}
