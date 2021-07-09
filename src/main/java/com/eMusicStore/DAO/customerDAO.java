package com.eMusicStore.DAO;

import com.eMusicStore.entity.Customer;

import java.util.List;

public interface customerDAO {
    void addCustomer(Customer customer);

    Customer getCustomerByID(String id);

    List<Customer> getAllCustomer();

    Customer getCustomerByUsername(String username);
}
