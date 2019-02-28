<%@page import="TicketBuy.UserInfo"%>
<%@page import="TicketBuy.Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String realname = request.getParameter("realname");
	String telNumber = request.getParameter("telNumber");
	String email = request.getParameter("email");
	String IDCard = request.getParameter("IDCard");
	//执行
	UserBean bean = new UserBean();
	UserInfo info = new UserInfo(username,password,realname,telNumber,email,IDCard);
	boolean result = bean.add(info);
	if(result){
		out.println("1");//注册成功
	}
	else{
		out.println("0");//注册失败
	}
%>
