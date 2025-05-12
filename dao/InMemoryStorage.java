package dao;

import business.model.Contact;
import business.model.ContactIdComparator;
import dto.ContactDto;
import utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryStorage implements Storage {
    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> findAll() {
        return Utils.copyList(contacts);
    }

    @Override
    public Contact findById(int id) {
        int index = findIndex(id);
        if (index < 0) {
            return null;
        } else {
            return Utils.copyContact(contacts.get(index));
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
            contacts.get(id).setName(contactDto.getName());
            contacts.get(id).setEmail(contactDto.getEmail());
            return true;
        }
    }

    private int findIndex(int id) {
        Contact key = new Contact(id, "", "");
        return Collections.binarySearch(contacts, key, new ContactIdComparator());
    }
}
