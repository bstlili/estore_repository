package com.briup.estore2.service;

import java.util.List;

import com.briup.estore2.bean.OrderForm;
import com.briup.estore2.util.exception.OrderFormException;

public interface OrderFormService {
	//保存订单
	public void confirmOrder(OrderForm order) throws OrderFormException;
	//查询所有订单
	public List<OrderForm> findAllOrderByCustomerId(Long id) throws OrderFormException; 
	//通过id删除订单
	public void delOrderById(Long id) throws OrderFormException;
}
