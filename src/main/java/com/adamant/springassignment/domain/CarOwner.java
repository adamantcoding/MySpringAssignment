package com.adamant.springassignment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ivan.
 */
@Entity
@Table
public class CarOwner {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    @OneToMany(mappedBy = "carOwner")
    @JsonIgnore
    private List<Car> carsOwned;

    public CarOwner(){}
    public CarOwner(String firstName, String lastName, Date birthDay, List<Car> carsOwned) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.carsOwned = carsOwned;
    }

    public CarOwner(String name, String lastName, Date birthDate) {
        this.firstName = name;
        this.lastName = lastName;
        this.birthDay = birthDate;
    }

    public Long getId(){
        return this.id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Collection<Car> getCarsOwned() {
        return carsOwned;
    }

    public void setCarsOwned(List<Car> carsOwned) {
        this.carsOwned = carsOwned;
    }
}