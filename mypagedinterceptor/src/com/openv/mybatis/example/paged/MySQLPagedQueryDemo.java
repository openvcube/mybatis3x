/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.paged;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.openv.mybatis.example.Customer;


/**
 * <pre>
 * 测试MySQL分页查询。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class MySQLPagedQueryDemo {
	
	private final static Log log = LogFactory.getLog(MySQLPagedQueryDemo.class);
	
	public static void main(String[] args) throws Exception {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//build(inputStream,"mysql")指定加载mysql环境配置
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"mysql");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//pageIndex表示取第几页：这取第一页
		int pageIndex = 1;
		//每页显示的条数：10条
		int pageSize =10;
		//根据pageIndex及pageSize，计算出从数据库表取数的位置offset
		int offset = (pageIndex-1)*pageSize;
		RowBounds rowBounds = new RowBounds(offset,pageSize);
		String statementId ="com.openv.mybatis.example.selectCustomer";
		Customer param = new Customer();
		List<Customer> customerList = sqlSession.selectList(statementId,param,rowBounds);
		
		sqlSession.close();
		//输出customerList的内容
		log.info("查询结果：\n"+customerList);
	}
}
