package com.briup.estore2.dao;

import java.util.List;

import com.briup.estore2.bean.OrderForm;
import com.briup.estore2.util.exception.OrderFormException;

public interface OrderFromDao {
	//保存order对象
	public void saveOrder(OrderForm order);
	//查询顾客所有订单
	public List<OrderForm> findAllOrderByCustomerId(Long id);
	//通过id删除订单
	public void delOrderById(Long id);

}
