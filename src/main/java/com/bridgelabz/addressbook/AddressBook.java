package com.bridgelabz.addressbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();
    private static final String FILE_NAME = "contacts.txt";

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveToFile(contact);
        System.out.println("Contact added successfully!");
    }

    private void saveToFile(Contact contact) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(contact.toFileFormat());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving contact to file: " + e.getMessage());
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}