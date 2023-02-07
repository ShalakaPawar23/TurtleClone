package com.turtlemint.TurtleClone.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {
    String customerName;
    String customerNumber;
    String getCustomerEmail;

    public Customer(String customerName, String customerNumber, String getCustomerEmail) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.getCustomerEmail = getCustomerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getGetCustomerEmail() {
        return getCustomerEmail;
    }

    public void setGetCustomerEmail(String getCustomerEmail) {
        this.getCustomerEmail = getCustomerEmail;
    }
}
