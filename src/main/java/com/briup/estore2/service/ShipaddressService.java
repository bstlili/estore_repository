package com.briup.estore2.service;

import java.util.List;

import com.briup.estore2.bean.Shipaddress;
import com.briup.estore2.util.exception.ShipaddressException;

public interface ShipaddressService {
	//�����ַ��Ϣ
	public void addShipaddress(Shipaddress shipaddress) throws ShipaddressException;
	//�����û���ѯ���е�ַ
	public List<Shipaddress> findShipaddressByCustomerId(Long id) throws ShipaddressException;
	//����ID��ѯ���е�ַ
	public Shipaddress findShipaddressById(Long id) throws ShipaddressException;


}
