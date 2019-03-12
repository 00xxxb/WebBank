package util;

/*
 * 自定义一个异常，取款超出余额时抛出异常
 */
public class AccountOverDrawnException extends ArithmeticException{
	public AccountOverDrawnException() { //默认不带参数的构造方法
		super();
	}
	
	public AccountOverDrawnException(String msg) { //带参数的构造方法，用于传递详细的异常信息
		super(msg);
	}
	
	public String toString() {
		return "取款金额大于所剩余额";
	}
}
