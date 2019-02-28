package TicketBuy;

public class TicketInfo {
	
	private String TrainCode;//���α���
	private String StartStation;//ʼ��վ
	private String ArriveStation;//����վ
	private String StartTime;//����ʱ��
	private String ArriveTime;//����ʱ��
	private String UseTime;//��ʱ
	private int TicketNum;//��Ʊ
	private double TicketPrice;//Ʊ��
	private String date;//����
	
	public TicketInfo() {
		super();
	}

	public TicketInfo(String trainCode, String startStation, String arriveStation, String startTime, String arriveTime,
			String useTime, int ticketNum, double ticketPrice, String date) {
		super();
		TrainCode = trainCode;
		StartStation = startStation;
		ArriveStation = arriveStation;
		StartTime = startTime;
		ArriveTime = arriveTime;
		UseTime = useTime;
		TicketNum = ticketNum;
		TicketPrice = ticketPrice;
		this.date = date;
	}

	public String getTrainCode() {
		return TrainCode;
	}

	public void setTrainCode(String trainCode) {
		TrainCode = trainCode;
	}

	public String getStartStation() {
		return StartStation;
	}

	public void setStartStation(String startStation) {
		StartStation = startStation;
	}

	public String getArriveStation() {
		return ArriveStation;
	}

	public void setArriveStation(String arriveStation) {
		ArriveStation = arriveStation;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getArriveTime() {
		return ArriveTime;
	}

	public void setArriveTime(String arriveTime) {
		ArriveTime = arriveTime;
	}

	public String getUseTime() {
		return UseTime;
	}

	public void setUseTime(String useTime) {
		UseTime = useTime;
	}

	public int getTicketNum() {
		return TicketNum;
	}

	public void setTicketNum(int ticketNum) {
		TicketNum = ticketNum;
	}

	public double getTicketPrice() {
		return TicketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		TicketPrice = ticketPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
