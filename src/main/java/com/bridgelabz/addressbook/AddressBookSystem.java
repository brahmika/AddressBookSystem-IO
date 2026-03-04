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

    public List<Contact> searchByCityOrState(String keyword, boolean searchByCity) {

        return addressBooks.values()
                .stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(contact -> {
                    if (searchByCity) {
                        return contact.getCity().equalsIgnoreCase(keyword);
                    } else {
                        return contact.getState().equalsIgnoreCase(keyword);
                    }
                })
                .collect(Collectors.toList());
    }
}