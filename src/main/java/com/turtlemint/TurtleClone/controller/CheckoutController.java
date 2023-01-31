package com.turtlemint.TurtleClone.controller;

import com.turtlemint.TurtleClone.model.Checkout;
import com.turtlemint.TurtleClone.model.Profile;
import com.turtlemint.TurtleClone.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turtle")
public class CheckoutController {
    @Autowired
    public CheckoutService checkoutService;

    @GetMapping("/checkout")
    public List<Checkout> getAllCheckouts(){
        return checkoutService.getAllCheckouts();
    }

    @GetMapping(value = "/checkout/{checkoutId}")
    public Checkout getCheckout(@PathVariable("checkoutId") String checkoutId){
        return checkoutService.getCheckoutByCheckoutId(checkoutId);
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
