<%@page import="TicketBuy.TicketBuyInfo"%>
<%@page import="TicketBuy.Bean.TicketBuyBean"%>
<%@page import="java.util.List"%>
<%@page import="TicketBuy.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 读取数据
TicketBuyBean bean = new TicketBuyBean();
List<TicketBuyInfo> data = new ArrayList<TicketBuyInfo>();
data = bean.getAll();
System.out.println("json");
System.out.println("]");
//封装成JSON
out.println("[");
Iterator< TicketBuyInfo > iter = data.iterator();
while( iter.hasNext() ){
	TicketBuyInfo info = iter.next();
	out.println("{");
    out.println("\"id\":\""+info.getId()+"\",");
    out.println("\"traincode\":\"" + info.getTraincode() + "\",");
    out.println("\"startstation\":\"" + info.getStartstation() + "\","); 
    out.println("\"aarrivestation\":\"" + info.getArrivestation() + "\",");
    out.println("\"starttime\":\"" + info.getStarttime() + "\",");
    out.println("\"arrivetime\":\"" + info.getArrivetime() + "\",");
    out.println("\"username\":\"" + info.getUsername() + "\",");
    out.println("\"idcard\":\""+info.getIdcard()+"\",");
    out.println("\"ticketprice\":\"" + info.getTicketprice() +"\",");
    out.println("\"Date\":\"" + info.getDate() + "\",");
    out.println("}");
    if( iter.hasNext() ){
		out.print(",");
	}	
}
out.println("]");
%>
