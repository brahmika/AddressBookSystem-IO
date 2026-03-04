package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book System");

        Scanner scanner = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        boolean running = true;

        while (running) {

            System.out.println("\nMain Menu:");
            System.out.println("1. Create Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Display All Address Books");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("Enter Address Book Name:");
                    system.createAddressBook(scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Enter Address Book Name:");
                    AddressBook book = system.getAddressBook(scanner.nextLine());
                    if (book != null) manageAddressBook(book, scanner);
                    break;

                case 3:
                    system.displayAllAddressBooks();
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static void manageAddressBook(AddressBook book, Scanner scanner) {

        boolean managing = true;

        while (managing) {

            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Back");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("Enter First Name:");
                    String firstName = scanner.nextLine();

                    System.out.println("Enter Last Name:");
                    String lastName = scanner.nextLine();

                    System.out.println("Enter Address:");
                    String address = scanner.nextLine();

                    System.out.println("Enter City:");
                    String city = scanner.nextLine();

                    System.out.println("Enter State:");
                    String state = scanner.nextLine();

                    System.out.println("Enter Zip:");
                    String zip = scanner.nextLine();

                    System.out.println("Enter Phone Number:");
                    String phone = scanner.nextLine();

                    System.out.println("Enter Email:");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(
                            firstName, lastName, address,
                            city, state, zip, phone, email
                    );

                    book.addContact(contact);
                    break;

                case 2:
                    System.out.println("Enter First Name to Edit:");
                    book.editContact(scanner.nextLine(), scanner);
                    break;

                case 3:
                    System.out.println("Enter First Name to Delete:");
                    book.deleteContact(scanner.nextLine());
                    break;

                case 4:
                    book.displayContacts();
                    break;

                case 5:
                    managing = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}