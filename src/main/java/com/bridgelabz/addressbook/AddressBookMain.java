package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        while (true) {

            System.out.println("\n===== Address Book System =====");
            System.out.println("1. Create AddressBook");
            System.out.println("2. Add Contact");
            System.out.println("3. Count Persons by City");
            System.out.println("4. Count Persons by State");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter AddressBook name: ");
                    String bookName = scanner.nextLine();
                    system.addAddressBook(bookName);
                    break;

                case 2:
                    System.out.print("Enter AddressBook name: ");
                    String addBook = scanner.nextLine();

                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("City: ");
                    String city = scanner.nextLine();

                    System.out.print("State: ");
                    String state = scanner.nextLine();

                    Contact contact =
                            new Contact(firstName, lastName, city, state);

                    system.addContactToBook(addBook, contact);
                    break;

                case 3:
                    system.countByCity();
                    break;

                case 4:
                    system.countByState();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}