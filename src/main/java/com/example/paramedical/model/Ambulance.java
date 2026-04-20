package com.example.paramedical.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ambulance")
public class Ambulance {
    @Id
    @Column(name = "licensePlate")
    private String licensePlate;

    @Column(name = "vehicleModel")
    private String vehicleModel;

    @Column(name = "fuelLevel")
    private Integer fuelLevel;

    public Ambulance() {}

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getVehicleModel() { return vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }

    public Integer getFuelLevel() { return fuelLevel; }
    public void setFuelLevel(Integer fuelLevel) { this.fuelLevel = fuelLevel; }
}