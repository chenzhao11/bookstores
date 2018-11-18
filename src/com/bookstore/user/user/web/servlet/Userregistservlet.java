package com.bookstore.user.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.user.domain.User;
import com.bookstore.user.userservice.Userservice;
import com.sun.jmx.snmp.daemon.CommunicatorServerMBean;

/**
 * Servlet implementation class Userregistservlet
 */
public class Userregistservlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private Userservice userservice= new Userservice();
    /**
     * @see BaseServlet#BaseServlet()
     */
    public Userregistservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String active (HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	String code=request.getParameter("code");
    	try{userservice.activecode(code);}
    	catch(ActiveException e) {
    		request.setAttribute("mag", e.getMessage());
    		return "f:/jsps/msg.jsp";
    	}
    	request.setAttribute("msg","您已经激活成功了！！");
		return "f:/jsps/msg.jsp";
    }
    
    
    
    
    
    
    public String regist(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		User user=CommonUtils.toBean(request.getParameterMap(), User.class);
		
		HashMap<String, String> erro=new HashMap();
		if(user.getUsername()==null||user.getUsername().trim().isEmpty()) {
			erro.put("username", "username  is empty!!");
		}
		if(user.getUsername().length()>50) {
			erro.put("username", "username's length beyond limit!!   50!");
		}
		if(user.getPassword()==null||user.getPassword().trim().isEmpty()) {
			erro.put("password", "password  is empty!!");
		}
		if(user.getUsername().length()>50) {
			erro.put("password", "password length beyond limit!!   50!");
		}
	    String	email=user.getEmail();
		if(email == null || email.trim().isEmpty()) {
			erro.put("email", "Email不能为空！");
		} 
		else if(!email.matches("\\w+@\\w+\\.\\w+")) {
			erro.put("email", "Email格式错误！");
		}
    	request.setAttribute("erro", erro);
    	if(!erro.isEmpty()) {
    		return "f:/jsps/user/regist.jsp";
    	}
    	user.setCode(CommonUtils.uuid()+CommonUtils.uuid());
    	user.setUid(CommonUtils.uuid());
    	user.setState(0);
    	try {
    	userservice.adduser(user);
    	}catch (UserException e) {
    		request.setAttribute("msg", e.getMessage());
    		/*注意回显*/
    		request.setAttribute("form", user);
    		return "f:/jsps/user/regist.jsp";
    	}
    /*
     * 成功加入了  ，下面开始邮件激活的程序
     */
    	Properties pro=new Properties();
    	pro.load(this.getClass().getClassLoader().getResourceAsStream("mailproperties.properties"));
    	String username=pro.getProperty("username");
    	String password=pro.getProperty("password");
    	String from=pro.getProperty("from");
    	String host=pro.getProperty("host");
    	String subject=pro.getProperty("subject");
    	String to=user.getEmail();
    	String content=pro.getProperty("content");
    	content=MessageFormat.format(content,user.getCode());
    	Session session=MailUtils.createSession(host, username, password);
    	Mail mail=new Mail(from, to, subject, content);
    	try {
			MailUtils.send(session, mail);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
    	request.setAttribute("msg","赶快到邮箱里面激活吧！！！");
		return "f:/jsps/msg.jsp";
	}
 public String login (HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException {
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    User user=new User();
	    try {
			user=userservice.login(username,password);
		} catch (Exception e) {
			
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("formpassword", password);
			request.setAttribute("formusername", username);
			
			return "f:/jsps/user/login.jsp";
		}
	    /*
	     * 对于session的使用
	     */
	   request.getSession().setAttribute("User_session",user);
	 
	 
	 return "f:/index.jsp";

 }
 public String exit(HttpServletRequest request, HttpServletResponse response) 
	    	throws ServletException, IOException {
	 request.getSession().invalidate();

	 return "f:/index.jsp";
 }
 
 
 
 
 
 
}
