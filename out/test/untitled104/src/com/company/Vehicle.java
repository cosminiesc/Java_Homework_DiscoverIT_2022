package com.company;

import java.util.Comparator;

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

    //getters
    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public String getBrand() {
        return brand;
    }

    public Type getType() {
        return type;
    }

    /*
    //classes used in sorting the allVehicles in Main
    public  static class ManufacturingYearComparator implements Comparator<Vehicle>
    {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            return v1.getManufacturingYear()- v2.getManufacturingYear();
        }
    }
    public static class BrandComparator implements  Comparator<Vehicle>
    {

        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            return v1.getBrand().compareTo(v2.getBrand());
        }
    }
    public static class TypeComparator implements Comparator<Vehicle>
    {

        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            return v1.getType().compareTo(v2.getType());
        }
    }
    */

    //shows each element from allVehicles in a structured way

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", type=" + type +
                ", manufacturingYear=" + manufacturingYear +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
