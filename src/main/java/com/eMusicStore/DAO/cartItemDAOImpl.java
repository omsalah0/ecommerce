package com.eMusicStore.DAO;

import com.eMusicStore.entity.Cart;
import com.eMusicStore.entity.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class cartItemDAOImpl implements cartItemDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public cartItemDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item :
                cartItems) {
            removeCartItem(item);
        }

    }

    @Override
    public CartItem getCartItemByProductId(String productId) {
        Session session = sessionFactory.getCurrentSession();
        Query<CartItem> query = session.createQuery("from CartItem where productId=:ID", CartItem.class);
        query.setParameter("ID", productId);
        return query.getSingleResult();
    }
}
