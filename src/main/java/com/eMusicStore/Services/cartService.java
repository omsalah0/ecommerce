package com.eMusicStore.Services;

import com.eMusicStore.entity.Cart;

public interface cartService {

    Cart getCartById(int cartId);

    void UpdateCart(Cart cart);
}
