package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.FWVehicle;
import com.turtlemint.TurtleClone.model.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();

    List<FWVehicle> getAllFWVehicles();

    Profile getProfileByRequestId(String requestId);

    FWVehicle getFWVehicleByByRequestId(String requestId);

    String addProfile(Profile profile);

    String addFWVehicle(FWVehicle fwVehicle);

    Profile updateProfile(String requestId, Profile profile);

    FWVehicle updateFWVehicle(String requestId, FWVehicle fwVehicle);
    void deleteProfile(String requestId);
    void deleteFWVehicle(String requestId);
}
