package com.bridgelabz.addressbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();
    private static final String FILE_NAME = "contacts.txt";

    public AddressBook() {
        loadFromFile();
    }

    // UC7 – Duplicate check using Streams
    public void addContact(Contact contact) {

        boolean exists = contacts.stream()
                .anyMatch(existing -> existing.equals(contact));

        if (exists) {
            System.out.println("Duplicate contact found. Entry not added.");
            return;
        }

        contacts.add(contact);
        saveToFile();
        System.out.println("Contact added successfully!");
    }

    public void editContact(String firstName, java.util.Scanner scanner) {

        for (Contact contact : contacts) {

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {

                System.out.println("Enter New Address:");
                contact.setAddress(scanner.nextLine());

                System.out.println("Enter New City:");
                contact.setCity(scanner.nextLine());

                System.out.println("Enter New State:");
                contact.setState(scanner.nextLine());

                System.out.println("Enter New Zip:");
                contact.setZip(scanner.nextLine());

                System.out.println("Enter New Phone Number:");
                contact.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter New Email:");
                contact.setEmail(scanner.nextLine());

                saveToFile();
                System.out.println("Contact updated successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    public void deleteContact(String firstName) {

        boolean removed = contacts.removeIf(contact ->
                contact.getFirstName().equalsIgnoreCase(firstName));

        if (removed) {
            saveToFile();
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void saveToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Contact contact : contacts) {
                writer.write(contact.toFileFormat());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private void loadFromFile() {

        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 8) {
                    contacts.add(new Contact(
                            data[0], data[1], data[2], data[3],
                            data[4], data[5], data[6], data[7]
                    ));
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

        contacts.forEach(System.out::println);
    }
}