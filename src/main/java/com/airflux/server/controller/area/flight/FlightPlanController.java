package com.airflux.server.controller.area.flight;


import com.airflux.server.businesslogic.service.FlightPlanService;
import com.airflux.server.controller.common.Flight;
import com.airflux.server.persistence.repository.AircraftRepository;
import com.airflux.server.persistence.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan("com.airflux.server.businesslogic")
public class FlightPlanController {

    @Autowired
    FlightPlanService flightPlanService;

    @RequestMapping(value = "/flightplan")
    public List<Flight> getFlightPlan() throws Exception {
        List<Flight> flights = flightPlanService.getFlightPlan();
        return flights;
    }

    @RequestMapping(value = "/flightplan", params = "airport")
    public List<Flight> getFlightPlanByAirport(@RequestParam String airport) throws Exception {

        List<Flight> flights = flightPlanService.findByAirport(airport);
        return flights;
    }
}
