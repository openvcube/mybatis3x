/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.paged;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

/**
 * <pre>
 * Excutor的prepare方法拦截器，实现MySQL的查询分页功能。
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
@Intercepts({ 
	@Signature(
			type = StatementHandler.class, 
			method = "prepare", 
			args = { Connection.class }
			) 
	})
public class MyPagedInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler statement = (RoutingStatementHandler) invocation
				.getTarget();
		StatementHandler handler = (StatementHandler) ReflectUtil
				.getFieldValue(statement, "delegate");
		RowBounds rowBounds = (RowBounds) ReflectUtil.getFieldValue(handler,
				"rowBounds");
		 
		if (rowBounds.getLimit() > 0
				&& rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
			BoundSql boundSql = statement.getBoundSql();
			String sql = boundSql.getSql();
			//构建MySQL分页SQL
			sql = getMySQLPagedString(sql, rowBounds.getOffset(),
					rowBounds.getLimit());
			
			ReflectUtil.setFieldValue(boundSql, "sql", sql);
		}
		ReflectUtil.setFieldValue(rowBounds, "offset", 0);
		return invocation.proceed();
	}
	
	private String getMySQLPagedString(String sql, int offset, int length) {
		sql = sql.trim();
		
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		
		pagingSelect.append("SELECT * FROM (").append(sql).append(")  AS _t_b_ LIMIT ")
		.append(offset).append(",").append(length);
		 
		return pagingSelect.toString();
	}
	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
