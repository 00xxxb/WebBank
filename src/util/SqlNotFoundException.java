package util;

public class SqlNotFoundException extends RuntimeException {
	
	public SqlNotFoundException() {  //无参构造方法
		super();
	}
	public SqlNotFoundException(String name) {
		super(name);
	}
	public String toString() {
		return "用户不存在";
	}

}
