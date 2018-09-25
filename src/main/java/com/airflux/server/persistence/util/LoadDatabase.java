package com.airflux.server.persistence.util;

import com.airflux.server.persistence.bean.Aircraft;
import com.airflux.server.persistence.bean.Flight;
import com.airflux.server.persistence.repository.AircraftRepository;
import com.airflux.server.persistence.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j

/*   TXL
                ===================
        10:00 TXL MUC 01:00
        15:00 TXL MUC 01:00
        16:00 TXL MUC 01:00
        18:00 TXL MUC 01:00
        21:00 TXL HAM 00:40
        MUC
                ===================
        10:00 MUC LHR 02:00
        13:00 MUC TXL 01:00
        15:00 MUC TXL 01:00
        15:30 MUC LHR 02:00
        17:30 MUC HAM 01:00
        18:00 MUC LHR 02:30
        20:00 MUC LHR 02:00
        22:00 MUC TXL 01:00
        LHR
                ===================
        09:00 LHR HAM 02:30
        12:00 LHR TXL 02:00
        17:00 LHR TXL 02:00
        20:30 LHR MUC 02:00
        HAM
                ===================
        10:00 HAM MUC 01:00
        13:00 HAM MUC 01:00
        20:00 HAM MUC 01:00

        Boeing 737 – Berlin, registration FL-0001
        Airbus A321 – Munich, registration FL-0002
        Boeing 747-400 – London, registration FL-0003
        Airbus A320 - Hamburg, registration FL-0004
*/


public class LoadDatabase {

    Aircraft aircraftBerlin = new Aircraft(1L,"Boeing", "737", "","","FL-001","Berlin");
    Aircraft aircraftMunich = new Aircraft(2L,"Airbus", "A321", "","","FL-0002","Munich");
    Aircraft aircraftLondon = new Aircraft(3L,"Boeing", "747-400", "", "", "FL-003", "London");
    Aircraft aircraftHamburg = new Aircraft(4L,"Airbus", "A320", "", "", "FL-004","Hamburg");

    Flight flightBerlin = new Flight(1L,"TXL", "MUC","10:00", "", "737","60", aircraftBerlin);
    Flight flightBerlin1 = new Flight(2L,"TXL", "MUC","15:00", "", "737","60", aircraftBerlin);
    Flight flightBerlin2 = new Flight(3L,"TXL", "MUC","16:00", "", "737","60", aircraftBerlin);
    Flight flightBerlin3 = new Flight(4L,"TXL", "MUC","18:00", "", "737","60", aircraftBerlin);
    Flight flightBerlin4 = new Flight(5L,"TXL", "HAM","21:00", "", "737","40", aircraftBerlin);

//    Flight flightMunich = new Flight("MUC", "LHR","00:00", "", "A321","120");
//    Flight flightMunich1 = new Flight("MUC", "TXL","13:00", "", "A321","60");
//    Flight flightMunich2 = new Flight("MUC", "TXL","15:00", "", "A321","60");
//    Flight flightMunich3 = new Flight("MUC", "LHR","15:30", "", "A321","120");
//    Flight flightMunich4 = new Flight("MUC", "HAM","17:30", "", "A321","60");
//    Flight flightMunich5 = new Flight("MUC", "LHR","18:00", "", "A321","180");
//    Flight flightMunich6 = new Flight("MUC", "LHR","20:00", "", "A321","120");
//    Flight flightMunich7 = new Flight("MUC", "TXL","22:00", "", "A321","60");
//
//    Flight flightLondon = new Flight("LHR", "HAM","09:00", "", "747-400","180");
//    Flight flightLondon1 = new Flight("LHR", "TXL","12:00", "", "747-400","120");
//    Flight flightLondon2 = new Flight("LHR", "TXL","17:00", "", "747-400","120");
//    Flight flightLondon3 = new Flight("LHR", "MUC","20:30", "", "747-400","120");
//
//    Flight flightHamburg = new Flight("HAM", "MUC","10:00", "", "A320","60");
//    Flight flightHamburg1 = new Flight("HAM", "MUC","13:00", "", "A320","60");
//    Flight flightHamburg2 = new Flight("HAM", "MUC","20:00", "", "A320","60");


    @Bean
    CommandLineRunner initDatabase(FlightRepository flightrepository, AircraftRepository aircraftRepository) {
        return args -> {

            log.info("Preloading " + aircraftRepository.save(aircraftBerlin));
            log.info("Preloading " + aircraftRepository.save(aircraftHamburg));
            log.info("Preloading " + aircraftRepository.save(aircraftLondon));
            log.info("Preloading " + aircraftRepository.save(aircraftMunich));

            log.info("Preloading " + flightrepository.save(flightBerlin));
            log.info("Preloading " + flightrepository.save(flightBerlin1));
            log.info("Preloading " + flightrepository.save(flightBerlin2));
            log.info("Preloading " + flightrepository.save(flightBerlin3));
            log.info("Preloading " + flightrepository.save(flightBerlin4));

//            log.info("Preloading " + flightrepository.save(flightMunich));
//            log.info("Preloading " + flightrepository.save(flightMunich1));
//            log.info("Preloading " + flightrepository.save(flightMunich2));
//            log.info("Preloading " + flightrepository.save(flightMunich3));
//            log.info("Preloading " + flightrepository.save(flightMunich4));
//            log.info("Preloading " + flightrepository.save(flightMunich5));
//            log.info("Preloading " + flightrepository.save(flightMunich6));
//            log.info("Preloading " + flightrepository.save(flightMunich7));
//
//            log.info("Preloading " + flightrepository.save(flightLondon));
//            log.info("Preloading " + flightrepository.save(flightLondon1));
//            log.info("Preloading " + flightrepository.save(flightLondon2));
//            log.info("Preloading " + flightrepository.save(flightLondon3));
//
//            log.info("Preloading " + flightrepository.save(flightHamburg));
//            log.info("Preloading " + flightrepository.save(flightHamburg1));
//            log.info("Preloading " + flightrepository.save(flightHamburg2));
//            log.info("Preloading " + flightrepository.save(flightHamburg));
        };
    }
}


