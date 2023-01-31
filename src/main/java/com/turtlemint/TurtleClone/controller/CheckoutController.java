package com.turtlemint.TurtleClone.controller;

import com.turtlemint.TurtleClone.model.Checkout;
import com.turtlemint.TurtleClone.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turtle")
public class CheckoutController {
    @Autowired
    public CheckoutService checkoutService;

    @RequestMapping("/checkout")
    public List<Checkout> getAllCheckouts(){
        return checkoutService.getAllCheckouts();
    }

    @GetMapping(value = "/checkout", params = "checkoutId")
    public Checkout getCheckout(@RequestParam String checkoutId){
        return checkoutService.getCheckoutByCheckoutId(checkoutId);
    }
}
