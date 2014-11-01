package com.openv.mybatis.example.mapper;

import java.util.List;

import com.openv.mybatis.example.vo.CustomerVO;


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
public interface VelocityMapper {

	List<CustomerVO> getNameWithParam(CustomerVO param);
	
	List<CustomerVO> getNameWithExpression(CustomerVO param);
	
	List<CustomerVO> getNameWithIterExpression(CustomerVO param);

 }
