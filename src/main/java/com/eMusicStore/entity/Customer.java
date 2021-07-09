package com.eMusicStore.entity;

import com.eMusicStore.Annotation.passwordMatches;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@passwordMatches()
public class Customer implements Serializable {

    private static final long serialVersionUID = 4537965515350275502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int customerId;


    @Column(name = "customerName")
    private String customerName;


    @Column(name = "username")
    private String username;


    @Transient
    private String password;

    @Transient
    private String confirmPassword;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "numberOfPhone")
    private Long numberOfPhone;

    @Column(name = "enabled")
    private int Enabled;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shoppingAddressId")
    private ShoppingAddress shoppingAddress;

    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(Long numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShoppingAddress getShoppingAddress() {
        return shoppingAddress;
    }

    public void setShoppingAddress(ShoppingAddress shoppingAddress) {
        this.shoppingAddress = shoppingAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getEnabled() {
        return Enabled;
    }

    public void setEnabled(int enabled) {
        Enabled = enabled;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
