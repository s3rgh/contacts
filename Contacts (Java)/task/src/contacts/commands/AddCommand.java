package contacts.commands;

import contacts.factories.ContactFactory;
import contacts.factories.OrganizationFactory;
import contacts.factories.PersonFactory;

import java.util.Objects;

import static contacts.contact.Contacts.getListOfContacts;
import static contacts.enums.ContactType.byString;
import static contacts.utils.ScannerUtils.getScannerInstance;

public class AddCommand extends Command {
    private ContactFactory factory;

    @Override
    public void execute() {
        System.out.println("Enter the type (person, organization): ");
        var type = getScannerInstance().nextLine();
        switch (Objects.requireNonNull(byString(type))) {
            case PERSON -> factory = new PersonFactory();
            case ORGANIZATION -> factory = new OrganizationFactory();
        }
        getListOfContacts().add(factory.create());
        saveAllContacts();
        System.out.println("Saved");
    }
}
