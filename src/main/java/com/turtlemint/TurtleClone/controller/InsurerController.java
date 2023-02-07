package com.turtlemint.TurtleClone.controller;


import com.turtlemint.TurtleClone.model.Insurer;
import com.turtlemint.TurtleClone.services.CheckoutService;
import com.turtlemint.TurtleClone.services.InsurerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turtle")
public class InsurerController {
    @Autowired
    public InsurerService insurerService;

    @GetMapping("/insurers")
    public List<Insurer> getAllInsurers(){
        return insurerService.getAllInsurers();
    }

    @GetMapping("/insurers/{insurerId}")
    public Insurer getInsurerByInsurerId(@PathVariable("insurerId") String insurerId){
        return  insurerService.getInsurerByInsurerId(insurerId);
    }

    @PostMapping("/insurers")
    public void addInsurer(@RequestBody Insurer insurer){
        insurerService.addInsurer(insurer);
    }
}
