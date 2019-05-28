package com.briup.estore2.test;

import java.util.List;

import com.briup.estore2.bean.Shipaddress;
import com.briup.estore2.service.impl.ShipaddressServiceImpl;
import com.briup.estore2.util.exception.ShipaddressException;

public class TestFindShipaddress {
	
	public static void main(String[] args) throws ShipaddressException {
		ShipaddressServiceImpl serviceImpl = new ShipaddressServiceImpl();
		List<Shipaddress> list = serviceImpl.findShipaddressByCustomerId(64L);
		for (Shipaddress s : list) {
			System.out.println(s);
		}
		
	}
}
