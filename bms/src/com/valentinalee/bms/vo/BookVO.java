package com.valentinalee.bms.vo;

public class BookVO {

	/**
	 * 图书编号
	 */
	private String id;
	
	/**
	 * 图书名称
	 */
	private String name;
	
	/**
	 * 图书ISBN号
	 */
	private String ISBN;
	
	/**
	 * 图书作者
	 */
	private String author;
	
	/**
	 * 图书出版社
	 */
	private String publisher;
	
	/**
	 * 图书类型
	 */
	private String bookType;
	
	/**
	 * 图书价格
	 */
	private double price;
	
	/**
	 * 图书库存
	 */
	private int storeAmount;
	
	/**
	 * 图书副本数
	 */
	private int leftAmount;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookType() {
		return this.bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStoreAmount() {
		return this.storeAmount;
	}

	public void setStoreAmount(int storeAmount) {
		this.storeAmount = storeAmount;
	}

	public int getLeftAmount() {
		return this.leftAmount;
	}

	public void setLeftAmount(int leftAmount) {
		this.leftAmount = leftAmount;
	}
	
	
}
