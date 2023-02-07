package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Profile;
import com.turtlemint.TurtleClone.model.Request;
import com.turtlemint.TurtleClone.repository.InsurerRepository;
import com.turtlemint.TurtleClone.repository.ProfileRepository;
import com.turtlemint.TurtleClone.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Override
    public Request getByRequestId(String requestId){
        return requestRepository.getByRequestId(requestId);
    }

    @Override
    public List<Request> getByRequestId(String requestId){
        //use profile repo
        Profile profile = profileRepository.findByRequestId(requestId);
        String vertical = profile.getVertical();
        String vMake = profile.getVehicleMake();
        String vModel = profile.getVehicleModel();
    }

    @Override
    public Request addRequest(Request request){

    }
}
