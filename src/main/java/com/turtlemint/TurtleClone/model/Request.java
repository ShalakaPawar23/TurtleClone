package com.turtlemint.TurtleClone.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Quotations")
public class Request {
    private String vertical;
    private String vehicleMake;
    private String vehicleModel;

    private ArrayList<Insurer> supportedInsurers;

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public ArrayList<Insurer> getSupportedInsurers() {
        return supportedInsurers;
    }

    public void setSupportedInsurers(ArrayList<Insurer> supportedInsurers) {
        this.supportedInsurers = supportedInsurers;
    }
}
