package com.briup.estore2.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShoppingCar {
	// key 商品id value 订单项（商品，数量）
	private Map<Long, OrderLine> map = new HashMap<Long, OrderLine>();
	
	//OrderLine[id num book[id name price]]
	/**
	 * 向购物车中添加产品
	 * 先判断购物车中有没有该产品的订单项目，如果有，在数量上做改变，
	 * 如果没有向map中添加
	 * @param OrderLine
	 */
	public void add(OrderLine OrderLine,int num){
		if(map.containsKey(OrderLine.getBook().getId())){
			OrderLine oldOrderLine = map.get(OrderLine.getBook().getId());
			oldOrderLine.setNum(oldOrderLine.getNum()+num);
		}else{
			OrderLine.setNum(num);
			map.put(OrderLine.getBook().getId(), OrderLine);
		}
	}
	/**
	 * 删除订单
	 * */
	public void delete(Long bookId){
		map.remove(bookId);
	}
	
	/**
	 * 获取购物车中订单项的数量
	 */
	public int getCount(){
		return map.size();
	}
	/*
	 * 获取价钱
	 * */
	public double getCost(){
		Set<Long> keySet = map.keySet();
		Iterator<Long> iter = keySet.iterator();
		double cost = 0.0;
		while(iter.hasNext()){
			Long key = iter.next();
			OrderLine value = map.get(key);
			Integer num = value.getNum();
			double price = value.getBook().getPrice();
			double orderLineCost = num*price;
			cost += orderLineCost;
		}
		return cost;
	}
	/**
	 * 获取购物车中所有订单项
	 * List<OrderLine>
	 * */
	public Map<Long, OrderLine> getOrderLine(){
		return map;
	}
	/**
	 * 清空购物车
	 * */
	public void clear(){
		map.clear();
	}
	/**
	 * 更新购物车
	 * */
	public void update(long id,int num){
		OrderLine orderLine = map.get(id);
		orderLine.setNum(num);
	}
	
}
