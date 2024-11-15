package com.wide.latihan.infrastructure;

import java.io.IOException;

import javax.security.auth.login.LoginContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(filterName = "/AutenticationFilter", urlPatterns = "/frontoffice/*", urlPatterns = "/admin/*")
public class AutenticationFilter extends HttpFilter implements Filter {
       
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) response;
		HttpSession session = req.getSession();
		String loginContext = (String) session.getAttribute("LoginContext");
		if(loginContext == null) { 
			request.setAttribute("message", "[filter]anda belum login atau session anda sudah expired");
			request.getRequestDispatcher("/WEB-INF/jsp/login-form.jsp").forward(request, response);
			return;
		} else {
			
			chain.doFilter(request, response);
			
		}
		
		
	}


}
