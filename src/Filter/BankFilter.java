package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import manager.ManagerImpl;

public class BankFilter extends UrlRewriteFilter {
//	ManagerImpl man ;
    public BankFilter() {
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");  //编码变成utf-8
        super.doFilter(request, response, chain);
    }
}
