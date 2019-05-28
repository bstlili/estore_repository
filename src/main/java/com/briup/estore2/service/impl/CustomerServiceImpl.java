package com.briup.estore2.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore2.bean.Customer;
import com.briup.estore2.dao.CustomerDao;
import com.briup.estore2.service.CustomerService;
import com.briup.estore2.util.MyBatisSqlSessionFactory;
import com.briup.estore2.util.exception.CustomerException;

public class CustomerServiceImpl implements CustomerService{

	SqlSession session = MyBatisSqlSessionFactory.openSession();
	CustomerDao dao = session.getMapper(CustomerDao.class);
	@Override
	public void register(Customer customer) throws CustomerException {
		//1.调用dao层保存数据
		dao.saveCustomer(customer);
		session.commit();
	}

	@Override
	public Customer findCustomerByName(String name) throws CustomerException {
		// TODO Auto-generated method stub
		Customer customer=dao.findCustomerByName(name);
		return customer;
	}

	@Override
	public Customer findCustomerById(Long id) throws CustomerException {
		Customer customer=dao.findCustomerById(id);
		return customer;
	}

}
