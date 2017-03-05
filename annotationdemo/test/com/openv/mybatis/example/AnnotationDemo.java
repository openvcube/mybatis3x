package com.openv.mybatis.example;

import com.openv.mybatis.example.dao.AnnotationDAO;

/**
 * <pre>
 * 程序的中文名称。
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
public class AnnotationDemo {

	public static void main(String[] args) {
		AnnotationDAO dao = new AnnotationDAO();
		int countryId = 1024;
		int countryId2 = 2048;
		
		dao.insertCountry(countryId);
		dao.updateCountry(countryId);
		dao.delCountry(countryId);
		dao.selectCountry();
		dao.selectCustomer();
		dao.slectSotre();
		dao.insertCountryWithProvider(countryId2);
		dao.updateCountryWithProvider(countryId2);
		dao.delCountryWithProvider(countryId2);
		dao.selectCountryWithProvider();
	}

}
