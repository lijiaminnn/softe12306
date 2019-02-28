package TicketBuy.Bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import TicketBuy.DBConn;
import TicketBuy.TicketBuyInfo;

public class TicketBuyBean {
	/**获取数据库中所有的dingdan表的信息*/
	public List<TicketBuyInfo>getAll(){
		List<TicketBuyInfo> data=new ArrayList<TicketBuyInfo>();
		Connection conn=DBConn.getConnection();
		try {
			String sql = "select * from  dingdan";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			/*java.sql.PreparedStatement st = 
					conn.prepareStatement( sql );
		    ResultSet rs = st.executeQuery( );*/
			System.out.println( "查询结果为：" );
			
			while( rs.next() ){
				int id = rs.getInt("id");
				String traincode = rs.getString("traincode");
			    String startstation = rs.getString("startstation");
				String arrivestation = rs.getString("arrivestation");
				String starttime = rs.getString("starttime");
				String arrivetime = rs.getString("arrivetime");
				String username = rs.getString("username");
				String idcard = rs.getString("idcard");
				double ticketprice = rs.getDouble("ticketprice");
				String Date = rs.getString("Date");
				
				TicketBuyInfo info = new TicketBuyInfo();
				info.setId(id);
				info.setTraincode(traincode);
				info.setStartstation(startstation);
				info.setArrivestation(arrivestation);
				info.setStarttime(starttime);
				info.setArrivetime(arrivetime);
				info.setUsername(username);
				info.setIdcard(idcard);
				info.setTicketprice(ticketprice);
				info.setDate(Date);
				data.add( info );
				
				String str = String.format( 
						"(%d,%s,%s, %s, %s,%s,%s,%s,%.1f,%s)\n", 
						id,traincode, startstation, arrivestation, starttime,arrivetime,username,idcard,ticketprice,Date);
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

}
