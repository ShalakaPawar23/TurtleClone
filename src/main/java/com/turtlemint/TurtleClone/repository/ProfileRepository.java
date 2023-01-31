package com.turtlemint.TurtleClone.repository;

import com.turtlemint.TurtleClone.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {
    Profile findByRequestId(String requestId);
    Profile deleteByRequestId(String requestId);
}
