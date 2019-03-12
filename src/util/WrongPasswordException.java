package util;

public class WrongPasswordException extends RuntimeException {
	public WrongPasswordException() {  //无参构造方法
		super();
	}
	public WrongPasswordException(String name) {
		super(name);
	}
	public String toString() {
		return "密码错误";
	}
}
