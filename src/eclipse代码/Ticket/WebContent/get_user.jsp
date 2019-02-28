<%@page import="TicketBuy.UserInfo"%>
<%@page import="TicketBuy.Bean.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="TicketBuy.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 读取数据
UserBean bean = new UserBean();
List<UserInfo> data = new ArrayList<UserInfo>();
data = bean.getAll();
System.out.println("json");
System.out.println("]");
//封装成JSON
out.println("[");
Iterator< UserInfo > iter = data.iterator();
while( iter.hasNext() ){
	UserInfo info = iter.next();
	out.println("{");
    out.println("\"username\":\"" + info.getUsername() + "\",");
    out.println("\"password\":\"" + info.getPassword() + "\","); 
    out.println("\"realname\":\"" + info.getRealname() + "\",");
    out.println("\"telNumber\":\"" + info.getTelNumber() + "\",");
    out.println("\"email\":\"" + info.getEmail() + "\",");
    out.println("\"IDCard\":\"" + info.getIDCard() + "\",");
    out.println("}");
    if( iter.hasNext() ){
		out.print(",");
	}	
	
}
out.println("]");
%>
