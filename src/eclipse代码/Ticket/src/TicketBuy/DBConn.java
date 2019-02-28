package TicketBuy;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	//获得数据库连接
	public static Connection getConnection() {
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");    //加载MYSQL JDBC驱动程序 
    		con = DriverManager.getConnection(
    		          "jdbc:mysql://localhost:3306/ticket?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");
    		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
    	}
    	catch( Exception e ){
    		System.out.printf( "数据库连接失败\n" );
    	}
		
		return con;
	}

}
