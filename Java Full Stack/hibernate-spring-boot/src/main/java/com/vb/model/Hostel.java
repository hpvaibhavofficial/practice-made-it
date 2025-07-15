package com.vb.model;

import jakarta.persistence.*;

@Entity
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "allidtable")
    @TableGenerator(name = "allidtable", allocationSize = 1, initialValue = 20)
    private int hostelId;

    private String name;
    
    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hostel(int hostelId, String name) {
        this.hostelId = hostelId;
        this.name = name;
    }

    public Hostel() {
    }

    @Override
    public String toString() {
        return "Hostel [hostelId=" + hostelId + ", name=" + name + "]";
    }
}
