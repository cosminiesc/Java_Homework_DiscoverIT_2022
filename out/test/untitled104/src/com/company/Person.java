package com.company;

public class Person {

    //fields
    private String personalIdentificationNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private Gender gender;
    private int emittedYearOfDriverLicense;

    //constructors
    public Person(String personalIdentificationNumber, String firstName, String lastName, String dateOfBirth,Gender gender, int emittedYearOfDriverLicense) {
        this.personalIdentificationNumber = personalIdentificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender=gender;
        this.emittedYearOfDriverLicense = emittedYearOfDriverLicense;
    }

    public Person(String personalIdentificationNumber, String firstName, String lastName, Gender gender, int emittedYearOfDriverLicense) {
        this.personalIdentificationNumber = personalIdentificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.emittedYearOfDriverLicense = emittedYearOfDriverLicense;
    }

    //setters
    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getEmittedYearOfDriverLicense() {
        return emittedYearOfDriverLicense;
    }

    public void setEmittedYearOfDriverLicense(int emittedYearOfDriverLicense) {
        this.emittedYearOfDriverLicense = emittedYearOfDriverLicense;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personalIdentificationNumber='" + personalIdentificationNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", emittedYearOfDriverLicense=" + emittedYearOfDriverLicense +
                '}';
    }
}

