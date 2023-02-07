package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {
    // returns all the quotations for every vertical, vehicle make, model
    List<Request> getAllRequests();

    Request getByRequestId(String requestId);

    String addRequest(Request request);
}
