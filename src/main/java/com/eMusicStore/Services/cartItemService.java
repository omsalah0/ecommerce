package com.eMusicStore.Services;

import com.eMusicStore.entity.Cart;
import com.eMusicStore.entity.CartItem;

public interface cartItemService {
    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(String productId);
}
