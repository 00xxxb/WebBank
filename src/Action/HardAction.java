/*package Action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HardAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response)
	        throws Exception {
	        String command = request.getParameter("command");
	        if(command.equals("zh")) {
	        	Locale locale = new Locale("zh","CN");
	        	this.setLocale(request, locale);
	        }else if(command.equals("en")) {
	        	Locale locale = new Locale("en","US");
	        	this.setLocale(request, locale);
	        }
	        return mapping.findForward("drow");
	    }
}
*/