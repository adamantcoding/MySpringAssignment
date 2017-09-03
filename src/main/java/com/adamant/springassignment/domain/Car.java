package com.adamant.springassignment.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ivan.
 */
@Entity
@Table
public class Car {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    private String vehicleID;
    @OneToOne
    @JoinColumn
    private CarModel carModel;
    private String color;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private CarOwner carOwner;

    public Car(){}
    public Car(CarModel model, String vehicleID, String color, Double price) {
        this.carModel = model;
        this.vehicleID = vehicleID;
        this.color = color;
        this.price = price;
    }

    public Car(CarModel model, String vehicleID, String color, Double price, CarOwner carOwner) {
        this.carModel = model;
        this.vehicleID = vehicleID;
        this.color = color;
        this.price = price;
        this.carOwner = carOwner;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", vehicleID='" + vehicleID + '\'' +
                ", carModel=" + carModel +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }


}