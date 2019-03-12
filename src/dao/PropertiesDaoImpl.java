package dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import util.InvalidDepositException;
import util.InvalidTranferMoneyException;
import util.MD5;
import util.NameNotFoundException;
import util.SqlNotFoundException;
import util.TransferOverMoneyException;
import util.UseralreadyexistsExcption;
import util.WrongPasswordException;
import model.User;

/**
 * 
 * @author 符兴斌
 * @version 5.0
 *
 *@userName  用户名
 *@password 用户登录密码
 * @money 用户余额
 */


public class PropertiesDaoImpl implements BankDaoInterface{
	
	MD5 md5 = new MD5();   //得到MD5加密的对象，给密码加上密文
    public Properties props;
	public PropertiesDaoImpl() { //私有构造方法
		
	}
  
    public void setProps(Properties props) {
		this.props = props;
	}
	/*
     * 注册说明，注册功能
     */
    public boolean register(String name,String password) throws UseralreadyexistsExcption{
    	
    	User userbean = new User();
    	userbean.setName(name);
    	props = new Properties();
    	//System.getProperty("rootPath")  这个是spring获取项目的真实路径的根路径(D:\tomcat\webapps\WebBank_SSH\)
    	File f = new File(System.getProperty("rootPath") + name + ".properties"); //通过传参得到文件注册的路径
    	String upPassword = md5.getMD5(password);
    	if(f.exists()) {
    		throw new UseralreadyexistsExcption("文件已经存在");
    	}
    	
    	try{
    		FileOutputStream out = new FileOutputStream(f); //在外存创建一个新的properties文件用来储存数据
    	   	props.setProperty("userName", name);  //设定各个属性的初始值
        	props.setProperty("password", upPassword);
		    props.store(out, "fxb"); //将此Properties表中的此属性列表（键和元素对）以适合使用load(Reader)方法的格式写入输出字符流
		    out.close();//关闭输出流
		   }
		catch(IOException e){
			return false;
		}
    	return true;
    }
    
    
    
    /*
     *用户登录方法 	
     */
   	
    public boolean login(String name,String password1) throws NameNotFoundException,WrongPasswordException {
    	User userbean = new User();
    	userbean.setName(name);
    	userbean.setPassword(password1);
    	props = new Properties();
    	//System.getProperty("rootPath")  这个是spring获取项目的真实路径的根路径(原来的path)
    	
    	File f = new File(System.getProperty("rootPath")+name+".properties");
    		if(!f.exists()) {   //判断文件是存在，就是用户名是否存在
    			throw new NameNotFoundException(name);
    		}
    		
    		try{
    		String upPassword2 = md5.getMD5(password1);
    		FileInputStream in = new FileInputStream(f);
    		props.load(in);
    		 if(props.getProperty("password").equals(upPassword2)) {  //如果密码正确，登录成功
	        		in.close();
	        		return true;
	    		}else {
	    			in.close();
	    			throw new WrongPasswordException();
	    		}
    	}catch(IOException e) {
    		e.printStackTrace();
    	return true;
    	}
    }
    
    /*     
     * 储存余额说明
     */
    public void saveMoney(String name,double money) throws InvalidDepositException{
    
    }
    
    /*
     * 获取余额说明
     */
    public String getBanlance(String name) {
    	
    	return null;
    }
    
    /*
     * 转账说明
     */
    public boolean transfer( String name2,double money) throws TransferOverMoneyException, SqlNotFoundException,InvalidTranferMoneyException{
    	
   
    	return true;
    }
	@Override
	public void exitSystem() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setEmail(String mail) {
		// TODO Auto-generated method stub
		
	}
    
}
