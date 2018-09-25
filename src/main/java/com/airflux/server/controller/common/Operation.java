package com.airflux.server.controller.common;

public class Operation {

    private String origin;
    private String destination;
    private String departure;

    public Operation(String origin, String destination, String departure) {
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
    }

    public Operation(){
        super();
    }
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
}
