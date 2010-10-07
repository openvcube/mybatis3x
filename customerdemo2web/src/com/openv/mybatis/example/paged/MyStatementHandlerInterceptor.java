package com.openv.mybatis.example.paged;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class MyStatementHandlerInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler statement = (RoutingStatementHandler) invocation
				.getTarget();
		StatementHandler handler = (StatementHandler) ReflectUtil
				.getFieldValue(statement, "delegate");
		RowBounds rowBounds = (RowBounds) ReflectUtil.getFieldValue(handler,
				"rowBounds");
		
		// 开始取数的位置
		int start = rowBounds.getOffset();
		// 每页返回的数据条数
		int limit = rowBounds.getLimit();
		
		Configuration configuration = (Configuration)ReflectUtil.getFieldValue(handler, "configuration");
		// 获取环境配置ID，以此判断不同的数据库。
		String databaseId = configuration.getDatabaseId();
		if (rowBounds.getLimit() > 0
				&& rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
			BoundSql boundSql = statement.getBoundSql();
			String sql = boundSql.getSql();
			
			// 构建Oracle分页SQL
			if ("oracle".equals(databaseId)) {
				sql=  "SELECT * FROM " + "(SELECT ROWNUM AS rownum_, table_.* FROM "
						+ "(" +sql +") table_ " + 
						" WHERE ROWNUM < " + (start + limit)
						+ ") WHERE rownum_ >= " + start;
			}
			// 构建MySQL分页SQL
			else if ("mysql".equals(databaseId)) {
				sql  =  "SELECT * FROM (" + sql + ")  AS _t_b_ LIMIT "+ start+ "," + limit;
			} 
			ReflectUtil.setFieldValue(boundSql, "sql", sql);
			ReflectUtil.setFieldValue(rowBounds, "offset", 0);
		}

		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

}