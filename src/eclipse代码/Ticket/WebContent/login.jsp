<%@page import="TicketBuy.UserInfo"%>
<%@page import="TicketBuy.Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%
	request.setCharacterEncoding("UTF-8");
	//接受参数Android端
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	//执行
	UserBean bean = new UserBean();
	UserInfo info = new UserInfo(username,password,"","","","");
	String _username =  bean.select(username,password);//数据库端
	if(username.equals(_username)){
		out.println("1");//登录成功返回1
	}
	else{
		out.println("0");//登录失败
	}
%>