package util;

import java.io.IOException;

public class NameNotFoundException extends IOException{
	
	public NameNotFoundException() {  //无参构造方法
		super();
	}
	public NameNotFoundException(String name) {
		super(name);
	}
	public String toString() {
		return "用户不存在";
	}
}
