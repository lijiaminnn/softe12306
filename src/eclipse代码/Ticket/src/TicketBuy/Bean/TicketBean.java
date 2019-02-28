package TicketBuy.Bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import TicketBuy.DBConn;
import TicketBuy.TicketInfo;

public class TicketBean {
	/**
     *获取数据库中TicketInfo相关的所有信息
     */
	public List<TicketInfo>getAll(){
		List<TicketInfo> data=new ArrayList<TicketInfo>();
		Connection conn=DBConn.getConnection();
		try {
			String sql = "select TrainCode,StartStation, ArriveStation, "
					+ "StartTime, ArriveTime, "
					+ " UseTime, TicketNum,TicketPrice,date"
					+ " from  checi";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			/*java.sql.PreparedStatement st = 
					conn.prepareStatement( sql );
		    ResultSet rs = st.executeQuery( );*/
			System.out.println( "查询结果为：" );
			
			while( rs.next() ){
				
				String TrainCode = rs.getString("TrainCode");
			    String StartStation = rs.getString("StartStation");
				String ArriveStation = rs.getString("ArriveStation");
				String StartTime = rs.getString("StartTime");
				String ArriveTime = rs.getString("ArriveTime");
				String UseTime = rs.getString("UseTime");
				int TicketNum = rs.getInt("TicketNum");
				double TicketPrice = rs.getDouble("TicketPrice");
				String date = rs.getString("date");
				
				TicketInfo info = new TicketInfo();
				info.setTrainCode(TrainCode);
				info.setStartStation(StartStation);
				info.setArriveStation(ArriveStation);
				info.setStartTime(StartTime);
				info.setArriveTime(ArriveTime);
				info.setUseTime(UseTime);
				info.setTicketNum(TicketNum);
				info.setTicketPrice(TicketPrice);
				info.setDate(date);
				data.add( info );
				
				String str = String.format( 
						"(%s,%s, %s, %s,%s,%s,%d,%.1f,%s)\n", 
						TrainCode,StartStation, ArriveStation, StartTime, ArriveTime,UseTime,TicketNum,TicketPrice,date);
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
         *获取查询结果由起始站、终点站、和时间决定的数据库中checi表的信息
         *@param StartStation 起始站 参数1
         *@param ArriveStation 终点站 参数2
         *@param date 出发日期 参数3
         *return data 数据库选择的信息
         */
	public ArrayList<TicketInfo>getResult(String StartStation,String ArriveStation,String date){
		ArrayList<TicketInfo> data=new ArrayList<TicketInfo>();
		Connection conn=DBConn.getConnection();
		try {
			String sql = "select TrainCode,StartStation, ArriveStation, "
					+ "StartTime, ArriveTime, "
					+ " UseTime, TicketNum,TicketPrice,date"
					+ " from  checi"
					+ " where StartStation like ?"
					+ " and ArriveStation like ?"
					+ " and date like ?";
			/*Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);*/
			java.sql.PreparedStatement st = 
					conn.prepareStatement( sql );
			st.setString(1, StartStation);
			st.setString(2, ArriveStation);
			st.setString(3, date);
		    ResultSet rs = st.executeQuery();
			System.out.println( "查询结果为：" );
			
			while( rs.next() ){
				
				String TrainCode = rs.getString("TrainCode");
				String StartTime = rs.getString("StartTime");
				String ArriveTime = rs.getString("ArriveTime");
				String UseTime = rs.getString("UseTime");
				int TicketNum = rs.getInt("TicketNum");
				double TicketPrice = rs.getDouble("TicketPrice");
				
				TicketInfo info = new TicketInfo();
				info.setTrainCode(TrainCode);
				info.setStartStation(StartStation);
				info.setArriveStation(ArriveStation);
				info.setStartTime(StartTime);
				info.setArriveTime(ArriveTime);
				info.setUseTime(UseTime);
				info.setTicketNum(TicketNum);
				info.setTicketPrice(TicketPrice);
				info.setDate(date);
				data.add( info );
				
				String str = String.format( 
						"(%s,%s, %s, %s,%s,%s,%d,%.1f,%s)\n", 
						TrainCode,StartStation, ArriveStation, StartTime, ArriveTime,UseTime,TicketNum,TicketPrice,date);
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
