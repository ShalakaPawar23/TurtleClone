package com.turtlemint.TurtleClone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Insurer")
public class Insurer {
    @Id
    private String insurerId;
    private String insurerName;
    private String premium;

    public Insurer(String insurerName, String premium) {
        this.insurerName = insurerName;
        this.premium = premium;
    }

    public String getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(String insurerId) {
        this.insurerId = insurerId;
    }

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }
}
