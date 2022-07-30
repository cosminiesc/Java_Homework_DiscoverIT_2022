package com.company;

public class Person {

    //fields
    private String personalIdentificationNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private Gender gender;
    private int emittedYearOfDriverLicense;

    //constructor
    public Person(String personalIdentificationNumber, String firstName, String lastName, String dateOfBirth,Gender gender, int emittedYearOfDriverLicense) {
        this.personalIdentificationNumber = personalIdentificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender=gender;
        this.emittedYearOfDriverLicense = emittedYearOfDriverLicense;
    }

    //setters
    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setEmittedYearOfDriverLicense(int emittedYearOfDriverLicense) {
        this.emittedYearOfDriverLicense = emittedYearOfDriverLicense;
    }
}

