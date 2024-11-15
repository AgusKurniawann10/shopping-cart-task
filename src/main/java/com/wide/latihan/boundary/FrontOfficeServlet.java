package com.wide.latihan.boundary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontOfficeServlet extends HttpServlet{
	
	protected void authenticateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		HttpSession session = request.getSession();
		String loginContext = (String) session.getAttribute("loginContext");
		if (loginContext == null) { 
			request.setAttribute("message", "anda belum login atau session anda sudah expired");
			request.getRequestDispatcher("/WEB-INF/jsp/login-form.jsp").forward(request, response);
			return;
		}
	}

}
