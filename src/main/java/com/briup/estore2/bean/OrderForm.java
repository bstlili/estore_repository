package com.briup.estore2.bean;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 *@author 26503
 *@version 1.0
 *
 *订单
 */
public class OrderForm {
	/**
	 * 记录流水号
	 */
	private Long id;
	/**
	 * 订单总额
	 */
	private double cost;
	/**
	 * 下单时间
	 */
	private Date orderDate;
	
	private Collection<OrderLine> orderLine=new HashSet<>();
	
	//多对一关联
	private Customer customer;
	//多对一关联
	private Shipaddress shipaddress;
	
	public OrderForm() {
		//super();
	}

	public OrderForm(Long id, double cost, Date orderDate, Collection<OrderLine> orderLine, Customer customer,
			Shipaddress shipaddress) {
		super();
		this.id = id;
		this.cost = cost;
		this.orderDate = orderDate;
		this.orderLine = orderLine;
		this.customer = customer;
		this.shipaddress = shipaddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	
	
	public Collection<OrderLine> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(Collection<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shipaddress getShipaddress() {
		return shipaddress;
	}

	public void setShipaddress(Shipaddress shipaddress) {
		this.shipaddress = shipaddress;
	}

	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", cost=" + cost + ", orderDate=" + orderDate + ", orderLine=" + orderLine
				+ ", customer=" + customer + ", shipaddress=" + shipaddress + "]";
	}

}
