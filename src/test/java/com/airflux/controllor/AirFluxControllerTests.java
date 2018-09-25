package com.airflux.controllor;

import com.airflux.server.controller.area.flight.FlightPlanController;
import static org.assertj.core.api.Assertions.assertThat;

import com.airflux.server.controller.area.flight.AircraftPlanController;
import com.airflux.server.persistence.repository.FlightRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirFluxControllerTests {

	@Autowired
	private FlightPlanController flightPlanController;

	@Autowired
	private AircraftPlanController operationPlanController;

	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void contextLoads() {
		assertThat(flightPlanController).isNotNull();
		assertThat(operationPlanController).isNotNull();
		assertThat(flightRepository).isNotNull();

	}

}
