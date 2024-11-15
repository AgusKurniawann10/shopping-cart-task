package com.wide.latihan.control.service;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.wide.latihan.control.persistence.OrderRepository;
import com.wide.latihan.entity.Order;
import com.wide.latihan.entity.OrderItem;
import com.wide.latihan.entity.Product;

@Stateless
public class OrderService {
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private OrderRepository orderRepository;
    
    @Inject
    private ProductService productService;
    
    @Transactional
    public void saveOrder(Order order) {
        try {
			orderRepository.save(order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    @Transactional
    public void addItemToOrder(Order order, int productNo, int quantity) {
        Product product = productService.findByNo(productNo);
        if (product != null) {
            OrderItem item = new OrderItem(product, quantity);
            item.setProduct(product);
            item.setQuantity(quantity);
            order.addItem(item);
        }
    }

}
