package com.bookstore.cart.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.bookstore.category.domain.Book;

import cn.itcast.jdbc.TxQueryRunner;

public class Cartdao {
  QueryRunner qr=new TxQueryRunner();

public Book findbookbyid(String bid) {
	String sql="select * from book where bid=?";
	Book book=new Book();
	try {
		book=qr.query(sql, new BeanHandler<Book>(Book.class),bid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return book;
}

}
