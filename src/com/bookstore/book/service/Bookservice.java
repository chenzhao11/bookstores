package com.bookstore.book.service;

import java.util.List;

import com.bookstore.book.dao.Bookdao;
import com.bookstore.category.domain.Book;

public class Bookservice {
 Bookdao dao=new Bookdao();

public List<Book> findall() {
	
	
	return dao.findall();
}

public Book findbook(String bid) {
	// TODO Auto-generated method stub
	return dao.findBook(bid);
}


}
