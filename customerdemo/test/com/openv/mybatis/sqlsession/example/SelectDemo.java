/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.sqlsession.example;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.openv.mybatis.example.Customer;

/**
 * <pre>
 * SqlSession接口的select()使用示例。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class SelectDemo {
 
	private static final Log log = LogFactory.getLog(SelectDemo.class);
	
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//pageIndex表示取第几页：这取第一页
		int pageIndex = 1;
		//每页显示的条数：5条
		int pageSize =5;
		//根据pageIndex及pageSize，计算出从数据库表取数的位置offset
		int offset = (pageIndex-1)*pageSize;
		RowBounds rowBounds = new RowBounds(offset,pageSize);

		Customer param = new Customer();
		String statementId ="com.openv.mybatis.example.selectCustomer";
		//这里使用MyBatis默认的DefaultResultHandler。读者也可以实现ResultHandler接口。
		DefaultResultHandler defaultResultHandler = new DefaultResultHandler() ;
		sqlSession.select(statementId,param,rowBounds,defaultResultHandler);
		//输出查询数据。
		log.info(defaultResultHandler.getResultList());
		sqlSession.close();
	}

}
