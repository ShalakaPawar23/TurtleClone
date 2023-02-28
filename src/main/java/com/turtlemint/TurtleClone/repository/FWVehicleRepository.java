package com.turtlemint.TurtleClone.repository;

import com.turtlemint.TurtleClone.model.FWVehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FWVehicleRepository extends MongoRepository<FWVehicle, String> {
    FWVehicle findByRequestId(String requestId);
    FWVehicle deleteByRequestId(String requestId);
}
