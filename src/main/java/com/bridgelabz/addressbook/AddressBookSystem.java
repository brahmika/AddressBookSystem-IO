package com.bridgelabz.addressbook;

import java.util.*;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    private Map<String, List<Contact>> cityDictionary = new HashMap<>();
    private Map<String, List<Contact>> stateDictionary = new HashMap<>();

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

    // Centralized Add (Important)
    public void addContactToBook(String bookName, Contact contact) {

        AddressBook book = addressBooks.get(bookName);

        if (book == null) {
            System.out.println("AddressBook not found!");
            return;
        }

        // Add to AddressBook
        book.addContact(contact);

        // Update City Dictionary
        cityDictionary
                .computeIfAbsent(contact.getCity(), k -> new ArrayList<>())
                .add(contact);

        // Update State Dictionary
        stateDictionary
                .computeIfAbsent(contact.getState(), k -> new ArrayList<>())
                .add(contact);
    }

    public void viewByCity(String city) {

        List<Contact> contacts = cityDictionary.get(city);

        if (contacts == null || contacts.isEmpty()) {
            System.out.println("No persons found in city: " + city);
            return;
        }

        contacts.forEach(System.out::println);
    }

    public void viewByState(String state) {

        List<Contact> contacts = stateDictionary.get(state);

        if (contacts == null || contacts.isEmpty()) {
            System.out.println("No persons found in state: " + state);
            return;
        }

        contacts.forEach(System.out::println);
    }
}