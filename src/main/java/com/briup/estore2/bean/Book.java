package com.briup.estore2.bean;
/**
 * Book 用户购买的书本
 */
public class Book {
	/**
	 * 书的编号
	 */
	private Long id;
	/**
	 * 书名
	 */
	private String name;
	/**
	 * 价格
	 */
	private int price;
	/**
	 * 类型
	 */
	private String type;
	
	
	
	public Book() {
		super();
	}

	public Book(Long id, String name, int price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + "]";
	}

	
	
}
