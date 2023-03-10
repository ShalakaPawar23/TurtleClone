package com.turtlemint.TurtleClone.services;

import com.turtlemint.TurtleClone.model.Insurer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InsurerService {
    List<Insurer> getAllInsurers();

    Insurer getInsurerByInsurerId(String insurerId);

    String addInsurer(Insurer insurer);

    Insurer updateInsurer(String insurerId, Insurer insurer);

    void deleteInsurer(String insurerId);
}
