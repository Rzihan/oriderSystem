package com.topview.www.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckFilter implements Filter {

	public void destroy() {	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		if(req.getRequestURI().endsWith(".css")
				||req.getRequestURI().endsWith(".jpg")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(req.getRequestURI().endsWith("login.jsp") 
				|| req.getRequestURI().endsWith("LoginServlet")
				|| req.getRequestURI().endsWith("signIn.jsp") 
				|| req.getRequestURI().endsWith("signInFailure.jsp")
				|| req.getRequestURI().endsWith("signInSuccess.jsp") 
				|| req.getRequestURI().endsWith("SignInServlet") 
				|| req.getRequestURI().endsWith("menu.jsp") ) {
			chain.doFilter(request, response);
			return;
		}
		
		if(null == req.getSession().getAttribute("user")) {
			resp.sendRedirect( req.getContextPath() + "/login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
