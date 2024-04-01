package com.example.graphdemo.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Event {
    @Id
    private Integer id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate cfpStartDate;
    private LocalDate cfpEndDate;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", cfpStartDate=" + cfpStartDate +
                ", cfpEndDate=" + cfpEndDate +
                ", location='" + location + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCfpStartDate(LocalDate cfpStartDate) {
        this.cfpStartDate = cfpStartDate;
    }

    public void setCfpEndDate(LocalDate cfpEndDate) {
        this.cfpEndDate = cfpEndDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getCfpStartDate() {
        return cfpStartDate;
    }

    public LocalDate getCfpEndDate() {
        return cfpEndDate;
    }

    public String getLocation() {
        return location;
    }

    public String getWebsite() {
        return website;
    }

    public Event() {
    }

    private String location;

    public Event(Integer id, String name, String description, LocalDate startDate, LocalDate endDate, LocalDate cfpStartDate, LocalDate cfpEndDate, String location, String website) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cfpStartDate = cfpStartDate;
        this.cfpEndDate = cfpEndDate;
        this.location = location;
        this.website = website;
    }

    private String website;
}

