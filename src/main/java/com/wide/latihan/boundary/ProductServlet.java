package com.wide.latihan.boundary;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wide.latihan.DTO.ProductDTO;
import com.wide.latihan.control.service.ProductService;
import com.wide.latihan.entity.Product;

@WebServlet(urlPatterns = { "/backoffice/products/show", "/backoffice/products/list", "/backoffice/products/view" })
public class ProductServlet extends HttpServlet {
    
    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String path = request.getServletPath();

        if ("/backoffice/products/list".equals(path)) {
            List<ProductDTO> products = productService.findAll();
            request.setAttribute("data_product", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/shopping-cart.jsp");
            dispatcher.forward(request, response);
            
        } else if ("/backoffice/products/view".equals(path)) {
            int no = Integer.parseInt(request.getParameter("no"));
            Product product = productService.findByNo(no);
            request.setAttribute("product", new ProductDTO(product));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/product-view.jsp");
            dispatcher.forward(request, response);
        }
    }
}
