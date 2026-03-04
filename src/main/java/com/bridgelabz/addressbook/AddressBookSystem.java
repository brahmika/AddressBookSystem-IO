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

    // 🔥 UC11 – Sort By Name
    public void sortByName() {

        List<Contact> sortedContacts =
                addressBooks.values()
                        .stream()
                        .flatMap(book -> book.getContacts().stream())
                        .sorted(
                                Comparator.comparing(Contact::getFirstName, String.CASE_INSENSITIVE_ORDER)
                                        .thenComparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER)
                        )
                        .collect(Collectors.toList());

        if (sortedContacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        sortedContacts.forEach(System.out::println);
    }
}