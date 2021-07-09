package com.eMusicStore.controller;


import com.eMusicStore.Services.cartItemService;
import com.eMusicStore.Services.cartService;
import com.eMusicStore.Services.customerService;
import com.eMusicStore.Services.productService;
import com.eMusicStore.entity.Cart;
import com.eMusicStore.entity.CartItem;
import com.eMusicStore.entity.Customer;
import com.eMusicStore.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/cart")
public class CartResources {

    private final cartService cart;
    private final customerService customer;
    private final productService product;
    private final cartItemService cartItemservice;

    @Autowired
    public CartResources(cartService cart, customerService customer, productService product, cartItemService cartItemservice) {
        this.cart = cart;
        this.customer = customer;
        this.product = product;
        this.cartItemservice = cartItemservice;
    }

    @GetMapping("{cartId}")
    public Cart getCartProducts(@PathVariable int cartId) {
        return cart.getCartById(cartId);
    }

    @PutMapping("/add/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addCartProduct(@AuthenticationPrincipal User activeUser, @PathVariable String productId) {
        Customer OldCustomer = customer.getCustomerByUsername(activeUser.getUsername());
        Cart cart = OldCustomer.getCart();
        List<CartItem> cartItem = cart.getCartItems();
        Product NewProduct = product.getProductById(productId);
        for (CartItem item : cartItem) {
            if (NewProduct.getProductID().equals(item.getProduct().getProductID())) {
                item.setQuantity(item.getQuantity() + 1);
                item.setTotalPrice(item.getTotalPrice() * item.getQuantity());
                cartItemservice.addCartItem(item);
                return;
            }
        }

        CartItem cartItem1 = new CartItem();
        cartItem1.setQuantity(1);
        cartItem1.setProduct(NewProduct);
        cartItem1.setCart(cart);
        cartItem1.setTotalPrice(NewProduct.getProductPrice() * cartItem1.getQuantity());
        cartItemservice.addCartItem(cartItem1);


    }

    @DeleteMapping("/remove/{productId}")
    public void removeCartItem(@PathVariable String productId) {
        CartItem cartItem = cartItemservice.getCartItemByProductId(productId);
        cartItemservice.removeCartItem(cartItem);
    }

    @DeleteMapping("/removeAll/{cartId}")
    public void deleteCart(@PathVariable int cartId) {
        Cart removeCart = cart.getCartById(cartId);
        cartItemservice.removeAllCartItems(removeCart);
    }
}
