package dao;

import business.model.Contact;
import dto.ContactDto;

import java.util.List;

public interface Storage {

    List<Contact> findAll();

    Contact findById(int id);

    Contact save(Contact contact);

    boolean delete(int id);

    boolean updateContact(ContactDto contactDto, int id);
}
