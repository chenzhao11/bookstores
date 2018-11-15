package com.bookstore.cart.web.servlet;

import cn.itcast.servlet.BaseServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bookstore.cart.domain.Orderitem;
import com.bookstore.cart.service.Cartservice;

/**
 * Servlet implementation class Cartservlet
 */
public class Cartservlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    Cartservice service=new Cartservice();   
    /**
     * @see BaseServlet#BaseServlet()
     */
    public Cartservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	public String addorderitem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Orderitem> cart=null;
		if(request.getSession().getAttribute("cartlist")==null
				) {
		cart=new ArrayList<Orderitem>();
		}
		else {
			cart=(List<Orderitem>) request.getSession().getAttribute("cartlist");
		}
		Orderitem orderitem=new Orderitem();
		orderitem.setBook(service.findbook(request.getParameter("bid")));
		Integer count=new Integer(request.getParameter("count"));
		orderitem.setCount(count);
		cart.add(orderitem);
		request.getSession().setAttribute("cartlist", cart);
	
		return "/jsps/cart/list.jsp";
	}

	

}
