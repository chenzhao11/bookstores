package com.bookstore.user.userdao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.bookstore.user.domain.User;

import cn.itcast.jdbc.TxQueryRunner;

public class Userdao {
  QueryRunner queryrunner=new TxQueryRunner(); 
  
  
  /*
   * 按用户名找人
   * 
   */
 public User findByName(String name) {
	  User user=new User();
	  String sql="select *from tb_user where username=?";
	  try {
		user=queryrunner.query(sql, new BeanHandler<User>(User.class),name);
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	  return user;
  }
  /*
   * 插入对象
   * 
   * */
public void adduser(com.bookstore.user.domain.User user) {
	String sql="insert into tb_user (uid,username,email,state,code,password) values(?,?,?,?,?,?)";
	try {
		queryrunner.update(sql,user.getUid(),user.getUsername(),user.getEmail(),user.getState(),
				user.getCode(),user.getPassword());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	
}
public User findByEmail(String email) {
	String sql="select *from tb_user where email=?"	;
	User user=new User();
	try {
		user=queryrunner.query(sql,new BeanHandler<User>(User.class ),email);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	
	return user;
}
public User findByCode(String code) {
	User user=new User();
	String sql="select * from tb_user where code=?";
	try {
		user=queryrunner.query(sql,new BeanHandler<User>(User.class),code);
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	return user;
}
public void changestates(User user) {
	String sql="update tb_user set state=1 where uid=?";
	try {
		queryrunner.update(sql, user.getUid());
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	
}






}
