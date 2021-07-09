package com.eMusicStore.Services;

import com.eMusicStore.DAO.customerDAO;
import com.eMusicStore.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class customerServiceImpl implements customerService {

    private final customerDAO customerDao;

    @Autowired
    public customerServiceImpl(customerDAO customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void addCustomer(Customer customer) {

        customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerByID(String id) {
        return customerDao.getCustomerByID(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    @Override
    public Customer getCustomerByUsername(String Username) {
        return customerDao.getCustomerByUsername(Username);
    }


}
