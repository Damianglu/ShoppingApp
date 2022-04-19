package com.example.shoppingapp.models;

public class ProductModel {
    String productImage;
    String productName;
    String productDescription;
    String productPrice;
    String productQuantity;
    String productShippingCost;

    ProductModel(){ }

    public ProductModel(String productImage, String productName, String productDescription, String productPrice, String productQuantity, String productShippingCost) {
        this.productImage = productImage;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productShippingCost = productShippingCost;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductShippingCost() {
        return productShippingCost;
    }

    public void setProductShippingCost(String productShippingCost) {
        this.productShippingCost = productShippingCost;
    }
}

