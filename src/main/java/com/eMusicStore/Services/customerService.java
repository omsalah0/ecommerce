package com.eMusicStore.Services;

import com.eMusicStore.entity.Customer;

import java.util.List;

public interface customerService {
    void addCustomer(Customer customer);

    Customer getCustomerByID(String id);

    List<Customer> getAllCustomer();

    Customer getCustomerByUsername(String Username);
}
