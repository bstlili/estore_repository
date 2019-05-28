package com.briup.estore2.bean;

import java.util.Collection;
import java.util.HashSet;

/**
 * 
 * @author 26503
 * 顾客
 */
public class Customer {
	/**
	 * 编号
	 */
	private long id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 邮编
	 */
	private String zip;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 电子邮件
	 */
	private String email;
	
	//一对多 
	private Collection<OrderForm> orderForm=new HashSet<>();
	//一对多
	private Collection<Shipaddress> shipaddress=new HashSet<>();
	
	public Customer() {
		super();
	}
	
	public Customer(long id, String name, String password, String zip, String address, String telephone, String email,
			Collection<OrderForm> orderForm, Collection<Shipaddress> shipaddress) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.orderForm = orderForm;
		this.shipaddress = shipaddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Collection<OrderForm> getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(Collection<OrderForm> orderForm) {
		this.orderForm = orderForm;
	}

	public Collection<Shipaddress> getShipaddress() {
		return shipaddress;
	}

	public void setShipaddress(Collection<Shipaddress> shipaddress) {
		this.shipaddress = shipaddress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", zip=" + zip + ", address="
				+ address + ", telephone=" + telephone + ", email=" + email + ", orderForm=" + orderForm
				+ ", shipaddress=" + shipaddress + "]";
	}
	
}
