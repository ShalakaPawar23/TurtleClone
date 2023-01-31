package com.turtlemint.TurtleClone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Checkout")
public class Checkout {
    @Id
    private String checkoutId;
    private String customerName;
    private String customerEmail;
    private String insurer; //insurerId
    private String requestId;

    public Checkout(String customerName, String customerEmail, String insurer, String requestId) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.insurer = insurer;
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getInsurer() {
        return insurer;
    }

    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }
}
