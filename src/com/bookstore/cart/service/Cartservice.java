package com.bookstore.cart.service;

import com.bookstore.cart.dao.Cartdao;
import com.bookstore.category.domain.Book;

public class Cartservice {
 Cartdao dao=new Cartdao();

public Book findbook(String bid) {
	// TODO Auto-generated method stub
	return dao.findbookbyid(bid);
}
}
