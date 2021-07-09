package com.eMusicStore.Services;

import com.eMusicStore.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class productServiceImple implements com.eMusicStore.Services.productService {

    private final com.eMusicStore.DAO.productDAO productDAO;

    @Autowired
    public productServiceImple(com.eMusicStore.DAO.productDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    @Transactional
    public void addOrUpdateProduct(Product product) {
        productDAO.addOrUpdateProduct(product);
    }

    @Override
    @Transactional
    public Product getProductById(String productID) {
        return productDAO.getProductById(productID);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    @Transactional
    public void deleteProduct(String productID) {
        productDAO.deleteProduct(productID);
    }
}
