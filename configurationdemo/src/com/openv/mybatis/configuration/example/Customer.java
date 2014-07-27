/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.configuration.example;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * <pre>
 * customer表对应的POJO。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
@Alias("customer")
public class Customer implements Serializable{
	private static final long serialVersionUID = 4686780148191860583L;
	private int customerId;
	private short storeId;
	private String firstName;
	private String lastName;
	private String email;
	private String addressId;
	private short active;
	private Date createDate;
	private Date lastUpdate;
	private String remark;

	public Customer() {
	}
	
	/**
	 * 
	 */
	public Customer(String remark) {
		this.remark  = remark;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}
 
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public short getStoreId() {
		return storeId;
	}
 
	public void setStoreId(short storeId) {
		this.storeId = storeId;
	}

	public String getFirstName() {
		return firstName;
	}
 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public short getActive() {
		return active;
	}

	public void setActive(short active) {
		this.active = active;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	/**
	 * 重写toString()方法，用于返回对象的所有信息。
	 */
	@Override
	public String toString(){
		StringBuffer str = new StringBuffer();
		str.append("customerId：").append(this.customerId).append(",\n");
		str.append("storeId：").append(this.storeId).append(",\n");
		str.append("firstName：").append(this.firstName).append(",\n");
		str.append("lastName：").append(this.lastName).append(",\n");
		str.append("email：").append(this.email).append(",\n");
		str.append("addressId：").append(this.addressId).append(",\n");
		str.append("active：").append(this.active).append(",\n");
		str.append("createDate：").append(this.createDate).append(",\n");
		str.append("lastUpdate：").append(this.lastUpdate).append(",\n");
		str.append("remark：").append(this.remark).append(",\n");
		return str.toString();
	}
	
	/**
	 * @return 返回 remark。
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark 设置 remark。
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
 
}
