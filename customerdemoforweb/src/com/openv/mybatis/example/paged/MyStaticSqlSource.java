/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.paged;

import java.util.List;

import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.Configuration;

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
public class MyStaticSqlSource extends StaticSqlSource {

	private String oldSql;
	
	/**
	 * @param configuration
	 * @param sql
	 */
	public MyStaticSqlSource(Configuration configuration, String sql) {
		super(configuration, sql);
	}

	/**
	 * @param configuration
	 * @param string
	 * @param parameterMappings
	 */
	public MyStaticSqlSource(Configuration configuration, String string,
			List<ParameterMapping> parameterMappings) {
		super(configuration, string,parameterMappings);
	}

	/**
	 * @return 返回 oldSql。
	 */
	public String getOldSql() {
		return oldSql;
	}

	/**
	 * @param oldSql 设置 oldSql。
	 */
	public void setOldSql(String oldSql) {
		this.oldSql = oldSql;
	}
	

}
