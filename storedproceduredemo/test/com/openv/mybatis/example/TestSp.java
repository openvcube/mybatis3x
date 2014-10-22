package com.openv.mybatis.example;

import com.openv.mybatis.example.dao.StoreProcedureDAO;

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
public class TestSp {
    
	
	public static void main(String[] args) {
		StoreProcedureDAO dao=new StoreProcedureDAO();
		System.out.println("........1........");
		dao.callGetLastName();
		System.out.println("........2........");
		dao.callGetLastNameAnnotations();

		System.out.println("........3........");
		dao.callGetMany();
		System.out.println("........4........");
		dao.callGetManyAnnotations();
		
	}
}
