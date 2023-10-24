package contacts.commands;

import static contacts.contact.Contacts.getListOfContacts;

public class CountCommand extends Command {
    @Override
    public void execute() {
        System.out.printf("The Phone Book has %d records.%n", getListOfContacts().size());
    }
}
