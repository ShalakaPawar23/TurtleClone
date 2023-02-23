package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Checkout;
import com.turtlemint.TurtleClone.model.Customer;
import com.turtlemint.TurtleClone.model.Insurer;
import com.turtlemint.TurtleClone.model.Request;
import com.turtlemint.TurtleClone.repository.CheckoutRepository;
import com.turtlemint.TurtleClone.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    private RequestService requestService;

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

    @Override
    public List getAllCheckoutByRequestId(String requestId){
        List<List<String>> result = new ArrayList<List<String>>();
        List<Checkout> presentCheckout = checkoutRepository.findAllByRequestId(requestId);
        for(int i=0; i<presentCheckout.size(); i++){
            List<String> currResult = new ArrayList<String>();
            currResult.add(presentCheckout.get(i).getCustomer().getCustomerName());
            currResult.add(presentCheckout.get(i).getInsurer());
            currResult.add(presentCheckout.get(i).getInsuranceAmount());
            result.add(currResult);
        }
        return result;
    }

    @Override
    public String getByRequestIdandInsurer(String requestId, String insurerName, Customer customer){
        // find all by requestId - get all quotations
        List<Request> requests = requestService.searchByRequestId(requestId);
        ArrayList<Insurer> insurersLists = requests.get(0).getSupportedInsurers();
        Insurer insurer = null;
        //look for the insurer name in the list
        for(int i=0; i< insurersLists.size(); i++){
            insurer = insurersLists.get(i);
            if(insurer.getName().equalsIgnoreCase(insurerName)){
               break;
            }
        }
        if(insurer == null) {
            System.out.println("Insurer premium not found for requestId");
            return null;
        }
        // create a checkout instance and return it
        Checkout result = new Checkout(customer, requestId, insurer.getPremium());
        result.setInsurer(insurer.getName());

        // add in checkout repository
        checkoutRepository.insert(result);
        return result.getInsuranceAmount();
    }
}
