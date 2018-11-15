package com.bookstore.book.web.servlet;

import cn.itcast.servlet.BaseServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.book.service.Bookservice;
import com.bookstore.category.domain.Book;

/**
 * Servlet implementation class Bookservlet
 */
public class Bookservlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    Bookservice service=new Bookservice();  
    /**
     * @see BaseServlet#BaseServlet()
     */
    public Bookservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list;
		list=service.findall();
		request.setAttribute("clickcategorylist", list);
		
		return "f:/jsps/book/list.jsp";
	}
	public String findbybid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book=new Book();
		String bid=request.getParameter("bid");
		book=service.findbook(bid);
		request.setAttribute("book", book);
		return "f:/jsps/book/desc.jsp";
	}


}
