package com.wide.latihan.control.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.wide.latihan.entity.Product;

@Stateless
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("SELECT * FROM Product p ORDER BY p. no ASC", Product.class);
        return query.getResultList();
    }

    public Product findByNo(int no) {
        return em.createQuery("SELECT * FROM product p WHERE p. no = ?", Product.class)
                 .setParameter("no", no)
                 .getSingleResult();
    }
}
