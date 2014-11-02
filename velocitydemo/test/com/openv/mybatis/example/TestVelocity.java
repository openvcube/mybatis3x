package com.openv.mybatis.example;

import com.openv.mybatis.example.dao.VelocityDAO;

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
public class TestVelocity {
	
	public static void main(String[] args) {
		VelocityDAO dao=new VelocityDAO();
	   // dao.slectCustomerWithParam();
		//dao.slectCustomerWithExpression();
		dao.slectCustomerWithIterExpression();
	}
}
