package com.bookstore.order.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.order.domain.Orderitem;
import com.bookstore.order.domain.Orders;
import com.bookstore.order.service.Ordersservice;
import com.bookstore.user.domain.User;

/**
 * Servlet implementation class Ordersservlet
 */
public class Ordersservlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    Ordersservice service=new Ordersservice();   
    /**
     * @see BaseServlet#BaseServlet()
     */
    public Ordersservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public String buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<com.bookstore.cart.domain.Orderitem> sessionlist=(List<com.bookstore.cart.domain.Orderitem>) 
				request.getSession().getAttribute("cartlist");
	
		List<Orderitem> orderitem=new ArrayList<>();
		User usersession=(User) request.getSession().getAttribute("User_session");
		if(usersession==null) return "f:/jsps/user/login.jsp";
		Object obj=request.getSession().getAttribute("total");
		if(obj==null) obj=0;
		BigDecimal total=new BigDecimal(obj.toString());
		String oid=CommonUtils.uuid();
		if(sessionlist==null) {   request.setAttribute("msg", "你先选！！！");return"f:/jsps/msg.jsp";}
		for (com.bookstore.cart.domain.Orderitem session : sessionlist) {
			Orderitem tem=new Orderitem();
			tem.setBid(session.getBid());
			tem.setCount(session.getCount());
			tem.setOid(oid);
			tem.setSubtotal(session.getSubtotal());
			tem.setIid(CommonUtils.uuid());
			tem.setBook(session.getBook());
			orderitem.add(tem);
		}
		Orders orders=new Orders();
		orders.setOid(oid);
		orders.setAddress("sichuan");		
		orders.setOrdertime(new Date());
		orders.setState(0);
		orders.setTotal(total);
		orders.setUid(usersession.getUid());
		if(service.addorder(orders,orderitem))request.getSession().removeAttribute("cartlist");
		else{request.setAttribute("msg", "生成订单出了一点错误请重新操作！！！！");
		return "f:/jsps/msg.jsp";}/*
		*转发到拎desc.jsp页面的时候用到遍历所以还是用一个List
		*/
		
		request.setAttribute("order", orders);
		request.setAttribute("orderitemlist", orderitem);
		request.getSession().removeAttribute("cartlist");
		request.getSession().removeAttribute("total");
		return "/jsps/order/desc.jsp";
	}
	public String showorders(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
            User user=(User) request.getSession().getAttribute("User_session");		
		    if(user==null) {
		    	request.setAttribute("msg", "先登录再说！！！");
		    	return "f:/jsps/msg.jsp";
		    }
		    List<Orders> orderlist=new ArrayList<>();
		    orderlist=service.finduserorder(user.getUid());
		    request.setAttribute("orderlist", orderlist);
			return"f:/jsps/order/list.jsp";

	}
	

	
	public String pay(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
	     String oid=request.getParameter("oid");
	     if(service.paysafe(oid)) {
				request.setAttribute("msg", "请不要捣乱,已经给过了！！！！");
				return "f:/jsps/msg.jsp";}
	     List<Orderitem> orderitemlist=new ArrayList<Orderitem>();
	     Orders order=new Orders();
	     order=service.findorderbyoid(oid);
	     orderitemlist=service.findorderbook(oid);
	     request.setAttribute("orderitemlist", orderitemlist);
	     request.setAttribute("order", order);
	     return "f:/jsps/order/desc.jsp";
	}
	

	public String confir(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		
		
		String oid=request.getParameter("oid");
		if(service.safe(oid)) {
			request.setAttribute("msg", "请不要捣乱！！！！");
			return "f:/jsps/msg.jsp";}
		
		
		service.confir(oid);
		request.setAttribute("msg", "haha收货成功！！！！");
		
		return "f:/jsps/msg.jsp";
	}

	
	
	
}
