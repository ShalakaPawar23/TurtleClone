package com.turtlemint.TurtleClone.controller;

import com.turtlemint.TurtleClone.model.Insurer;
import com.turtlemint.TurtleClone.model.Profile;
import com.turtlemint.TurtleClone.model.Request;
import com.turtlemint.TurtleClone.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turtle")
public class RequestController {
    @Autowired
    private RequestService requestService;
    @GetMapping("/requests")
    public List<Request> getAllRequests(){

        return requestService.getAllRequests();
    }

    @GetMapping("/requests/{requestId}")
    public List<Request> getByRequestId(@PathVariable("requestId") String requestId){
        return requestService.searchByRequestId(requestId);

    }

    @PostMapping("/requests")
    public void addRequest(@RequestBody Request request){
        requestService.addRequest(request);
    }
}
