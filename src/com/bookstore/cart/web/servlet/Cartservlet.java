package com.bookstore.cart.web.servlet;

import cn.itcast.servlet.BaseServlet;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
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
		/*
		 * 这里为了使用后来加入的订单直接加入到以前相同的里面我们因为前面使用的是List 加入要实现的话改成用map的就可以了
		 */
		Orderitem orderitem=new Orderitem();
		orderitem.setBook(service.findbook(request.getParameter("bid")));
		Integer count=new Integer(request.getParameter("count"));
		orderitem.setCount(count);
		Object obj=request.getSession().getAttribute("total");
		if(obj==null) obj=0;
		String sessiontatal=obj.toString();
		
		BigDecimal sub=new BigDecimal(sessiontatal.trim());
		BigDecimal sessiontotal=sub;
		if(sessiontotal==null) sessiontotal=new BigDecimal(0);
		BigDecimal subtotal=orderitem.getSubtotal();
		BigDecimal total=subtotal.add(sessiontotal);
		request.getSession().setAttribute("total",total );
		String bid=request.getParameter("bid");
		for (Orderitem orderitem1 : cart) {
			if(orderitem1.getBid().equals(bid)) {
				orderitem1.setCount(Integer.parseInt(request.getParameter("count"))+orderitem1.getCount());

				return "/jsps/cart/list.jsp";
			}
		}
		
		
		cart.add(orderitem);
		request.getSession().setAttribute("cartlist", cart);
	
		return "/jsps/cart/list.jsp";
	}

	public String clearall(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getSession().setAttribute("total", 0);
		request.getSession().removeAttribute("cartlist");
	return "/jsps/cart/list.jsp";
	}
	public String delete (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/*
		 * 每一次删掉一本书就要重新算一下total
		 */
	
		BigDecimal sessiontotal=new BigDecimal(request.getParameter("subtotal").toString());
//		if(sessiontotal==null) sessiontotal=new BigDecimal(0);
		Object obj=request.getSession().getAttribute("total");
		if(obj==null) obj=0;
		String sessiontatal=obj.toString();
		if(sessiontatal==null) sessiontatal="0";
		BigDecimal sub=new BigDecimal(sessiontatal.trim());
		
		BigDecimal total=sub.subtract(sessiontotal);
		request.getSession().setAttribute("total",total );
		
		/*
		 * 这里应该用图来实现的但是前面用了List已经用
		 * 
		 */
		String bid=request.getParameter("bid");
		List<Orderitem> list=(List<Orderitem>) request.getSession().getAttribute("cartlist");
		for (Orderitem orderitem1 : list) {
			if(orderitem1.getBid().equals(bid)) {
				list.remove(orderitem1);
				return "/jsps/cart/list.jsp";
			}
		}
	return "/jsps/cart/list.jsp";
	}
	
	
	
	
	
	
	
	
}
