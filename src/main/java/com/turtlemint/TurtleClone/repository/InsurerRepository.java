package com.turtlemint.TurtleClone.repository;

import com.turtlemint.TurtleClone.model.Insurer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InsurerRepository extends MongoRepository<Insurer, String> {
    Insurer findByInsurerId(String insurerId);
}
