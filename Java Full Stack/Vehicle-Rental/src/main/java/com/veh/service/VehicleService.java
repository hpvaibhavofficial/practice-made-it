package com.veh.service;

import com.veh.model.Vehicle;
import com.veh.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Integer id) {
        return vehicleRepository.findById(id);
    }

    public void deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);
    }

    public Vehicle updateVehicle(Integer id, Vehicle updatedVehicle) {
        Optional<Vehicle> existing = vehicleRepository.findById(id);
        if (existing.isPresent()) {
            Vehicle vehicle = existing.get();

            vehicle.setVehicleNumber(updatedVehicle.getVehicleNumber());
            vehicle.setBrand(updatedVehicle.getBrand());
            vehicle.setModel(updatedVehicle.getModel());
            vehicle.setType(updatedVehicle.getType());
            vehicle.setFuelType(updatedVehicle.getFuelType());
            vehicle.setSeatingCapacity(updatedVehicle.getSeatingCapacity());
            vehicle.setRentPerDay(updatedVehicle.getRentPerDay());
            vehicle.setAvailable(updatedVehicle.getAvailable());

            return vehicleRepository.save(vehicle);
        } else {
            throw new RuntimeException("Vehicle not found with ID: " + id);
        }
    }
}
