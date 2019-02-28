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
     *��ȡ���ݿ���TicketInfo��ص�������Ϣ
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
			System.out.println( "��ѯ���Ϊ��" );
			
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
         *��ȡ��ѯ�������ʼվ���յ�վ����ʱ����������ݿ���checi�����Ϣ
         *@param StartStation ��ʼվ ����1
         *@param ArriveStation �յ�վ ����2
         *@param date �������� ����3
         *return data ���ݿ�ѡ�����Ϣ
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
			System.out.println( "��ѯ���Ϊ��" );
			
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

}
