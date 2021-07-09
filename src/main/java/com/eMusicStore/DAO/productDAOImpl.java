package com.eMusicStore.DAO;

import com.eMusicStore.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class productDAOImpl implements productDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public productDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addOrUpdateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);


    }

    @Override
    public Product getProductById(String productID) {

        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, productID);
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public void deleteProduct(String productID) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(productID));

    }
}
