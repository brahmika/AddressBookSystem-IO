package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    public void createAddressBook(String name) {

        if (addressBooks.containsKey(name)) {
            System.out.println("Address Book already exists.");
            return;
        }

        addressBooks.put(name, new AddressBook());
        System.out.println("Address Book '" + name + "' created successfully.");
    }

    public AddressBook getAddressBook(String name) {

        if (!addressBooks.containsKey(name)) {
            System.out.println("Address Book not found.");
            return null;
        }

        return addressBooks.get(name);
    }

    public void displayAllAddressBooks() {

        if (addressBooks.isEmpty()) {
            System.out.println("No Address Books available.");
            return;
        }

        addressBooks.keySet().forEach(System.out::println);
    }
}