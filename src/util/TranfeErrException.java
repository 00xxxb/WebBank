package util;

public class TranfeErrException extends RuntimeException {
	 public TranfeErrException () {
		 
	 }
	 public TranfeErrException (String mesg) {
		 super(mesg);
	 }
	 
	 public String toString() {
		 return "不能转账给自己啊";
	 }
}
