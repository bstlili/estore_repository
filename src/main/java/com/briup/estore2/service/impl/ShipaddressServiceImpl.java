package com.briup.estore2.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore2.bean.Shipaddress;
import com.briup.estore2.dao.ShipaddressDao;
import com.briup.estore2.service.ShipaddressService;
import com.briup.estore2.util.MyBatisSqlSessionFactory;
import com.briup.estore2.util.exception.ShipaddressException;

public class ShipaddressServiceImpl implements ShipaddressService{

	@Override
	public void addShipaddress(Shipaddress shipaddress) throws ShipaddressException {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		ShipaddressDao dao = session.getMapper(ShipaddressDao.class);
		dao.addShipaddress(shipaddress);
		session.commit();
	}

	@Override
	public List<Shipaddress> findShipaddressByCustomerId(Long id) throws ShipaddressException {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		ShipaddressDao dao = session.getMapper(ShipaddressDao.class);
		List<Shipaddress> shipaddress = dao.findShipaddressByCustomerId(id);
		return shipaddress;
	}

	@Override
	public Shipaddress findShipaddressById(Long id) throws ShipaddressException {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		ShipaddressDao dao = session.getMapper(ShipaddressDao.class);
		Shipaddress shipaddress = dao.findShipaddressById(id);
		return shipaddress;
	}

}
