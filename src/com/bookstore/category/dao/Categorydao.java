package com.bookstore.category.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.bookstore.category.domain.Book;
import com.bookstore.category.domain.Category;

import cn.itcast.jdbc.TxQueryRunner;

public class Categorydao {

	QueryRunner runner=new TxQueryRunner();

public List<Category> findall() {
	String sql="SELECT * FROM category " ;
	List<Category> list=null;
	try {
		 list=runner.query(sql,new BeanListHandler<Category>(Category.class));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	   new RuntimeException(e);
	}
	return list;
}

public List<Book> findbycid(String cid) {
	String sql="select * from book where cid=?";
	List<Book> list=null;
	try {
		list=runner.query(sql,new BeanListHandler<Book>(Book.class),cid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	return list;
}


}
