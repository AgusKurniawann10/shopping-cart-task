package com.wide.latihan.control.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.wide.latihan.entity.Order;
import com.wide.latihan.entity.OrderItem;
import com.wide.latihan.infrastructure.DBUtils;

@Stateless
public class OrderRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Order order) throws SQLException {
        em.persist(order);
        
        String insertOrderQuery = "INSERT INTO orders (total_price) VALUES (?)";
        String insertOrderItemQuery = "INSERT INTO order_items (order_id, product_id, quantity, total_price) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement orderStmt = conn.prepareStatement(insertOrderQuery, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement orderItemStmt = conn.prepareStatement(insertOrderItemQuery)) {

            conn.setAutoCommit(false); 

         
            orderStmt.setDouble(1, order.getTotal());
            orderStmt.executeUpdate();
            ResultSet generatedKeys = orderStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int orderId = generatedKeys.getInt(1);

            
                for (OrderItem item : order.getItems()) {
                    orderItemStmt.setInt(1, orderId);
                    orderItemStmt.setInt(2, item.getProduct().getNo());
                    orderItemStmt.setInt(3, item.getQuantity());
                    orderItemStmt.setDouble(4, item.getTotalPrice());
                    orderItemStmt.addBatch();
                }
                orderItemStmt.executeBatch();
                conn.commit(); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
