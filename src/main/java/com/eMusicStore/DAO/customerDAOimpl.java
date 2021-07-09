package com.eMusicStore.DAO;

import com.eMusicStore.Exceptions.emailAlreadyExists;
import com.eMusicStore.Exceptions.usernameAlreadyExists;
import com.eMusicStore.entity.Authorities;
import com.eMusicStore.entity.Cart;
import com.eMusicStore.entity.Customer;
import com.eMusicStore.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class customerDAOimpl implements customerDAO {

    private final SessionFactory sessionFactory;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public customerDAOimpl(SessionFactory sessionFactory, PasswordEncoder passwordEncoder) {
        this.sessionFactory = sessionFactory;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addCustomer(Customer customer) {

        if (getCustomerByUsername(customer.getUsername()) != null) {
            throw new usernameAlreadyExists("Username already exists");
        }
        if (getCustomerByEmail(customer.getEmail()) != null) {
            throw new emailAlreadyExists("email already exists");
        }
        Session session = sessionFactory.getCurrentSession();
        customer.getBillingAddress().setCustomer(customer);
        customer.getShoppingAddress().setCustomer(customer);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShoppingAddress());

        Users user = new Users();
        user.setUsername(customer.getUsername());
        user.setPassword(passwordEncoder.encode(customer.getPassword()));
        user.setEnabled(customer.getEnabled());

        Authorities authorities = new Authorities();
        authorities.setUsername(customer.getUsername());
        authorities.setAuthority("ROLE_CUSTOMER");
        session.saveOrUpdate(user);
        session.saveOrUpdate(authorities);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(cart);
    }

    @Override
    public Customer getCustomerByID(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = session.createQuery("from Customer", Customer.class);
        return customerQuery.getResultList();
    }


    @Override
    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = session.createQuery("from Customer where username=:username", Customer.class);
        customerQuery.setParameter("username", username);
        Customer customer = null;
        try {
            customer = customerQuery.getSingleResult();

        } catch (Exception exception) {
        }
        return customer;
    }

    private Customer getCustomerByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = session.createQuery("from Customer where email=:email", Customer.class);
        customerQuery.setParameter("email", email);
        Customer customer = null;
        try {
            customer = customerQuery.getSingleResult();

        } catch (Exception exception) {
        }
        return customer;
    }
}
