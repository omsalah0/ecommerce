package com.eMusicStore.Services;

import com.eMusicStore.DAO.cartDAO;
import com.eMusicStore.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class cartServiceImpl implements cartService {

    private final cartDAO cart;

    @Autowired
    public cartServiceImpl(cartDAO cart) {
        this.cart = cart;
    }


    @Override
    public Cart getCartById(int cartId) {
        return cart.getCartById(cartId);
    }

    @Override
    public void UpdateCart(Cart NCart) {
        cart.UpdateCart(NCart);
    }
}
