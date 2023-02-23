package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Checkout;
import com.turtlemint.TurtleClone.model.Customer;
import com.turtlemint.TurtleClone.model.Insurer;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CheckoutService {

    Checkout getCheckoutByCheckoutId(String checkoutId);

    void addCheckout(Checkout checkout);

    Checkout updateCheckout(String checkoutId, Checkout checkout);

    void deleteCheckout(String checkoutId);

    List<Insurer> getAllCheckoutByRequestId(String requestId);

    String getByRequestIdandInsurer(String requestId, String insurerName, Customer customer);
}
