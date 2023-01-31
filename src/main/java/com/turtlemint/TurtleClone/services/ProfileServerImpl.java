package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Profile;
import com.turtlemint.TurtleClone.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProfileServerImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileByRequestId(String requestId){
        return profileRepository.findByRequestId(requestId);
    }

    @Override
    public String addProfile(Profile profile){
        // create request id - unique
        String requestId = UUID.randomUUID().toString().replaceAll("_", "");

        // check if already used this uuid then generate again
        // check the list of profiles present
        while(profileRepository.findByRequestId(requestId) != null){
            requestId = UUID.randomUUID().toString().replaceAll("_", "");
        }
        System.out.println("Profile request id = " + requestId);
        // set the request id
        profile.setRequestId(requestId);
        // add profile
        profileRepository.save(profile);
        return requestId;
    }


    @Override
    public Profile updateProfile(String requestId, Profile profile) {
        Profile profile1 = profileRepository.findByRequestId(requestId);

        // check if non-null then compare with original value
        if(Objects.nonNull(profile1.getVertical()) && !"".equalsIgnoreCase(profile.getVertical())){
            profile1.setVertical(profile.getVertical());
        }

        if(Objects.nonNull(profile1.getVehicleMake()) && !"".equalsIgnoreCase(profile.getVehicleMake())){
            profile1.setVehicleMake(profile.getVehicleMake());
        }

        if (Objects.nonNull(profile1.getVehicleModel())&&!"".equalsIgnoreCase(profile.getVehicleModel())){
            profile1.setVehicleModel(profile.getVehicleModel());
        }
        profileRepository.save(profile1);
        return profile1;
    }

    @Override
    public String deleteProfile(String requestId) {

        profileRepository.deleteByRequestId(requestId);
        return "Profile deleted successfully!";

    }
}
