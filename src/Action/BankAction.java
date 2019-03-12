package Action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ActionForm.bankActionForm;
import manager.ManagerImpl;
import manager.MangerInterface;

@Controller
public class BankAction{
	@Resource(name="ManagerImpl")
	private MangerInterface manager;
	
	public void setManager(MangerInterface manager) {
		this.manager = manager;
	}

	/**
	 * 查询
	 */
	@RequestMapping("/bank_inquiry.do")
	public String inquiry(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		int id = (int)session.getAttribute("userid");
		double money = manager.inquiry(id);
		session.setAttribute("Inquire", money);
		return "/WEB-INF/success";
		
	}
	
	/**
	 * 取款
	 */
	@RequestMapping("/bank_withdrawals.do")
	public String withdrawals(bankActionForm form,HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
		int id = (int)session.getAttribute("userid");
		double money = form.getMoney();
		boolean flag = manager.userWithdrawals(id,money);
		if(flag) {
			double money1 = manager.inquiry(id);
			session.setAttribute("Inquire", money1);  //每次都及时的更新钱
			return "/WEB-INF/success";
		}
		return null;
	}
	
	/**
	 * 存款方法
	 */
	@RequestMapping("/bank_deposit.do")
	public String deposit(bankActionForm form,HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		int id = (int)session.getAttribute("userid");
		double money = form.getMoney();
		boolean flag = manager.userDeposit(id,money);
		if(flag) {
			double money1 = manager.inquiry(id);
			session.setAttribute("Inquire", money1);
			return "/WEB-INF/success";
		}
		return null;
	}
	
	/**
	 * 转账
	 */
	@RequestMapping("/bank_transfer.do")
	public String transfer(bankActionForm form,HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		int id = (int)session.getAttribute("userid");
		String name = form.getName();
		double money = form.getMoney();
		boolean flag = manager.userTransfer(id,money,name);
		
		if(flag) {
			double money1 = manager.inquiry(id);
			session.setAttribute("Inquire", money1);
			return "/WEB-INF/success";
		}
		return null;
	}
	
	
	/**
	 * 退出
	 */
	@RequestMapping("/bank_exitSystem.do")
	public String exitSystem(HttpServletRequest req,HttpServletResponse resp)throws Exception {
		 HttpSession session = req.getSession();
		 session.invalidate();  //关闭session
		 resp.sendRedirect("/WebBankDemo_SSM/login.jsp");
		return null;
	}
}
