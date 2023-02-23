package com.turtlemint.TurtleClone.repository;

import com.turtlemint.TurtleClone.model.Checkout;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CheckoutRepository extends MongoRepository<Checkout, String> {
    Checkout findByCheckoutId(String CheckoutId);
    List<Checkout> findAllByRequestId(String RequestId);
}
