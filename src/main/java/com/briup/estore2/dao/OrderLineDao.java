package com.briup.estore2.dao;

import com.briup.estore2.bean.OrderLine;

public interface OrderLineDao {
	//保存line
	public void saveLine(OrderLine line);
	//通过订单编号删除订单项
	public void delLineByOrderId(Long id);
}
