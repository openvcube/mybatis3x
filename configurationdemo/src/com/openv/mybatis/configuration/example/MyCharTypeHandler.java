/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.configuration.example;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

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
 * @param <T>
 */
@MappedTypes(value=String.class)
@MappedJdbcTypes(value={JdbcType.CHAR} )
public class MyCharTypeHandler extends BaseTypeHandler<String> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			String parameter, JdbcType jdbcType) throws SQLException {
	}

 
	@Override
	public String getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return null;
	}

 
	@Override
	public String getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return null;
	}

 
	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return null;
	}


}
