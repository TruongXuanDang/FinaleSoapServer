package com.demo.dao;
import com.demo.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public ProductDAO() {
    }


    public List<Product> getProduct()
    {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> list = em.createQuery("SELECT c from Product c").getResultList();

        em.getTransaction().commit();
        em.close();
        return list;
    }
}
