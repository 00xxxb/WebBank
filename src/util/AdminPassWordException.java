package util;

public class AdminPassWordException extends RuntimeException {
	
	public AdminPassWordException(String mesg) {
		super(mesg);
	}
	public String toString() {
		return "管理员密码错误";
	}
}
