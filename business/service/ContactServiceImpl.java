package business.service;

import business.model.Contact;
import dao.Storage;
import dto.ContactDto;
import infrastructure.idGenerator;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    private Storage storage;

    public ContactServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public List<Contact> getAll() {
        return storage.findAll();
    }

    @Override
    public Contact getById(int id) {
        return storage.findById(id);
    }

    @Override
    public Contact create(ContactDto contactDto) {
        String nameDto = contactDto.getName();
        String emailDto = contactDto.getEmail();

        if (nameDto != null && !nameDto.isEmpty() && emailDto != null && !emailDto.isEmpty()) {
            Contact contact = new Contact(idGenerator.getNextId(), nameDto, emailDto);
            return storage.save(contact);
        }

        return null;
    }

    @Override
    public boolean update(ContactDto contactDto, int id) {
        Contact contact = getById(id);
        String nameDto = contactDto.getName();
        String emailDto = contactDto.getEmail();

        if (nameDto != null && !nameDto.isEmpty() && emailDto != null && !emailDto.isEmpty()) {
            storage.update(contactDto, id);
            return true;
        }

        if (nameDto != null && !nameDto.isEmpty()) {
            contactDto.setEmail(contact.getEmail());
            storage.update(contactDto, id);
            return true;
        }

        if (emailDto != null && !emailDto.isEmpty()) {
            contactDto.setName(contact.getName());
            storage.update(contactDto, id);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return storage.delete(id);
    }
}
