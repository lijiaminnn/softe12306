package TicketBuy;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	//������ݿ�����
	public static Connection getConnection() {
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");    //����MYSQL JDBC�������� 
    		con = DriverManager.getConnection(
    		          "jdbc:mysql://localhost:3306/ticket?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");
    		           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
    	}
    	catch( Exception e ){
    		System.out.printf( "���ݿ�����ʧ��\n" );
    	}
		
		return con;
	}

}
