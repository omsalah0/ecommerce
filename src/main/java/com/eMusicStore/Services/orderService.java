package com.eMusicStore.Services;

import com.eMusicStore.entity.Order;

public interface orderService {
    void addOrder(Order order);

    double getOrderGrandTotal(int cartId);
}
