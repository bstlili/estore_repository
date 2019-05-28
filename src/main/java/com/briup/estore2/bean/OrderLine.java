package com.briup.estore2.bean;

/**
 * 
 * 订单项
 *
 */
public class OrderLine {
	/**
	 * 编号
	 */
	private Long id;
	/**
	 * 数量
	 */
	private int num;
	
	/**
	 * 多对一关联
	 */
	//OrderForm
	private OrderForm oderform;
	/**
	 * 多对一关联
	 */
	private Book book;

	public OrderLine() {
		super();
	}
	

	public OrderLine(Long id, int num, OrderForm oderform, Book book) {
		super();
		this.id = id;
		this.num = num;
		this.oderform = oderform;
		this.book = book;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public OrderForm getOderform() {
		return oderform;
	}

	public void setOderform(OrderForm oderform) {
		this.oderform = oderform;
	}


	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", num=" + num + ", oderform=" + oderform + ", book=" + book + "]";
	}

}
