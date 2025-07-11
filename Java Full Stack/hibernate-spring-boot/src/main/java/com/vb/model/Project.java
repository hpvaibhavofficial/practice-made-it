package com.vb.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectid;
    private String client;
    private Date startDate;
    private Date endDate;

    @Column(name = "cost", nullable = false)
    private double cost;

    // Constructors
    public Project() {
        // Default constructor required by JPA
    }

    public Project(int projectid, String client, Date startDate, Date endDate, double cost) {
        this.projectid = projectid;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    // Getters and Setters
    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // toString method
    @Override
    public String toString() {
        return "Project [projectid=" + projectid + ", client=" + client +
               ", startDate=" + startDate + ", endDate=" + endDate +
               ", cost=" + cost + "]";
    }
}
