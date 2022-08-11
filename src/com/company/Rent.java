package com.company;

import java.util.Date;

public class Rent {

    //fields
    private int id;
    private Date startDate;
    private Date endDate;
    private int kilometers;
    private String personalIdNumber;
    private String registrationNumber;

    //constructor
    public Rent(Date startDate, Date endDate, int kilometers, String personalIdNumber, String registrationNumber) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.kilometers = kilometers;
        this.personalIdNumber = personalIdNumber;
        this.registrationNumber = registrationNumber;
    }

    //getters
    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getKilometers() {
        return kilometers;
    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", kilometers=" + kilometers +
                ", personalIdNumber='" + personalIdNumber + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
