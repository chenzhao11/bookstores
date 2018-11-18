package com.bookstore.order.service;

import java.sql.SQLException;
import java.util.List;

import com.bookstore.category.domain.Book;
import com.bookstore.order.dao.Ordersdao;
import com.bookstore.order.domain.Orderitem;
import com.bookstore.order.domain.Orders;

import cn.itcast.jdbc.JdbcUtils;

public class Ordersservice {
    static Ordersdao dao=new Ordersdao();




	public boolean addorder(Orders orders, List<Orderitem> orderitem) throws SQLException {
		if(orders.getState()==1)return false;
		JdbcUtils.beginTransaction();
		try {
			dao.addorder(orders);
			dao.additem(orderitem);
		
			
			
			
		}catch(Exception e) {
			JdbcUtils.rollbackTransaction();
			throw new RuntimeException(e);
		}
		JdbcUtils.commitTransaction();
		
		return true;
	}




	public static List<Orderitem> findorderbook(String oid) {
		List<Orderitem> list=dao.findorderbook(oid);
		for (Orderitem orderitem : list) {
			orderitem.setBook(dao.findbookbybid(orderitem.getBid()));
		}
		return list;
	}




	public List<Orders> finduserorder(String uid) {
		// TODO Auto-generated method stub
		return dao.finduserorder(uid);
	}




	public Orders findorderbyoid(String oid) {
		// TODO Auto-generated method stub
		return dao.findorderbyoid(oid);
	}




	public void confir(String oid) {
		dao.confir(oid);
		
	}
	
	public boolean safe (String oid) {
		int state=dao.seestatebyoid(oid);
		if(state!=2)return  true;
		return false;
	}




	public boolean paysafe(String oid) {
		int state=dao.seestatebyoid(oid);
		if(state!=0)return  true;
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
