package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Quotation;

import java.util.List;


public interface QuotationService {
    // returns all the quotations for every vertical, vehicle make, model
    List<Quotation> getAllQuotations();

    List<Quotation> searchByRequestId(String quotationId);

    String addQuotation(Quotation quotation);
}
