package com.dmantz.ecommerceapp.model;

public class OrderItem {

    String productName;
    int productPrice;
    int productQuantity;
    String option1Value;
    String option1Name;
    String option2Value;
    String option2Name;
    String productId;


    public OrderItem(String productName, int productPrice, int productQuantity, String option1Value, String option1Name, String option2Value, String option2Name) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.option1Value = option1Value;
        this.option1Name = option1Name;
        this.option2Value = option2Value;
        this.option2Name = option2Name;
    }


    OrderItem(){

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getOption1Value() {
        return option1Value;
    }

    public void setOption1Value(String option1Value) {
        this.option1Value = option1Value;
    }

    public String getOption1Name() {
        return option1Name;
    }

    public void setOption1Name(String option1Name) {
        this.option1Name = option1Name;
    }

    public String getOption2Value() {
        return option2Value;
    }

    public void setOption2Value(String option2Value) {
        this.option2Value = option2Value;
    }

    public String getOption2Name() {
        return option2Name;
    }

    public void setOption2Name(String option2Name) {
        this.option2Name = option2Name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
