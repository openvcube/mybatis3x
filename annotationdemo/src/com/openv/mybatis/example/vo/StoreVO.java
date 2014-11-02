package com.openv.mybatis.example.vo;

import java.util.List;

public class StoreVO {
  private int id;
  private int addressId;
  private List<CustomerVO> customers;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public int getAddressId() {
	return addressId;
}

public void setAddressId(int addressId) {
	this.addressId = addressId;
}

public List<CustomerVO> getCustomers() {
	return customers;
}

public void setCustomers(List<CustomerVO> customers) {
	this.customers = customers;
}
  
  
}
