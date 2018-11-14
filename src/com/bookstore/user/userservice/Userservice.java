package com.bookstore.user.userservice;

import com.bookstore.user.domain.User;
import com.bookstore.user.user.web.servlet.ActiveException;
import com.bookstore.user.user.web.servlet.UserException;
import com.bookstore.user.user.web.servlet.UserLoginException;
import com.bookstore.user.userdao.Userdao;

public class Userservice {
	Userdao userdao=new Userdao();

	public void adduser(User user) throws UserException {
		if(userdao.findByName(user.getUsername())!=null)throw new UserException("用户名已经存在！！");
		if(userdao.findByEmail(user.getEmail())!=null)throw new UserException("Email已经注册过！！");
		userdao.adduser(user);
	}

	public void activecode(String code) throws ActiveException {
		User user=new User();
		user=userdao.findByCode(code);
		if(!code.equals(user.getCode()))throw new ActiveException("你的验证码是错的！！！");
		if(user.getState()==1)throw new ActiveException("你已经激活过了就不要再激活了！！！");
		userdao.changestates(user);
		
		
	}

	public User login(String username, String password) throws UserLoginException {
		User user=new User();
		user=userdao.findByName(username);
		if(user==null) {
			throw new UserLoginException("没有这个用户！！");
		}
		if(!user.getPassword().equals(password)) throw new UserLoginException("密码错了哦~！！！");
		if(user.getState()==0) throw new UserLoginException("快点去邮箱激活吧！！！");
		
		return user;
	}

}
