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

    public void addContactToBook(String bookName, Contact contact) {

        AddressBook book = addressBooks.get(bookName);

        if (book == null) {
            System.out.println("AddressBook not found!");
            return;
        }

        book.addContact(contact);
    }

    //  Common stream to get all contacts
    private List<Contact> getAllContacts() {
        return addressBooks.values()
                .stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.toList());
    }

    //  Sort By City
    public void sortByCity() {

        List<Contact> sorted =
                getAllContacts().stream()
                        .sorted(Comparator.comparing(
                                Contact::getCity,
                                String.CASE_INSENSITIVE_ORDER))
                        .collect(Collectors.toList());

        printResult(sorted);
    }

    //  Sort By State
    public void sortByState() {

        List<Contact> sorted =
                getAllContacts().stream()
                        .sorted(Comparator.comparing(
                                Contact::getState,
                                String.CASE_INSENSITIVE_ORDER))
                        .collect(Collectors.toList());

        printResult(sorted);
    }

    //  Sort By Zip
    public void sortByZip() {

        List<Contact> sorted =
                getAllContacts().stream()
                        .sorted(Comparator.comparing(Contact::getZip))
                        .collect(Collectors.toList());

        printResult(sorted);
    }

    private void printResult(List<Contact> contacts) {

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        contacts.forEach(System.out::println);
    }
}