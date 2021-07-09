package com.eMusicStore.DAO;

import com.eMusicStore.entity.Cart;

public interface cartDAO {

    Cart getCartById(int cartId);

    void UpdateCart(Cart cart);
}
