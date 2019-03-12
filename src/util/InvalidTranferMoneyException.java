package util;
/*
 * 当转账金额为负的时候抛出异常
 */
public class InvalidTranferMoneyException extends ArithmeticException{
	
	public InvalidTranferMoneyException() { //无参的构造方法
		super();
	}
	
	public InvalidTranferMoneyException(String msg) { //有参的构造方法
		super(msg);
	}
	
	public String toString() {
		return "转账金额不能为负！";
	}
}
