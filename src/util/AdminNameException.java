package util;

public class AdminNameException extends RuntimeException {
	public AdminNameException(String mesg) {
		super(mesg);
	}
	public String toString() {
		return "该管理员不存在";
	}
}
