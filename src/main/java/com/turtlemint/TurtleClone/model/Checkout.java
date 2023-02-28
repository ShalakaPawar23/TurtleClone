package com.turtlemint.TurtleClone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Checkout")
public class Checkout {
    @Id
    private String checkoutId;
    private Customer customer;
    private String insurer;
    private String insuranceAmount; //insurerId
    private String requestId;

    public Checkout(Customer customer, String requestId, String insurer, String insuranceAmount) {
        this.customer = customer;
        this.insurer = insurer;
        this.insuranceAmount = insuranceAmount;
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

    public Customer getCustomer() {
        return customer;
    }

    public String getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(String insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getInsurer() {
        return insurer;
    }

    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }
}
