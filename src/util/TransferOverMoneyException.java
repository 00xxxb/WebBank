package util;
/*
 * 自定义一个转账金额大于卡上余额的时候的异常
 */
public class TransferOverMoneyException extends  ArithmeticException{
	
	public TransferOverMoneyException() { //无参的构造方法
		super();
	}
	
	public TransferOverMoneyException(String name) { //有参的构造方法
		super(name);
	}
	public String toString() {
		return "转账金额大于卡上余额";
	}
}
