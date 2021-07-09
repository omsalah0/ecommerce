package com.eMusicStore.controller;

import com.eMusicStore.Services.customerService;
import com.eMusicStore.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    private final customerService service;

    @Autowired
    public CartController(customerService service) {
        this.service = service;
    }

    @GetMapping
    public String getCart(@AuthenticationPrincipal User user) {
        Customer customer = service.getCustomerByUsername(user.getUsername());
        int cartId = customer.getCart().getCartId();
        return "redirect:/customer/cart/" + cartId;
    }

    @GetMapping("{cartId}")
    public String getCartRedirect(@PathVariable String cartId, Model model) {
        model.addAttribute(cartId);
        return "cart";
    }
}
