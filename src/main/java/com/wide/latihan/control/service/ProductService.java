package com.wide.latihan.control.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.wide.latihan.DTO.ProductDTO;
import com.wide.latihan.entity.Product;

@Stateless
public class ProductService {
    @PersistenceContext
    private EntityManager em;
    
    public List<ProductDTO> findAll() {
        return em.createQuery("SELECT * FROM Product p", Product.class)
                .getResultList()
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }
    
    public Product findByNo(int no) {
        return em.find(Product.class, no);
    }

}
