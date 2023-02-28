package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.FWVehicle;
import com.turtlemint.TurtleClone.model.Insurer;
import com.turtlemint.TurtleClone.model.Profile;
import com.turtlemint.TurtleClone.model.Quotation;
import com.turtlemint.TurtleClone.repository.FWVehicleRepository;
import com.turtlemint.TurtleClone.repository.InsurerRepository;
import com.turtlemint.TurtleClone.repository.ProfileRepository;
import com.turtlemint.TurtleClone.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private QuotationRepository QuotationRepository;

    @Autowired
    private ProfileService profileService;
    @Autowired
    private FWVehicleRepository fwVehicleRepository;

    @Autowired
    private InsurerService insurerService;
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private InsurerRepository insurerRepository;


    @Override
    public List<Quotation> getAllQuotations(){
        return QuotationRepository.findAll();
    }

    // input = requestid
    // fetch the vehicle make and model and find by them
    @Override
    public List<Quotation> searchByRequestId(String requestId){
        String vMake = null, vModel = null, vertical = null;
        //use profile repo
        Profile profile = profileRepository.findByRequestId(requestId);
        if (profile != null) {
            vertical = profile.getVertical();
            vMake = profile.getVehicleMake();
            vModel = profile.getVehicleModel();
        }
        FWVehicle fwVehicle = fwVehicleRepository.findByRequestId(requestId);
        if (fwVehicle != null){
            vertical = fwVehicle.getVertical();
            vMake = fwVehicle.getVehicleMake();
            vModel = fwVehicle.getVehicleModel();
        }
        if (profile == null && fwVehicle == null)
            return null;
        return QuotationRepository.findByVehicleMakeAndVehicleModel(vMake, vModel);
    }

    @Override
    public String addQuotation(Quotation quotation){
        String reqId = new String();
        if(quotation.getVertical().equalsIgnoreCase("TW")){
            Profile profile = new Profile(quotation.getVertical(), quotation.getVehicleMake(), quotation.getVehicleModel());
            System.out.println("Profile created");
            reqId = profileService.addProfile(profile);
            System.out.println("profile added " + reqId);
            for(int i=0; i<quotation.getSupportedInsurers().size(); i++) {
                Insurer insurer = new Insurer(quotation.getSupportedInsurers().get(i).getName(), quotation.getSupportedInsurers().get(i).getPremium());
                String insId = insurerService.addInsurer(insurer);
                insurer.setInsurerId(insId);
                quotation.getSupportedInsurers().get(i).setInsurerId(insId);
                insurerRepository.save(insurer);
            }
        }
        else if (quotation.getVertical().equalsIgnoreCase("FW")){
            FWVehicle fwVehicle = new FWVehicle(quotation.getVertical(), quotation.getVehicleMake(), quotation.getVehicleModel());
            reqId = profileService.addFWVehicle(fwVehicle);
            for(int i=0; i<quotation.getSupportedInsurers().size(); i++) {
                Insurer insurer = new Insurer(quotation.getSupportedInsurers().get(i).getName(), quotation.getSupportedInsurers().get(i).getPremium());
                String insId = insurerService.addInsurer(insurer);
                insurer.setInsurerId(insId);
                quotation.getSupportedInsurers().get(i).setInsurerId(insId);
                insurerRepository.save(insurer);
            }
        }
        QuotationRepository.save(quotation);
        //return "Added quotation - " + quotation.getVehicleMake() +" " + quotation.getVehicleModel();
        return reqId;
    }
}
