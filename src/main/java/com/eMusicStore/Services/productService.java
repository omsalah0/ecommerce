package com.eMusicStore.Services;

import com.eMusicStore.entity.Product;

import java.util.List;

public interface productService {

    void addOrUpdateProduct(Product product);

    Product getProductById(String productID);

    List<Product> getAllProducts();

    void deleteProduct(String productID);

}
