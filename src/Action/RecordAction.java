package Action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import manager.ManagerImpl;
import manager.MangerInterface;

@Controller
public class RecordAction  {
	
   @Resource(name="ManagerImpl")
   private MangerInterface manager;
	
	public void setManager(MangerInterface manager) {
		this.manager = manager;
	}
	
	
	
	/**
	 * 消费记录
	 */
	@RequestMapping("/record.do")
	public String execute(HttpServletRequest req)throws Exception { 
		HttpSession session = req.getSession();
		int id = (int)session.getAttribute("userid");
		int show = 3; //每一页显示的记录数
		int totalPages=0;  //总的页数
		int totalRecord=0; //总的记录
		totalRecord = manager.getTotalRecord(id); //得到总的记录
		totalPages = (totalRecord+show-1)/show;//得到总的页数
		
		String pags = req.getParameter("pags");  //页面传回来的参数,跳转的页数
		int page = 0; //当前的页数
		if(pags==null) {
			page = 1;
		}else{
			page = Integer.parseInt(pags);
		}
		req.setAttribute("totalPages",totalPages);  //保存最大页数
		req.setAttribute("page", page);  //保存当前页数
		//查询得到记录
		List list = new ArrayList();
		list = manager.getRecord(id,(page-1)*show,show);
		
		req.setAttribute("list", list);   //储存记录
		return "/WEB-INF/showrecord";
	}
}
