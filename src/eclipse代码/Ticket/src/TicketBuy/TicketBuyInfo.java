package TicketBuy;

public class TicketBuyInfo {
	
	private int id;//��Ʊ���
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTraincode() {
		return traincode;
	}
	public void setTraincode(String traincode) {
		this.traincode = traincode;
	}
	public String getStartstation() {
		return startstation;
	}
	public void setStartstation(String startstation) {
		this.startstation = startstation;
	}
	public String getArrivestation() {
		return arrivestation;
	}
	public void setArrivestation(String arrivestation) {
		this.arrivestation = arrivestation;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getArrivetime() {
		return arrivetime;
	}
	public void setArrivetime(String arrivetime) {
		this.arrivetime = arrivetime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public double getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public TicketBuyInfo() {
		super();
	}
	private String traincode;//���α��
	private String startstation;//����վ
	private String arrivestation;//����վ
	private String starttime;//����ʱ��
	private String arrivetime;//����ʱ��
	private String username;//�û���
	private String idcard;//���֤����
	private double ticketprice;//Ʊ��
	private String Date;//����
	

}
