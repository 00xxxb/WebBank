package Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ActionForm.RegisterActionForm;
import util.JavaMail1;
import util.Util1;

@Controller
public class CodeAction {
	@RequestMapping("/CheckCode.do")
	public String execute(RegisterActionForm form,HttpServletRequest request, HttpServletResponse response)
			throws Exception { 
		String email = form.getEmail();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		JavaMail1 javaMail = new JavaMail1("760627631@qq.com","ienphhshfhilbejf","smtp.qq.com");
		Util1 util = new Util1();
		//发送主题
		String subject = "【银行注册】";
		
		String code = util.getRandomString(6);
		//发送内容
		String content = "验证码："+code+"。如非本人操作，请检查账户安全";
		session.setAttribute("yanzhengma", code);
//		System.out.println(code);
		try {
			javaMail.sendMail(subject, content, email);
			out.write("true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.write("false");
		}
		return null;
	}
}
