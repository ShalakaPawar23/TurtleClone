package com.turtlemint.TurtleClone.repository;

import com.turtlemint.TurtleClone.model.Checkout;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CheckoutRepository extends MongoRepository<Checkout, String> {
    Checkout findByCheckoutId(String CheckoutId);
    Checkout findByRequestId(String RequestId);
}
