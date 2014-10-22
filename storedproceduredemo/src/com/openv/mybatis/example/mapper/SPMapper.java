package com.openv.mybatis.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import com.openv.mybatis.example.vo.SpManyVO;
import com.openv.mybatis.example.vo.SpOneVO;


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
public interface SPMapper {

	String callGetLastName(SpOneVO param);
	List<SpManyVO> callGetMany();

	
	
	//下面是使用annotations
	
	@Select(value= "{ CALL openv_sp_one( #{email, mode=IN, jdbcType=VARCHAR}, #{lastName, mode=OUT, jdbcType=VARCHAR})}")
	@Options(statementType = StatementType.CALLABLE)
	Object callGetLastNameAnnotations(SpOneVO param);
	
	 
	@Select(value= "{ CALL openv_sp_many()}")
	@Options(statementType = StatementType.CALLABLE)
	@Results(value = {
		@Result(property="firstName", column="first_name"),
		@Result(property="lastName", column="last_name"),
		@Result(property="email", column="email"),
	})
	List<SpManyVO> callGetManyAnnotations();
}
