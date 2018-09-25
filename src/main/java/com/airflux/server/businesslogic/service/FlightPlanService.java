package com.airflux.server.businesslogic.service;

import com.airflux.server.controller.common.Flight;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FlightPlanService {

    List<Flight> getFlightPlan() throws Exception;
    List<Flight> findByAirport(String airportCode) throws Exception;
}
