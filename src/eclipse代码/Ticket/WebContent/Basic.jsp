<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
		<link rel="stylesheet" href="css/page.css" />
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/index.js" ></script>
</head>
<body>
<div class="left">
			<div class="bigTitle">火车票后台管理系统</div>
			<div class="lines">
				<div onclick="pageClick(this)" class="active" id="usermanage"><img src="img/icon-1.png" />用户管理</div>
				<div onclick="pageClick(this)" id="ticketmanage"><img src="img/icon-2.png" />火车票管理</div>
				<div onclick="pageClick(this)" id="dingdanmanage"><img src="img/icon-3.png" />订单信息管理</div>
				<div onclick="pageClick(this)" id="addmanege"><img src="img/icon-4.png" />车次添加管理</div>
				<div onclick="pageClick(this)" id="deletemanege"><img src="img/icon-5.png" />车次删除管理</div>
			</div>
</div>
<div class="top">
			<div class="leftTiyle" id="flTitle">用户管理</div>
</div>
<div class="content"></div>
		
<div style="text-align:center;"></div>
</body>
</html>