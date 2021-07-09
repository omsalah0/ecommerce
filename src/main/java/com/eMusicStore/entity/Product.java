package com.eMusicStore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 4162654531141401300L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String productID;

    @NotNull(message = "This Field is Required")
    @Column(name = "product_name")
    private String productName;

    @NotNull(message = "This Field is Required")
    @Column(name = "product_category")
    private String productCategory;

    @NotNull(message = "This Field is Required")
    @Column(name = "product_description")
    private String productDescription;

    @NotNull(message = "This Field is Required")
    @Min(value = 1L, message = "The Price must be greater than 0")
    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_condition")
    private String productCondition;

    @Column(name = "product_status")
    private String productStatus;

    //need an implementation for accept string input
    @NotNull(message = "This Field is Required")
    @Min(value = 1L, message = "please enter Valid number. must be positive!")
    @Column(name = "unit_in_stock")
    private int unitInStock;

    @NotNull(message = "This Field is Required")
    @Column(name = "product_manufacturer")
    private String productManufacturer;

    @Transient
    private MultipartFile productImage;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItems;


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productCondition='" + productCondition + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", unitInStock=" + unitInStock +
                ", productManufacturer='" + productManufacturer + '\'' +
                '}';
    }
}
