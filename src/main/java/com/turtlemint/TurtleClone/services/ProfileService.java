package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();

    Profile getProfileByRequestId(String requestId);
    String addProfile(Profile profile);

    Profile updateProfile(String requestId, Profile profile);
    void deleteProfile(String requestId);
}
