package com.bookstore.category.web.servlet;

import cn.itcast.servlet.BaseServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.category.domain.Book;
import com.bookstore.category.domain.Category;
import com.bookstore.category.service.Categoryservice;

/**
 * Servlet implementation class Category
 */
public class Categoryservlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	Categoryservice service=new Categoryservice();
    /**
     * @see BaseServlet#BaseServlet()
     */
    public Categoryservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	  List<Category> list =service.findall();
    	   request.setAttribute("categorylist",list);
  
    	return "f:/jsps/left.jsp";
	}
    public String clickcategory(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	  List<Book> list =service.findbycid(request.getParameter("cid"));
    	   request.setAttribute("clickcategorylist",list);
  
    	return "f:/jsps/book/list.jsp";
	}
	

}
