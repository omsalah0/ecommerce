package com.eMusicStore.controller;

import com.eMusicStore.Services.cartService;
import com.eMusicStore.entity.Cart;
import com.eMusicStore.entity.Customer;
import com.eMusicStore.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/order")
public class OrderController {

    private final cartService cartService;
    private final com.eMusicStore.Services.orderService orderService;

    @Autowired
    public OrderController(cartService cartService, com.eMusicStore.Services.orderService orderService) {
        this.cartService = cartService;
        this.orderService = orderService;
    }


    @RequestMapping("/{cartId}")
    public String createOrder(@PathVariable int cartId) {
        Order order = new Order();
        Cart cart = cartService.getCartById(cartId);
        Customer customer = cart.getCustomer();
        order.setCart(cart);
        order.setCustomer(customer);
        order.setBillingAddress(customer.getBillingAddress());
        order.setShoppingAddress(customer.getShoppingAddress());

        orderService.addOrder(order);

        return "redirect:/checkout?cartId=" + cartId;

    }
}