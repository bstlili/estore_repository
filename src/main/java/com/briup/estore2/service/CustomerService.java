package com.briup.estore2.service;

import com.briup.estore2.bean.Customer;
import com.briup.estore2.util.exception.CustomerException;

public interface CustomerService {
	//注册用户
	void register(Customer customer) throws CustomerException;
	//通过用户名查询用户
	Customer findCustomerByName(String name) throws CustomerException;
	//通过用户ID查询用户
	Customer findCustomerById(Long id) throws CustomerException;
}
