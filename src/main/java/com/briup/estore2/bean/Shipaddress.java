package com.briup.estore2.bean;

import java.io.Serializable;

/**
 * 
 * @author 26503
 * 收货地址
 */
public class Shipaddress implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private Long id;
	/**
	 * 地址信息
	 */
	private String shipuname;
	/**
	 * 订单的流水记录号
	 */
	private String adres;
	/**
	 * 顾客手机号
	 */
	private String phone;
	
	//多对一
	private Customer customer;
	
	public Shipaddress() {
		super();
	}

	public Shipaddress(Long id, String shipuname, String adres, String phone, Customer customer) {
		super();
		this.id = id;
		this.shipuname = shipuname;
		this.adres = adres;
		this.phone = phone;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShipuname() {
		return shipuname;
	}

	public void setShipuname(String shipuname) {
		this.shipuname = shipuname;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Shipaddress [id=" + id + ", shipuname=" + shipuname + ", adres=" + adres + ", phone=" + phone
				+ ", customer=" + customer + "]";
	}

}
