package com.bookstore.cart.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.bookstore.category.domain.Book;

public class Orderitem {
private Book book;
private Integer count;
private BigDecimal subtotal;


public BigDecimal getSubtotal() {
	return BigDecimal.valueOf(book.getPrice()*count);
}
public String getAuthor() {
	return book.getAuthor();
}
public String getBid() {
	return book.getBid();
}
public String getBname() {
	return book.getBname();
}
public String getImage() {
	return book.getImage();
}
public int getPrice() {
	return book.getPrice();
}
public String getCid() {
	return book.getCid();
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
@Override
public String toString() {
	return "Orderitem [book=" + book + ", count=" + count + ", subtotal=" + subtotal + "]";
}


}
