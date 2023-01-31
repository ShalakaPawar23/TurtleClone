package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Checkout;
import com.turtlemint.TurtleClone.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    @Autowired
    private CheckoutRepository checkoutRepository;

    @Override
    public List<Checkout> getAllCheckouts(){
        return checkoutRepository.findAll();
    }

    @Override
    public Checkout getCheckoutByCheckoutId(String checkoutId){
        return checkoutRepository.findByCheckoutId(checkoutId);
    }

    @Override
    public void addCheckout(Checkout checkout){
        checkoutRepository.save(checkout);
    }

    @Override
    public Checkout updateCheckout(String checkoutId, Checkout checkout){
        Checkout checkout1 = checkoutRepository.findById(checkoutId).get();

        if(Objects.nonNull(checkout.getCustomerName()) && !"".equalsIgnoreCase(checkout.getCustomerName())){
            checkout1.setCustomerName(checkout.getCustomerName());
        }

        if(Objects.nonNull(checkout.getCustomerEmail())&&!"".equalsIgnoreCase(checkout.getCustomerEmail())){
            checkout1.setCustomerEmail(checkout.getCustomerEmail());
        }

        if (Objects.nonNull(checkout.getInsurer())&&!"".equalsIgnoreCase(checkout.getInsurer())){
            checkout1.setInsurer(checkout.getInsurer());
        }

        checkoutRepository.save(checkout1);
        return checkout1;
    }

    @Override
    public void deleteCheckout(String checkoutId) {
        checkoutRepository.deleteById(checkoutId);
    }
}
