package ntp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/cart", "/checkout", "/order", "/history", })
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		
		// Kiểm tra session để xác thực
		HttpSession session = httpReq.getSession(false);
		
		if(session != null && session.getAttribute("email") != null) {
			// Người dùng đã đăng nhập, tiếp tục request
			chain.doFilter(request, response);
		}else {
			// Người dùng chưa đăng nhập, chuyển hướng về trang đăng nhập
			httpRes.sendRedirect(httpReq.getContextPath() + "/login");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub	
	}
}
