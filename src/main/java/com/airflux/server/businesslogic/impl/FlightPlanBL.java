package com.airflux.server.businesslogic.impl;

import com.airflux.server.businesslogic.service.FlightPlanService;
import com.airflux.server.controller.common.Flight;
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
public class FlightPlanBL implements FlightPlanService {

    private static final Log log = LogFactory.getLog(FlightPlanBL.class);
    FlightRepository flightRepository;
    AircraftRepository aircraftRepository;

    public FlightPlanBL(FlightRepository flightRepository, AircraftRepository aircraftRepository) {
        this.flightRepository = flightRepository;
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public List<Flight> getFlightPlan() throws Exception {

        try {
            Iterable<com.airflux.server.persistence.bean.Flight> flights = flightRepository.findAll();
            List<Flight> flightsController = new ArrayList<>();

            for (com.airflux.server.persistence.bean.Flight flight: flights) {
                Flight flightController = new Flight();

                flightController.setDestination(flight.getDestination());
                flightController.setOrigin(flight.getOrigin());
                flightController.setEquipment(flight.getEquipment());

                String[] timeSplit = getTimeSplit(flight.getDeparture());

                String hour = getHour(timeSplit);
                String minute = getMinute(timeSplit);

                ZonedDateTime zonedDateTime = getZonedDateTime(hour, minute);

                String departure = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime);
                String arrival = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime.plusMinutes(Long.valueOf(flight.getFlightTime())));
                flightController.setDeparture(departure);

                flightController.setArrival(arrival);
                flightController.setFlightTime( flight.getFlightTime());
                flightsController.add(flightController);
            }
            return flightsController;

        }catch (Exception ex){
            log.error(ex);
            throw ex;
        }
    }

    public List<Flight> findByAirport(String airportCode) throws Exception {

        List<Flight> flightsController = new ArrayList<>();
        List<com.airflux.server.persistence.bean.Flight> flights = flightRepository.findFlightByOrigin(airportCode);

        for (com.airflux.server.persistence.bean.Flight flight : flights ) {
            Flight flightController = new Flight();

            flightController.setDestination(flight.getDestination());
            flightController.setOrigin(flight.getOrigin());
            flightController.setEquipment(flight.getEquipment());
            String[] timeSplitDeparture = getTimeSplit(flight.getDeparture());
            String hourDeparture = getHour(timeSplitDeparture);
            String minutesDeparture = getMinute(timeSplitDeparture);
            ZonedDateTime zonedDateTimeDeparture = getZonedDateTime(hourDeparture, minutesDeparture);
            String departure = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTimeDeparture);
            String arrival = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTimeDeparture.plusMinutes(Long.valueOf(flight.getFlightTime())));
            flightController.setDeparture(departure);
            flightController.setArrival(arrival);
            flightController.setFlightTime( flight.getFlightTime());
            flightsController.add(flightController);
        }
        return flightsController;
    }
}
