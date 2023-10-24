package contacts.commands;

import contacts.utils.SerializationUtils;

import java.io.IOException;

import static contacts.contact.Contacts.getListOfContacts;
import static contacts.enums.Action.*;
import static contacts.utils.ScannerUtils.getScannerInstance;

public abstract class Command {

    public abstract void execute();

    public void recordAction(int index) {
        while (true) {
            System.out.println("\n[record] Enter action (edit, delete, menu): ");
            var action = getScannerInstance().nextLine();
            if (byAction(action) == EDIT) {
                if (getListOfContacts().size() == 0) {
                    System.out.println("No records to edit!");
                } else {
                    getListOfContacts().get(index).edit();
                    saveAllContacts();
                    System.out.println("Saved");
                    getListOfContacts().get(index).info();
                }
            } else if (byAction(action) == DELETE) {
                getListOfContacts().remove(index);
                saveAllContacts();
                System.out.println("Saved");
                break;
            } else if (byAction(action) == MENU) {
                break;
            }
        }
    }

    static void saveAllContacts() {
        try {
            SerializationUtils.serialize(getListOfContacts(), "D:/STUDY/JAVA/!PROJECTS/Contacts (Java)/Contacts (Java)/task/src/contacts/db/phonebook.db");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
