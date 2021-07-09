package com.eMusicStore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order")
public class Order implements Serializable {

    private static final long serialVersionUID = -2682201011310744182L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @OneToOne
    @JoinColumn(name = "cartId")
    public Cart cart;

    @OneToOne
    @JoinColumn(name = "customerId")
    public Customer customer;

    @OneToOne
    @JoinColumn(name = "shoppingAddressId")
    public ShoppingAddress shoppingAddress;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    public BillingAddress billingAddress;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShoppingAddress getShoppingAddress() {
        return shoppingAddress;
    }

    public void setShoppingAddress(ShoppingAddress shoppingAddress) {
        this.shoppingAddress = shoppingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }
}
