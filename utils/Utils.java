package utils;

import business.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Contact> copyList(List<Contact> contacts) {
        List<Contact> copyOfContacts = new ArrayList<>();
        for (Contact contact: contacts) {
            copyOfContacts.add(copyContact(contact));
        }
        return copyOfContacts;
    }

    public static Contact copyContact(Contact contact) {
        return new Contact(contact.getId(), contact.getName(), contact.getEmail());
    }
}
