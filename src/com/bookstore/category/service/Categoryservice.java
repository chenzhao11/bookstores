package com.bookstore.category.service;

import java.util.List;

import com.bookstore.category.dao.Categorydao;
import com.bookstore.category.domain.Book;
import com.bookstore.category.domain.Category;


public class Categoryservice {
   Categorydao dao=new Categorydao();

public List<Category> findall() {
              
	return dao.findall();
}

public List<Book> findbycid(String cid) {
	
	return dao.findbycid(cid);
}
}