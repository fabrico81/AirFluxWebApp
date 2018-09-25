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
                String arrival = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime.plusMinutes(Long.valueOf(minute)));
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

//    private ZonedDateTime getZonedDateTime(String hour, String minute) {
//        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(Integer.valueOf(hour), Integer.valueOf(minute)));
//        return ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Berlin"));
//    }
//
//    private String[] getTimeSplit(String time) throws Exception{
//        try{
//            if(time != null && !time.isEmpty()){
//                String departureTime = time;
//                return departureTime.split(":");
//            }else {
//                log.debug("Time is empty or null");
//                return null;
//            }
//
//        }catch (IllegalFormatException ex){
//            log.debug(ex.getMessage());
//            throw ex;
//        }
//    }
//
//    private String getHour(String[] hour){
//        if(hour != null && hour.length != 0)
//            return hour[0];
//        else{
//            log.debug("Hour null 0r empty");
//            return null;
//        }
//    }
//
//    private String getMinute(String[] minute){
//        if(minute != null && minute.length != 0 )
//            return minute[1];
//        else{
//            log.debug("Minute null 0r empty");
//            return null;
//        }
//    }
}
