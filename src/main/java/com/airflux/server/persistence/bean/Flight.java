package com.airflux.server.persistence.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="flight")
public class Flight {
    @Column
    private @Id Long idFlight;
    @Column
    private String origin;
    @Column
    private String destination;
    @Column
    private String departure;
    @Column
    private String arrival;
    @Column
    private String equipment;
    @Column
    private String flightTime;

//    private Long idAircraft;

    @ManyToOne
    @JoinColumn(name="idAircraft",insertable=true,updatable=true,nullable = false)
    private Aircraft aircraft;

    public Flight(String origin, String destination, String departure){
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setDeparture(departure);

    }

    public Flight(Long idFlight, String origin, String destination, String departure, String arrival,
                  String equipment, String flightTime){
        this.setIdFlight(idFlight);
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setDeparture(departure);
        this.setArrival(arrival);
        this.setEquipment(equipment);
        this.setFlightTime(flightTime);
    }
    public Flight(Long idFlight, String origin, String destination, String departure, String arrival,
                  String equipment, String flightTime, Aircraft aircraft){
        this.setIdFlight(idFlight);
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setDeparture(departure);
        this.setArrival(arrival);
        this.setEquipment(equipment);
        this.setFlightTime(flightTime);
        this.setAircraft(aircraft);
    }

//    public Flight(Long idFlight, String origin, String destination, String departure, String arrival,
//                  String equipment, String flightTime, Long idAircraft){
//        this.setIdFlight(idFlight);
//        this.setOrigin(origin);
//        this.setDestination(destination);
//        this.setDeparture(departure);
//        this.setArrival(arrival);
//        this.setEquipment(equipment);
//        this.setFlightTime(flightTime);
//        this.setIdAircraft(idAircraft);
//    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

//    public Long getIdAircraft() {
//        return idAircraft;
//    }
//
//    public void setIdAircraft(Long IdAircraft) {
//        this.idAircraft = IdAircraft;
//    }

    public Long getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Long idFlight) {
        this.idFlight = idFlight;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
