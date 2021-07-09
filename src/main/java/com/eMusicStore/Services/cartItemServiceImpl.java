package com.eMusicStore.Services;

import com.eMusicStore.DAO.cartItemDAO;
import com.eMusicStore.entity.Cart;
import com.eMusicStore.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class cartItemServiceImpl implements cartItemService {

    private final com.eMusicStore.DAO.cartItemDAO cartItemDAO;

    @Autowired
    public cartItemServiceImpl(cartItemDAO cartItemDAO) {
        this.cartItemDAO = cartItemDAO;
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDAO.removeCartItem(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        cartItemDAO.removeAllCartItems(cart);
    }

    @Override
    public CartItem getCartItemByProductId(String productId) {
        return cartItemDAO.getCartItemByProductId(productId);
    }
}
