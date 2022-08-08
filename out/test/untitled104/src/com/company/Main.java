package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        List<Vehicle> allVehicles = new ArrayList<>();
        List<Person> allPeople = new ArrayList<>();

        addVehiclesFromFile(allVehicles);
        addPeopleFromFile(allPeople);

        for(Person p : allPeople){
            System.out.println(p);
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
                System.out.println("\nIt is going to be implemented -3 ...");
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
        System.out.println(" 3. View the historic of all the rented vehicles  and their users");
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
}
