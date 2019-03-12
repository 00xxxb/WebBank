package Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Verification1 {
	@RequestMapping("/Checkverification1.do")
	public String execute(HttpServletRequest request, HttpServletResponse response)
	        throws Exception {
		HttpSession session = request.getSession();
		String sss = request.getParameter("yanzheng");
		String yyy = (String)session.getAttribute("yanzhengma");
		PrintWriter out = response.getWriter();
		if(sss.equals(yyy)) {
			out.write("true");
		}else {
			out.write("false");
		}
		return null;
	}
}
