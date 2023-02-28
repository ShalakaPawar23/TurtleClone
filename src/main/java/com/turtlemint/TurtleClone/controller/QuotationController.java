package com.turtlemint.TurtleClone.controller;

import com.turtlemint.TurtleClone.model.Quotation;
import com.turtlemint.TurtleClone.services.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turtle")
public class QuotationController {
    @Autowired
    private QuotationService quotationService;
    @GetMapping("/quotations")
    public List<Quotation> getAllQuotations(){
        return quotationService.getAllQuotations();
    }

    @GetMapping("/quotations/{requestId}")
    public List<Quotation> getByRequestId(@PathVariable("requestId") String requestId){
        return quotationService.searchByRequestId(requestId);

    }

    @PostMapping("/quotations")
    public void addRequest(@RequestBody Quotation quotation){
        quotationService.addQuotation(quotation);
    }
}
