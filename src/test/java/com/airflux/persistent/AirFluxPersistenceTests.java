package com.airflux.persistent;

import com.airflux.server.persistence.bean.Flight;
import com.airflux.server.persistence.repository.FlightRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirFluxPersistenceTests {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void contextLoads() {
        assertThat(flightRepository).isNotNull();
    }

    @Test
    public void flightRepositoryTest(){
        String registration = "FL-001";
        String airportCode = "TXL";
        List<Flight> flights = flightRepository.findAircraftByRegistration(registration);
        List<Flight>  flights1 = flightRepository.findFlightByOrigin(airportCode);
        Assert.assertFalse(flights.isEmpty());
        Assert.assertFalse((flights1.isEmpty()));
    }
}
