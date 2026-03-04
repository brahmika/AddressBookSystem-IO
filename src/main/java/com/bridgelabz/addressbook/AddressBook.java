package com.bridgelabz.addressbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();
    private static final String FILE_NAME = "contacts.txt";

    public AddressBook() {
        loadFromFile(); // Load contacts automatically on startup
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveToFile(contact);
        System.out.println("Contact added successfully!");
    }

    private void saveToFile(Contact contact) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(contact.toFileFormat());
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving contact: " + e.getMessage());
        }
    }

    private void loadFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return; // No file yet, skip loading
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 8) {

                    Contact contact = new Contact(
                            data[0], data[1], data[2], data[3],
                            data[4], data[5], data[6], data[7]
                    );

                    contacts.add(contact);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
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