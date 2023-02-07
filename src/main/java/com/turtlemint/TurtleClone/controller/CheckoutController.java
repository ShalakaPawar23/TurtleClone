package com.turtlemint.TurtleClone.controller;

import com.turtlemint.TurtleClone.model.*;
import com.turtlemint.TurtleClone.services.CheckoutService;
import com.turtlemint.TurtleClone.services.CheckoutServiceImpl;
import com.turtlemint.TurtleClone.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/turtle")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/checkout/{requestId}")
    public Checkout getAllCheckoutByRequestId(@PathVariable("requestId") String requestId){
        return checkoutService.getAllCheckoutByRequestId(requestId);
    }

    @GetMapping(value = "/checkout/{checkoutId}")
    public Checkout getCheckout(@PathVariable("checkoutId") String checkoutId){
        return checkoutService.getCheckoutByCheckoutId(checkoutId);
    }

    @GetMapping("/checkout/{requestId}/{insurerName}")
    public Checkout getCheckoutByRequestIdandInsurer(@PathVariable("requestId") String requestId, @PathVariable("insurerName") String insurerName, @RequestBody Customer customer){
       return checkoutService.getByRequestIdandInsurer(requestId, insurerName, customer);
    }

    @PostMapping("/checkout")
    public void addCheckout(@RequestBody Checkout checkout){
        checkoutService.addCheckout(checkout);
    }


    @PutMapping("/checkout/{checkoutId}")
    public Checkout updateProfile(@PathVariable("checkoutId") String checkoutId, @RequestBody Checkout checkout){
        return checkoutService.updateCheckout(checkoutId, checkout);
    }

    @DeleteMapping("/checkout/{checkoutId}")
    public void deleteCheckout(@PathVariable("checkoutId") String checkoutId){
        checkoutService.deleteCheckout(checkoutId);
    }
}
