package com.airflux.server.persistence.repository;

import com.airflux.server.persistence.bean.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT new Flight(f.idFlight, f.origin, f.destination, f.departure, f.arrival, f.equipment, f.flightTime) FROM #{#entityName} f where f.origin = :origin")
    List<Flight> findFlightByOrigin(@Param("origin") String origin);

    @Query("SELECT new Flight( f.origin, f.destination, f.departure) FROM Flight f INNER JOIN  Aircraft fa on f.aircraft.idAircraft = fa.idAircraft WHERE fa.registration = :registration")
    List<Flight> findAircraftByRegistration(@Param("registration") String registration);
}
