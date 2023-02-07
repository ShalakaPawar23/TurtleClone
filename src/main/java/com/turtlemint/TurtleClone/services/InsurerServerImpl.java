package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Insurer;
import com.turtlemint.TurtleClone.repository.InsurerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class InsurerServerImpl implements InsurerService {

    @Autowired
    private InsurerRepository insurerRepository;

    @Override
    public List<Insurer> getAllInsurers(){
        return insurerRepository.findAll();
    }

    @Override
    public Insurer getInsurerByInsurerId(String insurerId){
        return insurerRepository.findByInsurerId(insurerId);
    }

    @Override
    public void addInsurer(Insurer insurer){
        insurerRepository.save(insurer);
    }

    @Override
    public Insurer updateInsurer(String insurerId, Insurer insurer){
        Insurer insurer1 = insurerRepository.findByInsurerId(insurerId);

        if(Objects.nonNull(insurer.getInsurerName()) && !"".equalsIgnoreCase(insurer.getInsurerName())){
            insurer1.setInsurerName(insurer.getInsurerName());
        }

        if(Objects.nonNull(insurer.getPremium()) && !"".equalsIgnoreCase(insurer.getPremium())){
            insurer1.setPremium(insurer.getPremium());
        }

        insurerRepository.save(insurer1);
        return insurer1;
    }

    @Override
    public void deleteInsurer(String insurerId) {
        insurerRepository.deleteById(insurerId);
    }
}
