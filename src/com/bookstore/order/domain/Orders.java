package com.bookstore.order.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bookstore.category.domain.Book;
import com.bookstore.order.service.Ordersservice;


public class Orders {
  private String oid; 
  private String uid;
  private String address; 
  private Date ordertime; 
  private BigDecimal total;
  private int state;

public List<Orderitem> getBook() {
	List<Orderitem> book=new ArrayList<Orderitem>();
	book=Ordersservice.findorderbook(oid);
	return book ;
}
public String getOid() {
	return oid;
}
public void setOid(String oid) {
	this.oid = oid;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getOrdertime() {
	return ordertime;
}
public void setOrdertime(Date ordertime) {
	this.ordertime = ordertime;
}
public BigDecimal getTotal() {
	return total;
}
public void setTotal(BigDecimal total) {
	this.total = total;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
@Override
public String toString() {
	return "Orders [oid=" + oid + ", uid=" + uid + ", address=" + address + ", ordertime=" + ordertime + ", total="
			+ total + ", state=" + state + "]";
}

  
}
