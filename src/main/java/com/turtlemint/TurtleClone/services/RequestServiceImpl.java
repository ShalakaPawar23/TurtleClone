package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Insurer;
import com.turtlemint.TurtleClone.model.Profile;
import com.turtlemint.TurtleClone.model.Request;
import com.turtlemint.TurtleClone.repository.InsurerRepository;
import com.turtlemint.TurtleClone.repository.ProfileRepository;
import com.turtlemint.TurtleClone.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private InsurerService insurerService;
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private InsurerRepository insurerRepository;

    @Override
    public List<Request> getAllRequests(){
        return requestRepository.findAll();
    }

    // input = requestid
    // fetch the vehicle make and model and find by them
    @Override
    public List<Request> searchByRequestId(String requestId){
        //use profile repo
        Profile profile = profileRepository.findByRequestId(requestId);
        if (profile == null)
            return null;
        String vertical = profile.getVertical();
        String vMake = profile.getVehicleMake();
        String vModel = profile.getVehicleModel();

        return requestRepository.findByVmakeAndVmodel(vMake, vModel);
    }


    // have not checked if already present
    @Override
    public String addRequest(Request request){
        Profile profile = new Profile(request.getVertical(), request.getVehicleMake(), request.getVehicleModel());
        profileService.addProfile(profile);
        for(int i=0; i<request.getSupportedInsurers().size(); i++){
            Insurer insurer = new Insurer(request.getSupportedInsurers().get(i).getInsurerName(), request.getSupportedInsurers().get(i).getPremium());
            String insId = insurerService.addInsurer(insurer);
            insurer.setInsurerId(insId);
            insurerRepository.save(insurer);
        }
        requestRepository.save(request);
        return "Added quotation - " + request.getVehicleMake() +" " + request.getVehicleModel();
    }
}
