package manager;

import java.sql.Timestamp;

import javax.swing.JPopupMenu;

import org.aspectj.lang.JoinPoint;

import Mapper.MyMethodMapper;
import model.Record;
import model.User;
import util.IllegalUserException;

public class MyAspect{
	 MyMethodMapper myMethodMapper;
	 
	 public void setMyMethodMapper(MyMethodMapper myMethodMapper) {
			this.myMethodMapper = myMethodMapper;
		}
	
	public void check(int id) throws IllegalUserException{
		User user = myMethodMapper.selectUser(id);
		if(user.isStatus()) {
			System.out.println("<----------验证通过------->");
		}else{
			throw new IllegalUserException("您的账号已被冻结");
		}
	}
	
	public void saveRecord(JoinPoint jp,int id) {
		Record record = new Record();
		User user = myMethodMapper.selectUser(id);
		String mothod = jp.getSignature().getName();
		
		String mes =null;
		
		switch (mothod) {
		case "userWithdrawals":
		       mes= "取款";
			   break;
		case "userDeposit":
			   mes="存款";
			   break;
		case "userTransfer":
			//jp.getArgs()[2] 获得对应方法的第三个参数
			   mes="转账→"+jp.getArgs()[2];
			   break;
		}
		//消费记录
    	record.setMes(mes);
    	record.setMoney((double)(jp.getArgs()[1]));
    	record.setUser(user);
    	record.setTime(new Timestamp(System.currentTimeMillis()));
    	myMethodMapper.addRecord(record);
	}
	
}
