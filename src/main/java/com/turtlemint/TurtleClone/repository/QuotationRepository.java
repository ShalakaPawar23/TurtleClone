package com.turtlemint.TurtleClone.repository;

import com.turtlemint.TurtleClone.model.Quotation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuotationRepository extends MongoRepository<Quotation, String> {
    List<Quotation> findByVehicleMakeAndVehicleModel(String vmake, String vmodel);
}
