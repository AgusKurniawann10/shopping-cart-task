package com.wide.latihan.boundary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user_name");
		String userPass = request.getParameter("user_password");
		String message = "";
		String contextPath = request.getContextPath();
		if("agus".equals(userName) && "password123".equals(userPass)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginContext", userName);
			
			response.sendRedirect(contextPath + "/backoffice/products/list");
			
		}else { 
			message = "Username atau password salah !";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/jsp/error-page.jsp")
				   .forward(request, response);
		}
	}

}
