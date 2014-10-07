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

import com.openv.mybatis.example.Emp;


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
public class OraclePagedQueryDemo {
	
	private final static Log log = LogFactory.getLog(OraclePagedQueryDemo.class);
	
	public static void main(String[] args) throws Exception {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"oracle");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//pageIndex表示取第几页：这取第一页。
		int pageIndex = 2;
		//每页显示的条数：10条。
		int pageSize =10;
		//根据pageIndex及pageSize，计算出从数据库表取数的位置offset。
		int offset = (pageIndex-1)*pageSize;
		RowBounds rowBounds = new RowBounds(offset,pageSize);
		
		String statementId ="com.openv.mybatis.example.selectEmp";
		Emp param = new Emp();
		List<Emp> empList = sqlSession.selectList(statementId,param,rowBounds);
		
		sqlSession.close();
		//输出emp对象的内容。
		log.info("查询结果："+empList.size()+"条");
	}
}
