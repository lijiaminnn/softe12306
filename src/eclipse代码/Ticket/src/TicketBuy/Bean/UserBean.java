package TicketBuy.Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import TicketBuy.DBConn;
import TicketBuy.UserInfo;

public class UserBean {
	
	public List<UserInfo>getAll(){
		List<UserInfo> data=new ArrayList<UserInfo>();
		Connection conn=DBConn.getConnection();
		try {
			String sql = "select * from  user";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			/*java.sql.PreparedStatement st = 
					conn.prepareStatement( sql );
		    ResultSet rs = st.executeQuery( );*/
			System.out.println( "查询结果为：" );
			
			while( rs.next() ){
				String username = rs.getString("username");
			    String password = rs.getString("password");
				String realname = rs.getString("realname");
				String telNumber = rs.getString("telNumber");
				String email = rs.getString("email");
				String IDCard = rs.getString("IDCard");
				
				UserInfo info = new UserInfo();
				info.setUsername(username);
				info.setPassword(password);
				info.setRealname(realname);
				info.setTelNumber(telNumber);
				info.setEmail(email);
				info.setIDCard(IDCard);
				data.add( info );
				
				String str = String.format( 
						"(%s,%s, %s, %s,%s,%s)\n", 
						username, password, realname, telNumber,email,IDCard);
				System.out.printf( str );
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库查询失败\n"+e.getMessage());
			// TODO: handle exception
		}finally {
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "关闭连接失败\n" + e.getMessage()  );
				}// try
			}// if
		}//finally
		return data;
	}	
	/**
	 * 新增
	 * @param info
	 * @return
	 */
	public boolean add( UserInfo info ){
		
		/** 获取连接*/
		Connection conn = DBConn.getConnection();
		int count = -1;
		
		try{
			String sql = " insert user "
					+ "  (username,password,realname,telNumber,email,IDCard) "
					+ "  values(?, ?, ?, ?, ?, ?) ";
			PreparedStatement st = conn.prepareStatement(  sql );
			int i = 1;
			
			//  用户名
			st.setString( i, info.getUsername() );
			++i;
			//   密码
			st.setString(i, info.getPassword() );
			++i;
			//  真实名
			st.setString( i, info.getRealname()  );
			++i;
			//  电话号码
			st.setString(i, info.getTelNumber());
			++i;
			//电子邮箱
			st.setString(i, info.getEmail());
			++i;
			//身份证号码
			st.setString(i, info.getIDCard());
			++i;
		
			
			System.out.printf("sql = %s\n", st.toString());
			
			count = st.executeUpdate(  );// 执行语句
			System.out.printf( "新增%d条记录", count );
		}
		catch( SQLException e ){
			System.out.printf( "新增失败:" + e.getMessage() );
			return false;
		}
		finally{
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "关闭连接失败\n" + e.getMessage()  );
				}// try
			}// if
			
		}// finally
		
		return true;
	}
        /**
	 * 选择
	 * @param _name
         * @param _password
	 * @return 选择后符合选择条件的用户名
	 */
	public String select(String _name,String _password) {
		String username = null;
		//获取连接
		Connection conn = DBConn.getConnection();
		try {
			String sql = "select username from user where username = ? and password = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			int i = 1;
			st.setString(i, _name);
			i++;
			st.setString(i, _password);
			ResultSet rs = st.executeQuery();//执行查询语句
			while(rs.next()){
				username = rs.getString("username");
			}
		} catch (SQLException e) {
			System.out.println("查找失败"+e.getMessage());
			username = null;
			return username;
			// TODO: handle exception
		}finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.print("关闭连接失败\n"+e.getMessage());
					// TODO: handle exception
				}
			}
		}
		return username;
	}

}
