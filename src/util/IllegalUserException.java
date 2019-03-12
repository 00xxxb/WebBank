package util;

public class IllegalUserException extends RuntimeException {
	
	public IllegalUserException() {
		super();
	}
	public IllegalUserException(String mesg) {
		super(mesg);
	}
	public String toString() {
		return "你已被冻结";
	}
	
}
