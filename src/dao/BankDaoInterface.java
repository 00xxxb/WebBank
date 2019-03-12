package dao;


import util.NameNotFoundException;
import util.SqlNotFoundException;
import util.TransferOverMoneyException;
import util.UseralreadyexistsExcption;
import util.WrongPasswordException;
import util.InvalidDepositException;

public interface BankDaoInterface {
  
	public boolean register(String name,String password)throws UseralreadyexistsExcption; //注册功能
	
	public boolean login(String name,String password1)throws NameNotFoundException,WrongPasswordException; //  用户登录
	
	public boolean transfer(String name2,double money)throws TransferOverMoneyException, SqlNotFoundException; //转账功能
	
	public void saveMoney(String name,double money)throws InvalidDepositException; //储存说明
	  
	public void exitSystem(); //退出
	 
	public void setEmail(String mail);
}
