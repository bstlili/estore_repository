package com.briup.estore2.dao;

import java.util.List;

import com.briup.estore2.bean.Shipaddress;

public interface ShipaddressDao {
	//添加地址
	public void addShipaddress(Shipaddress shipaddress);
	//通过用户id查询所有地址
	public List<Shipaddress> findShipaddressByCustomerId(Long id);
	//通过id查询所有地址
	public Shipaddress findShipaddressById(Long id);
}
