package Action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ActionForm.bankActionForm;
import manager.MangerInterface;

@Controller
public class LoginAction  {
	@Resource(name="ManagerImpl")
	private MangerInterface manager;
	
	public void setManager(MangerInterface manager) {
		this.manager = manager;
	}
	
	/**
	 * 首页跳转到注册登录页面
	 */
	@RequestMapping("/login.do")
	public String Jump() {
		return "/login";
	}
	
	
	/**
	 * 登录
	 */
	@RequestMapping("/bank_login.do")
	public String login(bankActionForm actionform,HttpServletRequest req) throws Exception {
		String userName = actionform.getUserName();
		String passWord = actionform.getUserPassword();
		HttpSession session = req.getSession();  //用来存放用户id解决多线程业务层单例问题
		int id = manager.login(userName, passWord);
		if(id !=-1) {
			session.setAttribute("userid", id);
			return "/WEB-INF/success";
		}
		return null;
	}
}
