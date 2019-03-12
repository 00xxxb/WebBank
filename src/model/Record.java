package model;

import java.sql.Timestamp;

public class Record {
	private int id;
	private String mes;
	private double money;
	private User user;
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	private Timestamp time;
	
	public User getUser() {
		return user;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public void setUser(User user) {
	    this.user = user;	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	 
}
