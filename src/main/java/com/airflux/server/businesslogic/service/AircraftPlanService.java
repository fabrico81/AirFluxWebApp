package com.airflux.server.businesslogic.service;

import com.airflux.server.controller.common.Operation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AircraftPlanService {

    List<Operation> findByRegistration(String registration) throws Exception;
}
