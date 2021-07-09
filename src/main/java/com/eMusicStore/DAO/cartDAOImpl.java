package com.eMusicStore.DAO;

import com.eMusicStore.entity.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class cartDAOImpl implements cartDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public cartDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Cart.class, cartId);
    }

    @Override
    public void UpdateCart(Cart cart) {
        ////////////////TODO:///////////////
    }
}
