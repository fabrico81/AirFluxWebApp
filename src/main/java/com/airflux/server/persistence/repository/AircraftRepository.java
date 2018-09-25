package com.airflux.server.persistence.repository;

import com.airflux.server.persistence.bean.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}
