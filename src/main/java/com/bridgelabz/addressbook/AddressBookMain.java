package com.bridgelabz.addressbook;

import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        while (true) {

            System.out.println("\n===== Address Book System =====");
            System.out.println("1. Create AddressBook");
            System.out.println("2. Add Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search by City");
            System.out.println("5. Search by State");
            System.out.println("6. Exit");

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
                    AddressBook addressBook = system.getAddressBook(addBook);

                    if (addressBook == null) {
                        System.out.println("AddressBook not found!");
                        break;
                    }

                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("City: ");
                    String city = scanner.nextLine();

                    System.out.print("State: ");
                    String state = scanner.nextLine();

                    Contact contact = new Contact(firstName, lastName, city, state);
                    addressBook.addContact(contact);
                    break;

                case 3:
                    System.out.print("Enter AddressBook name: ");
                    String deleteBook = scanner.nextLine();
                    AddressBook book = system.getAddressBook(deleteBook);

                    if (book == null) {
                        System.out.println("AddressBook not found!");
                        break;
                    }

                    System.out.print("First Name: ");
                    String delFirst = scanner.nextLine();

                    System.out.print("Last Name: ");
                    String delLast = scanner.nextLine();

                    book.deleteContact(delFirst, delLast);
                    break;

                case 4:
                    System.out.print("Enter City: ");
                    String searchCity = scanner.nextLine();

                    List<Contact> cityResults =
                            system.searchByCityOrState(searchCity, true);

                    if (cityResults.isEmpty()) {
                        System.out.println("No persons found in city: " + searchCity);
                    } else {
                        cityResults.forEach(System.out::println);
                    }
                    break;

                case 5:
                    System.out.print("Enter State: ");
                    String searchState = scanner.nextLine();

                    List<Contact> stateResults =
                            system.searchByCityOrState(searchState, false);

                    if (stateResults.isEmpty()) {
                        System.out.println("No persons found in state: " + searchState);
                    } else {
                        stateResults.forEach(System.out::println);
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}