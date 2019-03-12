package ActionForm;

public class bankActionForm  {
	
	private String userName;
	private String userPassword;
	private String name;
	private double money;
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public double getMoney() {
		return money;
	}
	public String getName() {
		return name;
	}
}
