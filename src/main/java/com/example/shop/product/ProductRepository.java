package com.example.shop.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Product product){
        em.persist(product); // insert
    }

    public List<Product> findAll(){
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    public Product findById(Long productId){
        return em.find(Product.class, productId);
    }

    public void update(Long productId, Product updateParam){
        Product product = em.find(Product.class, productId);

        product.setProductName(updateParam.getProductName());
        product.setPrice(updateParam.getPrice());
        product.setQuantity(updateParam.getQuantity());
    }

    public void delete(Long productId){
        Product product = em.find(Product.class, productId);
        em.remove(product);
    }
}