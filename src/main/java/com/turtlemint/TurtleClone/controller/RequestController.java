package com.turtlemint.TurtleClone.controller;

import com.turtlemint.TurtleClone.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turtle")
public class RequestController {
    @Autowired
    private RequestService requestService;

}
