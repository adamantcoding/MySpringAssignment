package com.adamant.springassignment.domain;

import javax.persistence.*;

/**
 * Created by Ivan.
 */
@Entity
@Table
public class CarModel {
    @Id @GeneratedValue
    private Long id;
    private String manufacturer;
    private String model;
    private String transmissionType;
    private String fuelType;
    private Integer horsepower;
    private Integer modelYear;

    public CarModel(){}

    public CarModel(String manufacturer, String model, String transmissionType, String fuelType, Integer horsepower, Integer modelYear) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
        this.horsepower = horsepower;
        this.modelYear = modelYear;
    }

    public Long getId(){
        return this.id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", horsepower=" + horsepower +
                ", modelYear=" + modelYear +
                '}';
    }
}