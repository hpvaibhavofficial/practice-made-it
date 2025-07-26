package com.veh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veh.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

}
