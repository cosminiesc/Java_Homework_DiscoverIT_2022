package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        List<Vehicle> allVehicles = new ArrayList<>();
        List<Person> allPeople = new ArrayList<>();
        List<Rent> allRents = new ArrayList<>();

        addVehiclesFromFile(allVehicles);
        addPeopleFromFile(allPeople);
        addRentsFromFile(allRents);

        //---DATABASE---
        Connection connection=null;
        PreparedStatement prst=null;
        Statement stm=null;
        ResultSet resultSet=null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rents","root","Informatica123*");
            System.out.println("\nThe database connection has been successfully created!\n");

            /*stm=connection.createStatement();
            int rowAffected= stm.executeUpdate("DELETE FROM rent");
            System.out.println("Number of rows affected: " + rowAffected);*/

            /*prst=connection.prepareStatement("INSERT INTO rent (startDate, endDate, kilometers, persIDNum, regNum) VALUES (?,?,?,?,?)");
            for(Rent currentRent : allRents){
                prst.setObject(1, currentRent.getStartDate());
                prst.setObject(2, currentRent.getEndDate());
                prst.setInt(3,currentRent.getKilometers());
                prst.setString(4,currentRent.getPersonalIdNumber());
                prst.setString(5,currentRent.getRegistrationNumber());
                prst.executeUpdate();
            }*/

            prst=connection.prepareStatement("INSERT INTO person (pin, fName, lName, dateOfBirth, emmitedYearOfLic) VALUES (?,?,?,?,?)");
            for(Person currentPerson : allPeople){
                prst.setString(1, currentPerson.getPersonalIdentificationNumber());
                prst.setString(2, currentPerson.getFirstName());
                prst.setString(3,currentPerson.getLastName());
                prst.setString(4,currentPerson.getDateOfBirth());
                prst.setInt(5,currentPerson.getEmittedYearOfDriverLicense());
                prst.executeUpdate();
            }
            /*stm=connection.createStatement();
            resultSet=  stm.executeQuery("SELECT * FROM rent");
            while (resultSet.next()){
                System.out.println("ID:" + resultSet.getString("id")
                        +" Person ID:" + resultSet.getString("persIDNum")
                        +" Start date:" + resultSet.getString("startDate")
                        +" End date:" + resultSet.getString("endDate")
                        +" Kilometers:" + resultSet.getString("kilometers")
                        +" Registration number:" + resultSet.getString("regNum"));

            }*/


        }
            catch(SQLException e){
            e.printStackTrace();
        }
        finally {

            try {
                if(resultSet!=null){
                    resultSet.close();
                }
                if(prst!=null){
                    prst.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        showMenu();

        int choice=validationInput();

        switch (choice)
        {
            case 1:
            {
                /*Collections.sort(allVehicles,new Vehicle.ManufacturingYearComparator());*/

                List<Vehicle> sortedVehiclesByYear=allVehicles.stream()
                        .sorted(Comparator.comparing(Vehicle::getManufacturingYear))
                        .collect(Collectors.toList());
                showAllVehicle(sortedVehiclesByYear);
                break;
            }
            case 2:
            {
                /*Collections.sort(allVehicles,new Vehicle.BrandComparator());*/

                List<Vehicle> sortedVehiclesByBrand=allVehicles.stream()
                        .sorted(Comparator.comparing((Vehicle::getBrand)))
                        .collect(Collectors.toList());

                showAllVehicle(sortedVehiclesByBrand);
                break;
            }
            case 3:
            {

                for(Rent currentRent : allRents){
                    System.out.println(currentRent);
                }
                break;

            }
            case 4:
            {
                System.out.println("What type of vehicles do you want to search?");
                String desiredType = scan.nextLine();

                List<Vehicle> sortedVehiclesByType=allVehicles.stream()
                        .sorted(Comparator.comparing(Vehicle::getType))
                        .collect(Collectors.toList());

                for(Vehicle currentVehicle : sortedVehiclesByType ) {

                    if(currentVehicle.getType().toString().equals(desiredType)) {

                        System.out.println(currentVehicle);
                    }
                }
                break;
            }
            case 5:
            {
                System.out.println("\nIt is going to be implemented -5 ...");
                break;
            }
            case 6:
            {
                System.out.println("\nIt is going to be implemented -6 ...");
                break;
            }
            case 7:
            {
                System.out.println("\nIt is going to be implemented -7 ...");
                break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("Hello! \nThis is your menu:");
        System.out.println(" 1. View all the vehicles sorted by manufacturing year");
        System.out.println(" 2. View all the vehicles sorted by manufacturing brand");
        System.out.println(" 3. View the historic of all the rented vehicles and their users");
        System.out.println(" 4. Search for a vehicle by type");
        System.out.println(" 5. View the historic of all the rented vehicles  and their users");
        System.out.println(" 6. Rent a vehicle");
        System.out.println(" 7. View all the rented vehicles of a specific user");
    }

    public static int validationInput() {
        boolean isValid;
        int numberTries = -1;
        int input = 0;

        do {
            try {
                isValid = true;

                numberTries++;

                if (numberTries > 0) {
                    System.out.println("Please insert a valid number!");
                }
                System.out.println("\nInsert your number choice: ");
                input = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                isValid = false;
            }
        }
        while ((input < 0) || (input > 7) || (!isValid));

        return  input;
    }

    public static void showAllVehicle(List<Vehicle> allVehicles) {
        for(Vehicle currentVehicle : allVehicles)
        {
            System.out.println(currentVehicle);
        }
    }

    public static void showAllPeople(List<Person> allPeople){
        for(Person currentPerson : allPeople){
            System.out.println(currentPerson);
        }
    }

    public static void addVehiclesFromFile(List<Vehicle> listVehicle) {
        try (Scanner fileScan = new Scanner(new File("vehicles.txt"))){

            while (fileScan.hasNextLine()){
                String line =fileScan.nextLine();
                String[] objects=line.split(",");
                Vehicle vehicle= new Vehicle(objects[0].trim(),Type.valueOf(objects[1].trim()),Integer.parseInt(objects[3].trim()),objects[3].trim(),objects[4].trim());
                listVehicle.add(vehicle);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addPeopleFromFile(List<Person> listPeople) {
        try (Scanner thisfileScan = new Scanner(new File("persoane.txt"))){

            while (thisfileScan.hasNextLine()){
                String line =thisfileScan.nextLine();
                String[] objects=line.split(",");
                Person person= new Person(objects[0].trim(),objects[1].trim(),objects[2].trim(),Gender.valueOf(objects[3].trim()),Integer.parseInt(objects[4].trim()));
                listPeople.add(person);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addRentsFromFile(List<Rent> listRent){

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try (Scanner thisfileScan = new Scanner(new File("inchirieri.txt"))){

            while (thisfileScan.hasNextLine()){
                String line =thisfileScan.nextLine();
                String[] objects=line.split(",");

                Rent rent= new Rent(df.parse(objects[0]),df.parse(objects[1]),Integer.parseInt(objects[2].trim()),objects[3].trim(),objects[4].trim());
                listRent.add(rent);
            }

        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }
}
