package Mapper;

import java.sql.Timestamp;
import java.util.List;

import model.Record;
import model.User;

public interface MyMethodMapper {
	
	//注册用户
	public void addUser(User user);
	
	//登录的时候判断是否存在这个用户，返回id
	public Integer selectUserId(String name);
	
	//查询用户
	public User selectUser(int id);
	
	//修改金额
	public void updateMoney(int id,double money);
	
	//查询最大的消费数
	public int getTotalRecord(int id);
	
	//分页查询得到记录
	public List getRecord(int id,int frist,int show);
	
	//判断邮箱是否存在数据库中
	public List getMail(String email);
	
	//插入日志
	public void addRecord(Record record);
	
	//获取用户权限问题
	public List getPermission();
	
	//冻结用户
	public void freeze(int id);
	
	//解除冻结
	public void release(int id);
}
