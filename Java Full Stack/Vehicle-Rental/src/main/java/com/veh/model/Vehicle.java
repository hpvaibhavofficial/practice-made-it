package com.veh.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Vehicle{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vid;

    @Column(unique = true, nullable = false)
    private String vehicleNumber;
    private String brand;
    private String model;
    private String type;
    private String fuelType; 
    private Integer seatingCapacity;
    private Double rentPerDay;
    private Boolean available;
    
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Integer getId() {
        return vid;
    }

    public void setId(Integer id) {
        this.vid = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Double getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(Double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

	@Override
	public String toString() {
		return "Vehicle [id=" + vid + ", vehicleNumber=" + vehicleNumber + ", brand=" + brand + ", model=" + model
				+ ", type=" + type + ", fuelType=" + fuelType + ", seatingCapacity=" + seatingCapacity + ", rentPerDay="
				+ rentPerDay + ", available=" + available + ", bookings=" + bookings + "]";
	}
    
    
}
