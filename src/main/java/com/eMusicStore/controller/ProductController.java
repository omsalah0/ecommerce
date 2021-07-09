package com.eMusicStore.controller;

import com.eMusicStore.Services.productService;
import com.eMusicStore.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final productService productService;

    @Autowired
    public ProductController(productService productService) {
        this.productService = productService;
    }

    @GetMapping("/productList")
    public String getProductList(Model model) {
        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);
        return "productList";
    }

    @GetMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "viewProduct";
    }


}
