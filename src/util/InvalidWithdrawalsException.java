package util;

/*
 * 自定义一个异常，取款为负的时候抛出异常
 */

public class  InvalidWithdrawalsException extends ArithmeticException {
	
	public InvalidWithdrawalsException() { //无参的构造方法
		
	}
	
	public InvalidWithdrawalsException(String msg) {
		super(msg);
	}
	
	public String toString() {
		return "输入的存款金额不能为负！";
	}
}
