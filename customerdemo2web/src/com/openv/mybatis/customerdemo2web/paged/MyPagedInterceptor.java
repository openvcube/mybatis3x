/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.customerdemo2web.paged;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * <pre>
 * Excutor的query方法拦截器，实现Oracle与MySQL的查询分页功能。
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
@Intercepts({ @Signature(type = Executor.class, method = "query", args = {
		MappedStatement.class, Object.class, RowBounds.class,
		ResultHandler.class }) })
public class MyPagedInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation
				.getArgs()[0];
		Object param = (Object) invocation.getArgs()[1];
		RowBounds rowBounds = (RowBounds) invocation.getArgs()[2];
		// 开始取数的位置
		int start = rowBounds.getOffset();
		// 每页返回的数据条数
		int limit = rowBounds.getLimit();
		// 获取环境配置ID，以此判断不同的数据库。
		String databaseId = mappedStatement.getConfiguration().getDatabaseId();
		if (rowBounds.getLimit() > 0
				&& rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
			BoundSql boundSql = mappedStatement.getSqlSource().getBoundSql(
					param);
			String originalSql = boundSql.getSql();
			
//			SqlSource sqlSource1 = mappedStatement.getSqlSource();
//			if(sqlSource1 instanceof MyStaticSqlSource){
//				MyStaticSqlSource m = (MyStaticSqlSource)sqlSource1;
//				originalSql = m.getOldSql();
//			}
			
			StringBuffer sql = new StringBuffer();
			// 构建Oracle分页SQL
			if ("oracle".equals(databaseId)) {
				sql.append("SELECT * FROM ")
						.append("(SELECT ROWNUM AS rownum_, table_.* FROM ")
						.append("(").append(originalSql).append(") table_ ")
						.append(" WHERE ROWNUM < ").append(start + limit)
						.append(") WHERE rownum_ >= ").append(start);
			}
			// 构建MySQL分页SQL
			else if ("mysql".equals(databaseId)) {
					sql.append("SELECT * FROM (").append(originalSql)
					.append(")  AS _t_b_ LIMIT ").append(start).append(",")
					.append(limit);
			}
			
			ReflectUtil.setFieldValue(boundSql, "sql", sql.toString());
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
