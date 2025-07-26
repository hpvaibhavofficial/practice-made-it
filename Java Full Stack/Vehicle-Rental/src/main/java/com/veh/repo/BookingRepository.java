package com.veh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veh.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
