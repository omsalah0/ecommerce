package com.eMusicStore.DAO;

import com.eMusicStore.entity.Product;

import java.util.List;

public interface productDAO {
    void addOrUpdateProduct(Product product);

    Product getProductById(String productID);

    List<Product> getAllProducts();

    void deleteProduct(String productID);
}
