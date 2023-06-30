package com.example.components.produts;

public class Product {
    ProductType type;
    double price;
    int productCode;

    public Product(ProductType productType, double price, int code){
        this.price = price;
        this.type = productType;
        this.productCode = code;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }
}
