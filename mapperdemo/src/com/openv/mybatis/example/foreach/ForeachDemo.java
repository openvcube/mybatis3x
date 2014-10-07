/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.foreach;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.openv.mybatis.example.Customer;

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
public class ForeachDemo {
	private static final Log log = LogFactory.getLog(ForeachDemo.class);
	public static void main(String[] args) throws IOException {
		String resource = "com/openv/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String statement ="com.openv.mybatis.example.foreach.selectAll";
		 
		//统计first name为 PATRICIA 与 JOHNSON 的人数。
		List<String> firstNames = new ArrayList<String>();
		firstNames.add("PATRICIA");
		firstNames.add("LINDA");
		List<Customer> list = sqlSession.selectList(statement,firstNames);
		
		//共查询到。
		log.info("叫PATRICIA或LINDA的人有："+list.size() +" 个");
		
		sqlSession.close();
	}
}
