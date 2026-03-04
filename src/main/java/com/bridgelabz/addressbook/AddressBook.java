package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private String name;
    private List<Contact> contacts = new ArrayList<>();

    public AddressBook(String name) {
        this.name = name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {

        boolean exists = contacts.stream()
                .anyMatch(existing -> existing.equals(contact));

        if (exists) {
            System.out.println("Duplicate contact found. Entry not added.");
            return;
        }

        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }
}