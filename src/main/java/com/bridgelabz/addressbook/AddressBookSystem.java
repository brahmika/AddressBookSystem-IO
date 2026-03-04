package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    public void addAddressBook(String name) {

        if (addressBooks.containsKey(name)) {
            System.out.println("AddressBook already exists!");
            return;
        }

        addressBooks.put(name, new AddressBook(name));
        System.out.println("AddressBook created successfully!");
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public void addContactToBook(String bookName, Contact contact) {

        AddressBook book = addressBooks.get(bookName);

        if (book == null) {
            System.out.println("AddressBook not found!");
            return;
        }

        book.addContact(contact);
    }

    // Count By City
    public void countByCity() {

        Map<String, Long> cityCount =
                addressBooks.values()
                        .stream()
                        .flatMap(book -> book.getContacts().stream())
                        .collect(Collectors.groupingBy(
                                Contact::getCity,
                                Collectors.counting()
                        ));

        if (cityCount.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        cityCount.forEach((city, count) ->
                System.out.println("City: " + city + " | Count: " + count)
        );
    }

    // Count By State
    public void countByState() {

        Map<String, Long> stateCount =
                addressBooks.values()
                        .stream()
                        .flatMap(book -> book.getContacts().stream())
                        .collect(Collectors.groupingBy(
                                Contact::getState,
                                Collectors.counting()
                        ));

        if (stateCount.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        stateCount.forEach((state, count) ->
                System.out.println("State: " + state + " | Count: " + count)
        );
    }
}