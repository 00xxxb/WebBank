package model;

/**
 * @author 符兴斌
 * @version 1.0.0
 */

/*
 * 用于封装用户的用户名和密码
 * 一个user对应一个钱
 */

public class User {
	 
	 private int id;
	 private String name ;
	 private String password ;
	 private String email;
	 private double  money;
	 private boolean status;
	 
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
	 public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	 public void setName(String name) { //改变用户姓名
		 this.name = name;
	 }
	 public String getName() {  // 得到用户姓名
		 return name;
	 }
	 public void setPassword(String password) { //改变用户登录密码
		 this.password = password;
	 } 
     public String getPassword() {//得到用户密码
		 return password;
	 }
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
   
}
