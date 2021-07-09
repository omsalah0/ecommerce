package com.eMusicStore.Services;

import com.eMusicStore.DAO.orderDAO;
import com.eMusicStore.entity.Cart;
import com.eMusicStore.entity.CartItem;
import com.eMusicStore.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class orderServiceImpl implements orderService {

    private final orderDAO orderDAO;
    private final cartService cartService;

    @Autowired
    public orderServiceImpl(orderDAO orderDAO, com.eMusicStore.Services.cartService cartService) {
        this.orderDAO = orderDAO;
        this.cartService = cartService;
    }

    @Override
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Override
    public double getOrderGrandTotal(int cartId) {
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();
        double GrandTotal = 0;
        for (CartItem cartItem :
                cartItems) {
            GrandTotal += cartItem.getTotalPrice();
        }
        return GrandTotal;
    }
}
