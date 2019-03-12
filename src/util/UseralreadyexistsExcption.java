package util;

import java.io.IOException;

public class UseralreadyexistsExcption extends IOException {
	public UseralreadyexistsExcption() {  //无参构造方法
		super();
	}
	public UseralreadyexistsExcption(String name) {
		super(name);
	}
	public String toString() {
		return "用户已经存在";
	}
}
