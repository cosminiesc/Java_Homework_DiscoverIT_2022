package com.company;

public class Vehicle {

    //fields
    private String registrationNumber;
    private Type type;
    private int manufacturingYear;
    private String brand;
    private String colour;

    //constructor
    public Vehicle(String registrationNumber, Type type, int manufacturingYear, String brand, String colour) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.manufacturingYear = manufacturingYear;
        this.brand = brand;
        this.colour = colour;
    }

    //setters
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
