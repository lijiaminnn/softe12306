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
			System.out.println( "��ѯ���Ϊ��" );
			
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
			System.out.println("���ݿ��ѯʧ��\n"+e.getMessage());
			// TODO: handle exception
		}finally {
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "�ر�����ʧ��\n" + e.getMessage()  );
				}// try
			}// if
		}//finally
		return data;
	}	
	/**
	 * ����
	 * @param info
	 * @return
	 */
	public boolean add( UserInfo info ){
		
		/** ��ȡ����*/
		Connection conn = DBConn.getConnection();
		int count = -1;
		
		try{
			String sql = " insert user "
					+ "  (username,password,realname,telNumber,email,IDCard) "
					+ "  values(?, ?, ?, ?, ?, ?) ";
			PreparedStatement st = conn.prepareStatement(  sql );
			int i = 1;
			
			//  �û���
			st.setString( i, info.getUsername() );
			++i;
			//   ����
			st.setString(i, info.getPassword() );
			++i;
			//  ��ʵ��
			st.setString( i, info.getRealname()  );
			++i;
			//  �绰����
			st.setString(i, info.getTelNumber());
			++i;
			//��������
			st.setString(i, info.getEmail());
			++i;
			//���֤����
			st.setString(i, info.getIDCard());
			++i;
		
			
			System.out.printf("sql = %s\n", st.toString());
			
			count = st.executeUpdate(  );// ִ�����
			System.out.printf( "����%d����¼", count );
		}
		catch( SQLException e ){
			System.out.printf( "����ʧ��:" + e.getMessage() );
			return false;
		}
		finally{
			if( conn != null ){
				try{
					conn.close();
				}
				catch( SQLException e ){
					System.out.printf( "�ر�����ʧ��\n" + e.getMessage()  );
				}// try
			}// if
			
		}// finally
		
		return true;
	}
        /**
	 * ѡ��
	 * @param _name
         * @param _password
	 * @return ѡ������ѡ���������û���
	 */
	public String select(String _name,String _password) {
		String username = null;
		//��ȡ����
		Connection conn = DBConn.getConnection();
		try {
			String sql = "select username from user where username = ? and password = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			int i = 1;
			st.setString(i, _name);
			i++;
			st.setString(i, _password);
			ResultSet rs = st.executeQuery();//ִ�в�ѯ���
			while(rs.next()){
				username = rs.getString("username");
			}
		} catch (SQLException e) {
			System.out.println("����ʧ��"+e.getMessage());
			username = null;
			return username;
			// TODO: handle exception
		}finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.print("�ر�����ʧ��\n"+e.getMessage());
					// TODO: handle exception
				}
			}
		}
		return username;
	}

}
