package com.briup.estore2.service;

import com.briup.estore2.bean.Customer;
import com.briup.estore2.util.exception.CustomerException;

public interface CustomerService {
	//ע���û�
	void register(Customer customer) throws CustomerException;
	//ͨ���û�����ѯ�û�
	Customer findCustomerByName(String name) throws CustomerException;
	//ͨ���û�ID��ѯ�û�
	Customer findCustomerById(Long id) throws CustomerException;
}
