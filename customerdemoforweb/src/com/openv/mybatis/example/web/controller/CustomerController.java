/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openv.mybatis.example.bean.Customer;
import com.openv.mybatis.example.paged.PageResult;
import com.openv.mybatis.example.service.ICustomerService;

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
@Controller
public class CustomerController {
	
	@Resource
	ICustomerService customerService;
	
	@RequestMapping("customer.do")
	public String queryCustomer(HttpServletRequest request,HttpServletResponse respone,Model model){
		String pi = request.getParameter("pageIndex");
		String ps = request.getParameter("pageSize");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		int pageIndex = StringUtils.isEmpty(pi)?1:Integer.valueOf(pi);
		int pageSize = StringUtils.isEmpty(ps)?10:Integer.valueOf(ps);
		Customer customer = new Customer();
		
		if("null".equals(firstName)){
			firstName="";
		}
		
		if("null".equals(lastName)){
			lastName="";
		}
		if("null".equals(email)){
			email="";
		}
		
		
		if(!StringUtils.isEmpty(firstName)){
			customer.setFirstName(firstName);
		}
		
		if(!StringUtils.isEmpty(lastName)){
			customer.setLastName(lastName);
		}
		if(!StringUtils.isEmpty(email)){
			customer.setEmail(email);
		}
		
		PageResult<Customer> pr =customerService.queryCustomer(customer, pageIndex, pageSize);

		model.addAttribute("pr", pr);
		model.addAttribute("customer", customer);
		
		return "forward:index.jsp";
	}
	
}
