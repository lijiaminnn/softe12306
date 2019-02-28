package TicketBuy;

public class UserInfo {
	
	private String username;//用户名
	private String password;//密码
	private String realname;//真实名字
	private String telNumber;//电话号码
	private String email;//电子邮箱
	private String IDCard;//身份证号码
	
	public UserInfo() {
		super();
	}
	


	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password + ", realname=" + realname + ", telNumber="
				+ telNumber + ", email=" + email + ", IDCard=" + IDCard + "]";
	}



	public UserInfo(String username, String password, String realname, String telNumber, String email, String iDCard) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.telNumber = telNumber;
		this.email = email;
		IDCard = iDCard;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	
	

}
