package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello! \nThis is your menu:");
        System.out.println(" 1. View all the vehicles sorted by manufacturing year");
        System.out.println(" 2. View all the vehicles sorted by manufacturing brand");
        System.out.println(" 3. View the historic of all the rented vehicles  and their users");
        System.out.println(" 4. Search for a vehicle by type");
        System.out.println(" 5. View the historic of all the rented vehicles  and their users");
        System.out.println(" 6. Rent a vehicle");
        System.out.println(" 7. View all the rented vehicles of a specific user");

        int choice=validationInput();

        switch (choice)
        {
            case 1:
            {
                System.out.println("\nIt is going to be implemented - 1 ...");
                break;
            }
            case 2:
            {
                System.out.println("\nIt is going to be implemented - 2 ...");
                break;
            }
            case 3:
            {
                System.out.println("\nIt is going to be implemented -3 ...");
                break;
            }
            case 4:
            {
                System.out.println("\nIt is going to be implemented -4 ...");
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

    public static int validationInput() {
        Scanner scan = new Scanner(System.in);
        boolean isValid = true;
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
        while ((input < 0) || (input > 7) || (isValid == false));

        return  input;
    }
}
