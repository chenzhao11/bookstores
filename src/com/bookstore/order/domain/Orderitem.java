package com.bookstore.order.domain;

import java.math.BigDecimal;

import com.bookstore.category.domain.Book;

public class Orderitem {

	private String iid;
	private String oid;
	private String bid;
	private Book book;
	private BigDecimal subtotal;
	private int count;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Orderitem [iid=" + iid + ", oid=" + oid + ", bid=" + bid + ", book=" + book + ", subtotal=" + subtotal
				+ ", count=" + count + "]";
	}
	
	
}
