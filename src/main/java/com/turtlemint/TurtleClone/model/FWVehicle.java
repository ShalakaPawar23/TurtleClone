package com.turtlemint.TurtleClone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FWVehicle")
public class FWVehicle {
    @Id
    private String requestId;
    private String vertical;
    private String vehicleMake;
    private String vehicleModel;

    public FWVehicle(String vertical, String vehicleMake, String vehicleModel){
        this.vertical = vertical;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

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
}
