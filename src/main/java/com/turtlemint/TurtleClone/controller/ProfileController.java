package com.turtlemint.TurtleClone.controller;

import com.turtlemint.TurtleClone.model.FWVehicle;
import com.turtlemint.TurtleClone.model.Profile;
import com.turtlemint.TurtleClone.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turtle")
public class ProfileController {

    @Autowired
    private ProfileService profileService;


    @GetMapping("/profiles/TW")
    public List<Profile> getAllProfiles(){
        return profileService.getAllProfiles();
    }
    @GetMapping("/profiles/FW")
    public List<FWVehicle> getAllFWVehicles(){
        return profileService.getAllFWVehicles();
    }

    @GetMapping("/profiles/TW/{requestId}")
    public Profile getProfileByRequestId(@PathVariable("requestId") String requestId){
        return profileService.getProfileByRequestId(requestId);
    }

    @GetMapping("/profiles/FW/{requestId}")
    public FWVehicle getFWVehicleByRequestId(@PathVariable("requestId") String requestId){
        return profileService.getFWVehicleByByRequestId(requestId);
    }

    @PostMapping("/profiles")
    public String addProfile(@RequestBody Profile profile){
        return profileService.addProfile(profile);
    }

//    @PutMapping("/profiles/TW/{requestId}")
//    public Profile updateProfile( @PathVariable("requestId") String requestId, @RequestBody Profile profile){
//        return profileService.updateProfile(requestId, profile);
//    }
//
//    @PutMapping("/profiles/FW/{requestId}")
//    public FWVehicle updateFWVehicle(@PathVariable("requestId") String requestId, @RequestBody FWVehicle fwVehicle){
//        return profileService.updateFWVehicle(requestId, fwVehicle);
//    }

    @DeleteMapping("/profiles/{requestId}")
    public void deleteProfile(@PathVariable("requestId") String request_id){
        profileService.deleteProfile(request_id);
    }
}
