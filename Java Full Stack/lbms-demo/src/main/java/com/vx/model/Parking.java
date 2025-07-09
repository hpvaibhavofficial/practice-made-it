package com.vx.model;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Parking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	int pid;
	String slotNum;
	Integer floor;
	Boolean isOccupied;
	String vno;
	Time allocatedTime;
	
	
	public Parking() {
		// TODO Auto-generated constructor stub
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getSlotNum() {
		return slotNum;
	}

	public void setSlotNum(String slotNum) {
		this.slotNum = slotNum;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Boolean getIsOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(Boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public String getVno() {
		return vno;
	}

	public void setVno(String vno) {
		this.vno = vno;
	}

	public Time getAllocatedTime() {
		return allocatedTime;
	}

	public void setAllocatedTime(Time allocatedTime) {
		this.allocatedTime = allocatedTime;
	}

	@Override
	public String toString() {
		return "Parking [pid=" + pid + ", slotNum=" + slotNum + ", floor=" + floor + ", isOccupied=" + isOccupied
				+ ", vno=" + vno + ", allocatedTime=" + allocatedTime + "]";
	}
}
