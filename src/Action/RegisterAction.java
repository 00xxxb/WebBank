package Action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ActionForm.RegisterActionForm;
import manager.MangerInterface;

@Controller
public class RegisterAction  {
	@Resource(name="ManagerImpl")
	 private MangerInterface manager;
	 public void setManager(MangerInterface manager) {
			this.manager = manager;
		}

	/**
	 * 注册方法
	 */
	 @RequestMapping("/register.do")
	public String execute( RegisterActionForm form, HttpServletRequest req,HttpServletResponse resp) throws Exception {

		String userName = form.getUserName();
		String passWord = form.getUserPassword();
		String mail = form.getEmail();
		manager.setEmail(mail);
		
		boolean flag = manager.Register1(userName, passWord);

		if (flag) {
			return "/RegisterSuccess";
		} else {
			return "/registerError";
		}
	}

}
