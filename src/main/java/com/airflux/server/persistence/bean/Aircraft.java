package com.airflux.server.persistence.bean;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="aircraft")
public class Aircraft {

    private @Id Long idAircraft;
    private String name;
    private String equipment;
    private String code;
    private String description;
    private String registration;
    private String city;

    public Aircraft(Long idAircraft, String name, String equipment, String code,
                    String description, String registration, String city){

        this.setIdAircraft(idAircraft);
        this.setName(name);
        this.setEquipment(equipment);
        this.setCode(code);
        this.setDescription(description);
        this.setRegistration(registration);
        this.setCity(city);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getIdAircraft() {
        return idAircraft;
    }

    public void setIdAircraft(Long idAircraft) {
        this.idAircraft = idAircraft;
    }
}
