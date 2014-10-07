/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example.paged;

import java.io.Serializable;
import java.util.List;

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
public class PageResult<T> implements Serializable {
	 
	private static final long serialVersionUID = -7237299081219737476L;
	int pageIndex;
	int pageSize;
	int totalNum;
	int totalPage;
	List<T> data;
	/**
	 * @return 返回 pageIndex。
	 */
	public int getPageIndex() {
		return pageIndex;
	}
	/**
	 * @param pageIndex 设置 pageIndex。
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
 
	/**
	 * @return 返回 totalPage。
	 */
	public int getTotalPage() {
		if(pageSize!=0){
			int t = totalNum/pageSize;
			if(totalNum%pageSize!=0){
				t++;
			}
			totalPage = t;
		}
		return totalPage;
	}
	/**
	 * @param totalPage 设置 totalPage。
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return 返回 data。
	 */
	public List<T> getData() {
		return data;
	}
	/**
	 * @param data 设置 data。
	 */
	public void setData(List<T> data) {
		this.data = data;
	}
	/**
	 * @return 返回 pageSize。
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize 设置 pageSize。
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return 返回 totalNum。
	 */
	public int getTotalNum() {
		return totalNum;
	}
	/**
	 * @param totalNum 设置 totalNum。
	 */
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
 
	
}
