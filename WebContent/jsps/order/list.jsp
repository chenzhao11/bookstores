<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px gray;
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
<h1>我的订单</h1>

<table border="1" width="100%" cellspacing="0" background="black">


<c:forEach items="${orderlist }" var="i">
	<tr bgcolor="gray" bordercolor="gray">
		<td colspan="6">
			订单编号　${i.getOid() }成交时间：：<fmt:formatDate pattern="yyyy-mm-dd hh-mm-ss"
			value="${i.getOrdertime() }"/>　金额：<font color="red"><b>${i.getTotal() }</b></font>　
      			<a href="<c:url value='Ordersservlet?method=pay&oid=${i.getOid() }'/>">付款</a>
      			等待发货
      			<a href="<c:url value='Ordersservlet?method=confir&oid=${i.getOid() }'/>">确认收货</a>
      			订单结束
      			
      			<%/*
      		便与调试先不这样	
      			
      			<c:choose>
					<c:when test="${i.getState()==0}"><a href="<c:url value='Ordersservlet?method=pay&oid=${i.getOid() }'/>">付款</a>
					</c:when>
					   <c:when test="${i.getState() eq 1}"> 等待发货</c:when>               
					<c:when test="${i.getState() eq 2}"><a href="javascript:alert('已确认收货！');">确认收货</a></c:when>  
					<c:when test="${i.getState() eq 3}">订单结束</c:when>  
				</c:choose>
				*/%>
		</td>
	</tr>
	<%/*这里面的getBook得到的不是直接的book类而是orderitem类里面直接就有   subtotal  以及count  还自己加了一个Book类*/ %>
    <c:forEach items="${i.getBook() }" var="j">
	<tr bordercolor="gray" align="center">
		<td width="15%">
			<div><img src="<c:url value='/${j.getBook().getImage() }'/>" height="75"/></div>
		</td>
		<td>书名：${j.getBook().getBname() }</td>
		<td>单价：${j.getBook().getPrice() }</td>
		<td>作者：${j.getBook().getAuthor() }</td>
		<td>数量：${j.getCount() }</td>
		<td>小计：${j.getSubtotal() }元</td>
	</tr>
	</c:forEach>

</c:forEach>
</table>
  </body>
</html>
