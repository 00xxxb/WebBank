package Action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ActionForm.RegisterActionForm;
import manager.ManagerImpl;
import manager.MangerInterface;

@Controller
public class MailAction {
	
	@Resource(name="ManagerImpl")
	 private MangerInterface manager;
	 public void setManager(MangerInterface manager) {
			this.manager = manager;
		}
	 @RequestMapping("/CheckEmail.do")
	public String execute(RegisterActionForm form,HttpServletRequest request, HttpServletResponse response)
	        throws Exception {
		String email = form.getEmail();
		PrintWriter out = response.getWriter();
		if(manager.selectMail(email)) {
			out.write("true");
		}else {
			out.write("false");
		}
		
		return null;
	}
}
