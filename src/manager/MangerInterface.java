package manager;

import java.util.List;

import util.NameNotFoundException;
import util.UseralreadyexistsExcption;
import util.WrongPasswordException;

public interface MangerInterface {
	
	//接口声明查询方法
	  double inquiry(int id) ;
	
	//接口声明取款方法
	  boolean userWithdrawals(int id,double _money);
	 
	 //接口声明存款方法
	  boolean userDeposit (int id,double _money) ;
	 
	  //转账方法
	  boolean userTransfer(int id,double money,String name);
	 
	 //接口声明退出方法
	  void exitSystem();
	  
	  //用户登录方法
	  public int login(String userName, String passWord)throws NameNotFoundException ,WrongPasswordException;
      
	  //注册方法
	  public boolean Register1(String name, String password) throws UseralreadyexistsExcption ;
	  
	  //查询最大的消费数
	  public int getTotalRecord(int id);
	  
	  //hql分页查询得到对应的记录
	  public List getRecord(int id, int frist,int show);
	  
	  //判断邮箱是否被注册
	  public boolean selectMail(String email);
	  
	  //修改邮箱
	  public void setEmail(String email);
	  
	  //获取管理员权限问题
	  public List getPermission();
	  
	  //冻结用户
	  public void freeze(int id);
	  
	  //解除冻结
	  public void release(int id);
		
}

