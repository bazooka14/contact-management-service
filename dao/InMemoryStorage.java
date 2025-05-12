package dao;

import business.model.Contact;
import business.model.ContactIdComparator;
import dto.ContactDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryStorage implements Storage {
    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public Contact findById(int id) {
        int index = findIndex(id);
        if (index < 0) {
            return null;
        } else {
            return contacts.get(index);
        }
    }

    @Override
    public Contact save(Contact contact) {
        int sameIdContactIndex = findIndex(contact.getId());
        if (sameIdContactIndex < 0) {
            contacts.add(contact);
            return contact;
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        int index = findIndex(id);
        if (index < 0) {
            return false;
        } else {
            contacts.remove(index);
            return true;
        }
    }

    @Override
    public boolean updateContact(ContactDto contactDto, int id) {
        int index = findIndex(id);
        if (index < 0) {
            return false;
        } else {
            if (contactDto.getName() != null) {
                contacts.get(id).setName(contactDto.getName());
            }
            if (contactDto.getEmail() != null) {
                contacts.get(id).setEmail(contactDto.getEmail());
            }
        }
        return false;
    }

    private int findIndex(int id) {
        Contact key = new Contact(id, "", "");
        return Collections.binarySearch(contacts, key, new ContactIdComparator());
    }
}
