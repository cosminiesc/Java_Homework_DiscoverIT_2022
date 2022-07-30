package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        List<Vehicle> allVehicles = new ArrayList<Vehicle>();

        showMenu();

        int choice=validationInput();

        switch (choice)
        {
            case 1:
            {
                Collections.sort(allVehicles,new Vehicle.ManufacturingYearComparator());
                showAllVehicle(allVehicles);
                break;
            }
            case 2:
            {
                Collections.sort(allVehicles,new Vehicle.BrandComparator());
                showAllVehicle(allVehicles);
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
                Collections.sort(allVehicles,new Vehicle.TypeComparator());

                for(Vehicle currentVehicle : allVehicles ) {

                    if(currentVehicle.getType().toString().equals(desiredType)) {

                        System.out.println(currentVehicle);
                    }
                    else {
                        break;
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
}
