package com.airflux.server.businesslogic.impl;

import com.airflux.server.businesslogic.service.AircraftPlanService;
import com.airflux.server.controller.common.Operation;
import com.airflux.server.persistence.repository.AircraftRepository;
import com.airflux.server.persistence.repository.FlightRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.airflux.server.businesslogic.Util.Util.*;

@Component
public class AircraftPlanBL implements AircraftPlanService {

    private static final Log log = LogFactory.getLog(AircraftPlanBL.class);
    FlightRepository flightRepository;
    AircraftRepository aircraftRepository;

    public AircraftPlanBL(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Operation> findByRegistration(String registration) throws Exception{

        try {
            List<com.airflux.server.persistence.bean.Flight> flights = flightRepository.findAircraftByRegistration(registration);
            List<Operation> operationsController = new ArrayList<>();
            for (com.airflux.server.persistence.bean.Flight flight: flights) {

                String[] timeSplit = getTimeSplit(flight.getDeparture());
                String hour = getHour(timeSplit);
                String minute = getMinute(timeSplit);
                ZonedDateTime zonedDateTime = getZonedDateTime(hour, minute);
                String departure = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime);

                Operation operationController = new Operation();
                operationController.setDeparture(departure);
                operationController.setDestination(flight.getDestination());
                operationController.setOrigin(flight.getOrigin());

//                Operation operationController = new Operation(flight.getOrigin(), flight.getDestination(), departure);

                operationsController.add(operationController);
            }
            return operationsController;

        }catch (Exception ex){
            log.error(ex);
            throw ex;
        }
    }
}
