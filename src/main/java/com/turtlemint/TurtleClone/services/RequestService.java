package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {
    List<Request> getAllRequests();

    Request getByRequestId(String requestId);

    List<Request> getByRequestId(String requestId);

    Request addRequest(Request request);
}
