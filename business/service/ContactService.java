package business.service;

import business.model.Contact;
import dto.ContactDto;

import java.util.List;

public interface ContactService {
    List<Contact> getAll();

    Contact getById(int id);

    Contact create(ContactDto contactDto);

    boolean update(ContactDto contactDto, int id);

    boolean delete(int id);
}
