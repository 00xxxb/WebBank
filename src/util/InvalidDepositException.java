package util;
/*
 * 自定义一个异常，存款为负数的时候抛出异常
 */

public class InvalidDepositException  extends ArithmeticException {
    
	 public InvalidDepositException() { //默认不带参数的构造方法
		super();
	}
	
	public InvalidDepositException(String msg) { //带参数的构造方法，用于传递详细的异常信息
		super(msg);
	}
	
	public String toString() {
		return "输入存款金额不能为负！";
	}
}

