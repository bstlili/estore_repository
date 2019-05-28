package com.briup.estore2.dao;

import com.briup.estore2.bean.Customer;

public interface CustomerDao {
	//保存用户信息到数据库
	void saveCustomer(Customer customer);
	Customer findCustomerByName(String name);
	Customer findCustomerById(Long id);
}
