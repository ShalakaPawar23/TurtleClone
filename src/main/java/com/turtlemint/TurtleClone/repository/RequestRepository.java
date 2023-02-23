package com.turtlemint.TurtleClone.repository;

import com.turtlemint.TurtleClone.model.Request;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RequestRepository extends MongoRepository<Request, String> {
    List<Request> findByVehicleMakeAndVehicleModel(String vmake, String vmodel);
}
