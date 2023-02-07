package com.turtlemint.TurtleClone.repository;

import com.turtlemint.TurtleClone.model.Request;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestRepository extends MongoRepository<Request, String> {
    Request getByRequestId(String requestId);
}
