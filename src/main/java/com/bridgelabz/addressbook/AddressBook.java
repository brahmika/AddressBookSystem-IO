package com.bridgelabz.addressbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private String name;
    private List<Contact> contacts = new ArrayList<>();

    public AddressBook(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    //  WRITE TO FILE
    public void writeToFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(name + ".txt"))) {

            for (Contact contact : contacts) {
                writer.write(contact.toString());
                writer.newLine();
            }

            System.out.println("AddressBook saved to file successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    //  READ FROM FILE
    public void readFromFile() {

        contacts.clear();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(name + ".txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 5) {

                    Contact contact = new Contact(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[4]
                    );

                    contacts.add(contact);
                }
            }

            System.out.println("AddressBook loaded from file successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}