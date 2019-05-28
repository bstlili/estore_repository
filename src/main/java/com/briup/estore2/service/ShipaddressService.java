package com.briup.estore2.service;

import java.util.List;

import com.briup.estore2.bean.Shipaddress;
import com.briup.estore2.util.exception.ShipaddressException;

public interface ShipaddressService {
	//保存地址信息
	public void addShipaddress(Shipaddress shipaddress) throws ShipaddressException;
	//根据用户查询所有地址
	public List<Shipaddress> findShipaddressByCustomerId(Long id) throws ShipaddressException;
	//根据ID查询所有地址
	public Shipaddress findShipaddressById(Long id) throws ShipaddressException;


}
