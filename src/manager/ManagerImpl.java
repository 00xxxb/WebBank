package manager;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import Mapper.MyMethodMapper;
import dao.BankDaoInterface;
import model.Record;
import model.User;
import util.AccountOverDrawnException;
import util.InvalidDepositException;
import util.InvalidTranferMoneyException;
import util.InvalidWithdrawalsException;
import util.NameNotFoundException;
import util.SqlNotFoundException;
import util.TranfeErrException;
import util.TransferOverMoneyException;
import util.UseralreadyexistsExcption;
import util.WrongPasswordException;


/*
 * 实现对模型层money的查询，存取
 * 
 * 实现业务层单例
 */
public class ManagerImpl  implements MangerInterface {
    
    BankDaoInterface propertiesdao;
    String email;
    MyMethodMapper myMethodMapper;
    
    public void setEmail(String email) {
    	this.email = email;
    }
    public String getEmail() {
    	return email;
    }
    public void setPropertiesdao(BankDaoInterface propertiesdao) {
    	this.propertiesdao = propertiesdao;
    }
     public void setMyMethodMapper(MyMethodMapper myMethodMapper) {
		this.myMethodMapper = myMethodMapper;
	}
	/*
	  * 注册方法 
	  * 必须生成properties和在数据库中插入成功才能注册成功
	  */
    public boolean Register1(String name, String password) throws UseralreadyexistsExcption {
    	
    	Integer id = myMethodMapper.selectUserId(name);
    	if(id != null) { //数据库判断用户是否存在
    		throw new UseralreadyexistsExcption();
    	}else {
    		User user = new User();
    		user.setName(name);
    		user.setEmail(this.getEmail());
    		user.setMoney(0);
    		user.setStatus(true);
    		myMethodMapper.addUser(user);
    	}
    	//这个因为数据之前已经判断了 所以 就是为了提交存入文件中
    	return this.propertiesdao.register(name, password);  
    	
    }
	/*
	  * 登录方法
	  * 登录用的是文件验证
	  */
    public int login(String name, String password) throws NameNotFoundException ,WrongPasswordException {
    	User user = new User();
    	Integer id = myMethodMapper.selectUserId(name);
    	if(id==null) {
    		throw new NameNotFoundException();
    	}
    	if (propertiesdao.login(name, password)) {
            user.setName(name);//登录成功之后对user属性赋值
            user.setPassword(name);
            return id;
        } else {
        	return -1;
         }
    }
     /*
	  * 查询方法
	  */
    public double inquiry(int id) {
    	User user = myMethodMapper.selectUser(id);
    	return user.getMoney();
    }
     /*
	  * 取款方法
	  */
    public boolean userWithdrawals(int id,double _money) throws SqlNotFoundException,
    	AccountOverDrawnException { //不处理AccountOverDrawnException异常
    	
    	User user = myMethodMapper.selectUser(id);
    	double money = user.getMoney();
    	if(_money < 0) {
    		throw new InvalidWithdrawalsException("存款金额不能为负");//如果取款金额为负，抛出异常
    	}else if(_money > money) {
    		throw new AccountOverDrawnException("取款超出余额!");
    	}else {
    		double money1 = money-_money;
    		myMethodMapper.updateMoney(id, money1);
    	}
    	return true;
    }
     /*
	  * 存款方法
	  */
    ////不处理InvalidDepositException异常
    public boolean userDeposit(int id,double _money) throws SqlNotFoundException {
     
        User user = myMethodMapper.selectUser(id);
        double money = user.getMoney();
        if(_money < 0) {
        	throw new InvalidDepositException("存款金额不能为负！"); //如果存款金额为负，抛出异常
        }else {
        	double money1 = money+_money;
        	myMethodMapper.updateMoney(id, money1);
        }
        return true;
    }
    /*
	  * 转账功能
	  */
    public boolean userTransfer(int id,double money,String name) throws TransferOverMoneyException, 
    	SqlNotFoundException,TranfeErrException {
    	
    	
    	//自己的钱减少
    	User user1 = myMethodMapper.selectUser(id);
    	String myname = user1.getName();
    	if(name.equals(myname)) {
    		throw new TranfeErrException("不能转账给自己");
    	}
    	
    	double myMoney = user1.getMoney();
    	if(money<0) {
    		throw new InvalidTranferMoneyException(); // 转账金额不能为负
    	}else if(myMoney < money) {
    		throw new TransferOverMoneyException();  //卡上余额不足
    	}else {
    		myMoney = myMoney - money;
    		myMethodMapper.updateMoney(id, myMoney);
    	}
    	//对方的钱的增加，先获得对方的id;
    	Integer otherId = myMethodMapper.selectUserId(name);
    	if(otherId == null) {
    		throw new SqlNotFoundException("对方用户不存在");
    	}else {
    		User user2 = myMethodMapper.selectUser(otherId);  //查出转账方的对象
    		double otherMoney = user2.getMoney();
    		otherMoney = otherMoney + money;
    		myMethodMapper.updateMoney(otherId, otherMoney);
    	}
    	return true;
    	
    }
    
    /*
     * 查询最大的消费记录数
     */
    public int getTotalRecord(int id) {
    	
    	return myMethodMapper.getTotalRecord(id);
    }
    /*
     * hql分页查询得到对应的记录
     */
    public List getRecord(int id,int frist,int show) {
    	/**
    	 * @frist 起始页
    	 * @show 分页时 每页显示的页数
    	 * 看配置看配置
    	 */
    	
    	return myMethodMapper.getRecord(id, frist, show);
    }
    /*
     *管理员页面获取用户信息 
     */
    public List getPermission() {
    	return myMethodMapper.getPermission();
    }
    
    /*
	 *判断邮箱是否存在数据库中 
	 */
	public boolean selectMail(String email) { 
		List list = myMethodMapper.getMail(email);
		if(!list.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * 冻结用户
	 */
	public void freeze(int id) {
		myMethodMapper.freeze(id);
	}
	/*
	 * 解除冻结
	 */
	public void release(int id) {
		myMethodMapper.release(id);
	}
	
      /*
	  *退出方法 
	  */
    public void exitSystem() {
    	    	
    }
}

