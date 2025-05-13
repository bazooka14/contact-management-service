package presentation;

import business.model.Contact;
import business.service.ContactService;
import dto.ContactDto;

import java.util.List;

public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    public List<Contact> getAll() {
        return contactService.getAll();
    }

    public Contact getById(int id) {
        return contactService.getById(id);
    }

    public Contact create(String name, String email) {
        ContactDto contactDto = new ContactDto(name, email);
        return contactService.create(contactDto);
    }

    public boolean update(String name, String email, int id) {
        ContactDto contactDto = new ContactDto(name, email);
        return contactService.update(contactDto, id);
    }

    public boolean delete(int id) {
        return contactService.delete(id);
    }
}
