package com.airflux.server.controller.area.flight;

import com.airflux.server.businesslogic.service.AircraftPlanService;
import com.airflux.server.controller.common.Flight;
import com.airflux.server.controller.common.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan("com.airflux.server.businesslogic")
public class AircraftPlanController {

    @Autowired
    private AircraftPlanService aircraftPlanService;

    @RequestMapping(value = "/operationsplan", params = "registration")
    public List<Operation> getFlightPlanByAirport(@RequestParam String registration) throws Exception {

        List<Operation> operation = aircraftPlanService.findByRegistration(registration);
        return operation;
    }
}
