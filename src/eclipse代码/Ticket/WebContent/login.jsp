<%@page import="TicketBuy.UserInfo"%>
<%@page import="TicketBuy.Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%
	request.setCharacterEncoding("UTF-8");
	//���ܲ���Android��
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	//ִ��
	UserBean bean = new UserBean();
	UserInfo info = new UserInfo(username,password,"","","","");
	String _username =  bean.select(username,password);//���ݿ��
	if(username.equals(_username)){
		out.println("1");//��¼�ɹ�����1
	}
	else{
		out.println("0");//��¼ʧ��
	}
%>