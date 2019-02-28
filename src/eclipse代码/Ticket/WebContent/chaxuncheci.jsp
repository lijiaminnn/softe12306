<%@page import="java.util.List"%>
<%@page import="TicketBuy.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@page import="TicketBuy.TicketInfo"%>
<%@page import="TicketBuy.Bean.TicketBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 读取数据
request.setCharacterEncoding("UTF-8");
String StartStation = request.getParameter("StartStation");
String ArriveStation = request.getParameter("ArriveStation");
String date = request.getParameter("date");
TicketBean bean = new TicketBean();
//Connection conn = DBConn.getConnection();
List<TicketInfo> data = new ArrayList<TicketInfo>();
data = bean.getResult(StartStation, ArriveStation, date);
System.out.println("json");
System.out.println("]");
//封装成JSON
out.println("[");
Iterator< TicketInfo > iter = data.iterator();
while( iter.hasNext() ){
	TicketInfo info = iter.next();
    out.println("{");
    out.println("\"TrainCode\":\"" + info.getTrainCode() + "\",");
    out.println("\"StartStation\":\"" + info.getStartStation() + "\","); 
    out.println("\"ArriveStation\":\"" + info.getArriveStation() + "\",");
    out.println("\"StartTime\":\"" + info.getStartTime() + "\",");
    out.println("\"ArriveTime\":\"" + info.getArriveTime() + "\",");
    out.println("\"UseTime\":\"" + info.getUseTime() + "\",");
    out.println("\"TicketNum\":\"" + info.getTicketNum() + "\",");
    out.println("\"TicketPrice\":\"" + info.getTicketPrice() + "\",");
    out.println("\"date\":\"" + info.getDate()+"\"");
    out.println("}");
    if( iter.hasNext() ){
		out.print(",");
	}

	/* String str = String.format("%s--%s--%s--%s--%s--%s--%d--%.1f--%s",
			info.getTrainCode(), info.getStartStation(), info.getArriveStation(), info.getStartTime(),info.getArriveTime(),
			info.getUseTime(),info.getTicketNum(),info.getTicketPrice(),info.getDate()); */
	
}
out.println("]");
%>
