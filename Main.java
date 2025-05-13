import business.service.ContactService;
import business.service.ContactServiceImpl;
import dao.InMemoryStorage;
import dao.Storage;
import presentation.ContactController;

public class Main {
    public static void main(String[] args) {
        Storage storage = new InMemoryStorage();
        ContactService contactService = new ContactServiceImpl(storage);
        ContactController contactController = new ContactController(contactService);

        System.out.println(contactController.create("Магомедпаша", "sultanov.mps@mail.ru"));
        System.out.println(contactController.create("Александр", "alex1337@mail.ru"));

        System.out.println();
        System.out.println(contactController.getAll());
        contactController.delete(1);
        contactController.create("Николай", "kolya2025@mail.ru");
        System.out.println(contactController.getAll());

        System.out.println();
        contactController.update(null, "nikolay@gmail.com", 3);
        System.out.println(contactController.getAll());
    }

}
