package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Checkout;
import com.turtlemint.TurtleClone.model.Customer;

import java.util.List;

public interface CheckoutService {

    Checkout getCheckoutByCheckoutId(String checkoutId);

    void addCheckout(Checkout checkout);

    Checkout updateCheckout(String checkoutId, Checkout checkout);

    void deleteCheckout(String checkoutId);

    Checkout getAllCheckoutByRequestId(String requestId);

    Checkout getByRequestIdandInsurer(String requestId, String insurerName, Customer customer);
}
