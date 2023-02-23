package com.turtlemint.TurtleClone.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {
    String customerName;
    String customerNumber;
    String customerEmail;

    public Customer(String customerName, String customerNumber, String customerEmail) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerEmail = customerEmail;
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

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
