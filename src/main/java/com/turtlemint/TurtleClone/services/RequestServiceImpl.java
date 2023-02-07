package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Profile;
import com.turtlemint.TurtleClone.model.Request;
import com.turtlemint.TurtleClone.repository.InsurerRepository;
import com.turtlemint.TurtleClone.repository.ProfileRepository;
import com.turtlemint.TurtleClone.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

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
    public Request getByRequestId(String requestId){
        //use profile repo
        Profile profile = profileRepository.findByRequestId(requestId);
        String vertical = profile.getVertical();
        String vMake = profile.getVehicleMake();
        String vModel = profile.getVehicleModel();

        return requestRepository.findByVehicleMakeandVehicleModel(vMake, vModel);
    }


    // have not checked if already present
    @Override
    public String addRequest(Request request){
        requestRepository.insert(request);
        return "Added quotation - " + request.getVehicleMake() +" " + request.getVehicleModel();
    }
}
