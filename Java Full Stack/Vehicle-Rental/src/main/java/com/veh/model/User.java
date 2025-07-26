package com.veh.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users") 
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer uid;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    private String password;
    
    @Column(name = "driving_license_no", nullable = false)
    private String drivingLicenseNo;
    private LocalDate licenseExpiry;
    private Double tollBalance;
    private Boolean isActive;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Integer getId() {
        return uid;
    }

    public void setId(Integer id) {
        this.uid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public LocalDate getLicenseExpiry() {
        return licenseExpiry;
    }

    public void setLicenseExpiry(LocalDate licenseExpiry) {
        this.licenseExpiry = licenseExpiry;
    }

    public Double getTollBalance() {
        return tollBalance;
    }

    public void setTollBalance(Double tollBalance) {
        this.tollBalance = tollBalance;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

	@Override
	public String toString() {
		return "User [id=" + uid + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ ", drivingLicenseNo=" + drivingLicenseNo + ", licenseExpiry=" + licenseExpiry + ", tollBalance="
				+ tollBalance + ", isActive=" + isActive + "]";
	}

    
}
