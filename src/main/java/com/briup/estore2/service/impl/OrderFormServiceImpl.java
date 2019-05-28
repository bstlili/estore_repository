package com.briup.estore2.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore2.bean.OrderForm;
import com.briup.estore2.bean.OrderLine;
import com.briup.estore2.dao.OrderFromDao;
import com.briup.estore2.dao.OrderLineDao;
import com.briup.estore2.service.OrderFormService;
import com.briup.estore2.util.MyBatisSqlSessionFactory;
import com.briup.estore2.util.exception.OrderFormException;

public class OrderFormServiceImpl implements OrderFormService{

	@Override
	public void confirmOrder(OrderForm order) throws OrderFormException {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFromDao orderFromDao = session.getMapper(OrderFromDao.class);
		OrderLineDao orderLineDao = session.getMapper(OrderLineDao.class);
		//先保存order,后保存line
		orderFromDao.saveOrder(order);
		for (OrderLine line : order.getOrderLine()) {
			line.setOderform(order);
			orderLineDao.saveLine(line);
		}
		session.commit();
	}

	@Override
	public List<OrderForm> findAllOrderByCustomerId(Long id) throws OrderFormException {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFromDao orderFromDao = session.getMapper(OrderFromDao.class);
		List<OrderForm> orders = orderFromDao.findAllOrderByCustomerId(id);
		
		return orders;
	}

	@Override
	public void delOrderById(Long id) throws OrderFormException {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		OrderFromDao orderFromDao = session.getMapper(OrderFromDao.class);
		OrderLineDao orderLineDao = session.getMapper(OrderLineDao.class);
		//先删除orderLine
		orderLineDao.delLineByOrderId(id);
		//后删除orderForm
		orderFromDao.delOrderById(id);
		//提交事务
		session.commit();
	}
	
	
	public static void main(String[] args) throws OrderFormException {
		OrderFormServiceImpl s = new OrderFormServiceImpl();
		List<OrderForm> orders = s.findAllOrderByCustomerId(64L);
		for (OrderForm orderForm : orders) {
			System.out.println(orderForm);
		}
		
		s.delOrderById(83L);
	}
}
