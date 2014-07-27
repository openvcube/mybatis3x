/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.configuration;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

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
@Intercepts({@Signature(
		  type= Executor.class,//声明要进行拦截接口。
		  method = "query",//要拦截的目标方法。
		  args = {MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class})})//要拦截的目标方法的参数类型
public class MyQueryInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);//向MyBatis入自定义的插件。
	}

	@Override
	public void setProperties(Properties properties) {
		// properties是在<plugin>中<property>配置的插件属性。
	}
}
