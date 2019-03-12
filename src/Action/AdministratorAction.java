package Action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ActionForm.bankActionForm;
import manager.MangerInterface;
import util.AdminNameException;
import util.AdminPassWordException;

@Controller
public class AdministratorAction {
	
	 @Resource(name="ManagerImpl")
	   private MangerInterface manager;
		
		public void setManager(MangerInterface manager) {
			this.manager = manager;
		}
	
	/*
	 *管理员显示全部user信息 
	 */
	@RequestMapping("/administrator.do")
	public String ShowUser(bankActionForm form,HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		String name = form.getUserName();
		String passWord = form.getUserPassword();
		
		if(!name.equals("admin")) {
			throw  new AdminNameException("该管理员不存在");
			
		}else if(!passWord.equals("admin")) {
			throw new AdminPassWordException("管理员密码错误");
		}else {
			List list = manager.getPermission();
			
			session.setAttribute("list", list);
		}
		return "/WEB-INF/Permission";
	}
	
	//冻结
	@RequestMapping("/freeze.do")
	public String freezeUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int id = Integer.parseInt(req.getParameter("id"));
		manager.freeze(id);
		
		List list = manager.getPermission();
		session.setAttribute("list", list);
		return "/WEB-INF/Permission";
	}
	
	//解除冻结
	@RequestMapping("/release.do")
	public String releaseUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int id = Integer.parseInt(req.getParameter("id"));
		manager.release(id);
		
		List list = manager.getPermission();
		session.setAttribute("list", list);
		return "/WEB-INF/Permission";
	}
}
