package com.wide.latihan.boundary;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wide.latihan.entity.Order;
import com.wide.latihan.DTO.OrderDTO;
import com.wide.latihan.control.service.OrderService;

@WebServlet(urlPatterns = { "/backoffice/cart/add", "/backoffice/cart/view", "/backoffice/cart/placeOrder" })
public class CartServlet extends HttpServlet {
    @Inject
    private OrderService orderService;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");
        
        if (order == null) {
            order = new Order();
            session.setAttribute("order", order);
        }
        
        if ("/backoffice/cart/add".equals(path)) {
            int productNo = Integer.parseInt(request.getParameter("productNo"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            orderService.addItemToOrder(order, productNo, quantity);
            response.sendRedirect(request.getContextPath() + "/backoffice/cart/view");
        } else if ("/backoffice/cart/placeOrder".equals(path)) {
            order.setCustomerName(request.getParameter("customerName"));
            order.setAddress(request.getParameter("address"));
            orderService.saveOrder(order);
            session.removeAttribute("order");
            response.sendRedirect(request.getContextPath() + "/backoffice/products/list");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Order order = (Order) request.getSession().getAttribute("order");
        if (order != null) {
            request.setAttribute("orderDTO", new OrderDTO(order));
        }
        request.getRequestDispatcher("/WEB-INF/jsp/order-cart.jsp").forward(request, response);
    }
}
