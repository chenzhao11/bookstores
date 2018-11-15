package com.bookstore.book.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bookstore.category.domain.Book;

import cn.itcast.jdbc.TxQueryRunner;

public class Bookdao {
  QueryRunner qr=new TxQueryRunner();

public List<Book> findall() {
	List<Book> list;
	String sql="select * from book";
	try {
		list=qr.query(sql, new BeanListHandler<Book>(Book.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	throw new RuntimeException(e);
	}
	return list;
}

public Book findBook(String bid) {
	Book book=new Book();
	String sql="select * from book where bid=?";
	try {
		book=qr.query(sql, new BeanHandler<Book>(Book.class),bid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	
	return book;
}
}
