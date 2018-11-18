package com.bookstore.order.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.bookstore.category.domain.Book;
import com.bookstore.order.domain.Orderitem;
import com.bookstore.order.domain.Orders;

import cn.itcast.jdbc.TxQueryRunner;

public class Ordersdao {
   TxQueryRunner qr=new TxQueryRunner();

public void additem(List<Orderitem> orderitem) {
	String sql="insert into orderitem values(?,?,?,?,?)";
	Object [][]parm=new Object[orderitem.size()][];
	for(int i=0;i<orderitem.size();i++) {
		Orderitem item=new Orderitem();
		item=orderitem.get(i);
		parm[i]=
	new Object[]{item.getIid(),item.getCount(),item.getSubtotal(),item.getOid(),item.getBid()};	
    }
	try {
		qr.batch(sql, parm);
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
public void addorder(Orders orders) {
	String sql="insert into orders values(?,?,?,?,?,?)";
	Timestamp timestamp=new Timestamp(orders.getOrdertime().getTime());
	Object obj[]= {
			orders.getOid(),timestamp,orders.getTotal(),orders.getState()
			,orders.getUid(),orders.getAddress()
			
	};
	try {
		qr.update(sql, obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}	
}
public List<Orderitem> findorderbook(String oid) {
	String sql="select * from orderitem where oid=?";// TODO Auto-generated method stub
	List<Orderitem> list=new ArrayList<Orderitem>();
	try {
		list=qr.query(sql, new BeanListHandler<Orderitem>(Orderitem.class),oid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	return list;
}
public List<Orders> finduserorder(String uid) {
	String sql="select * from orders where uid=?";
	List<Orders> list=new ArrayList<>();
	try {
		list=qr.query(sql,new BeanListHandler<Orders>(Orders.class),uid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	return list;
}
public Book findbookbybid(String bid) {
	String sql="select * from book where bid=?";
	Book book=new Book();
	try {
		book=qr.query(sql, new BeanHandler<Book>(Book.class),bid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	return book;
}
public Orders findorderbyoid(String oid) {
	String sql="select * from orders where oid=?";
	Orders order=new Orders();
	try {
		order=qr.query(sql, new BeanHandler<Orders>(Orders.class),oid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	return order;
}
public void confir(String oid) {
	String sql="update orders set state=3 where oid=?";
	try {
		qr.update(sql,oid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	
	
}
public int seestatebyoid(String oid) {
	String sql="select state from orders where oid=?";
	int state;
	try {
		state=(int) qr.query(sql,new ScalarHandler(),oid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	return state;
}





















}
