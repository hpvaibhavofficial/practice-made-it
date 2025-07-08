package com.vb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Parking {
	@Override
	public String toString() {
		return "Parking [parkingId=" + parkingId + ", floor=" + floor + ", place=" + place + ", employee=" + employee
				+ "]";
	}

	@SequenceGenerator(name="parkingidseq",initialValue =1102,allocationSize =1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "parkingidseq")
	int parkingId;
	Integer floor;
	Integer place;
	
	@OneToOne
	@JoinColumn(name="empid") // if not given then join coliumsn anme will be emo
	Employee employee; //hIb will add foreign key employee _empid in parking table
	
	
	
	
	public int getParkingId() {
		return parkingId;
	}

	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getPlace() {
		return place;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public Parking(int parkingId, Integer floor, Integer place) {
		super();
		this.parkingId = parkingId;
		this.floor = floor;
		this.place = place;
	}
		
	public Parking() {
		
	}
	
	
}
