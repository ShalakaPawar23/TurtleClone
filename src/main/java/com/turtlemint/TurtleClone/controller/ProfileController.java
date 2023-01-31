package com.turtlemint.TurtleClone.controller;

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

    @GetMapping("/profiles")
    public List<Profile> getAllProfiles(){

        return profileService.getAllProfiles();
    }

    @GetMapping("/profile/{requestId}")
    public Profile getProfileByRequestId(@PathVariable("requestId") String requestId){
        return profileService.getProfileByRequestId(requestId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/profiles/{enteredProfile}")
    public String addProfile(@PathVariable("enteredProfile") Profile profile){
        return profileService.addProfile(profile);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/profiles/{requestId}")
    public Profile updateProfile( @PathVariable("requestId") String requestId, @RequestBody Profile profile){
        return profileService.updateProfile(requestId, profile);
    }
}
