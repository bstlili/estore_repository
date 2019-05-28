package com.briup.estore2.service;

import java.util.List;

import com.briup.estore2.bean.OrderForm;
import com.briup.estore2.util.exception.OrderFormException;

public interface OrderFormService {
	//���涩��
	public void confirmOrder(OrderForm order) throws OrderFormException;
	//��ѯ���ж���
	public List<OrderForm> findAllOrderByCustomerId(Long id) throws OrderFormException; 
	//ͨ��idɾ������
	public void delOrderById(Long id) throws OrderFormException;
}
