package com.wide.latihan.boundary;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/frontoffice/order/cart")
public class ShoppingCartServlet extends FrontOfficeServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShoppingCartServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginContext = (String) session.getAttribute("loginContext");
			authenticateUser(request, response);
			
			request.getRequestDispatcher("/WEB-INF/jsp/shopping-cart.jsp").forward(request, response);
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
