package contacts.menu;

import contacts.commands.*;
import contacts.contact.Contact;
import contacts.utils.ScannerUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static contacts.enums.Action.EXIT;
import static contacts.enums.Action.byAction;
import static contacts.utils.SerializationUtils.deserialize;

public class Menu {
    private static final Scanner SCANNER = ScannerUtils.getScannerInstance();
    private Command command;

    private void setCommand(Command command) {
        this.command = command;
    }

    public void run() {
        //getListOfContacts().addAll(openDataBaseFile());

        while (true) {
            System.out.println("\n[menu] Enter action (add, list, search, count, exit): ");
            var action = SCANNER.nextLine();

            if (action.equals(EXIT.getAction())) {
                this.setCommand(new ExitCommand());
                command.execute();
                break;
            }

            switch (byAction(action)) {
                case ADD -> {
                    this.setCommand(new AddCommand());
                    command.execute();
                }
                case LIST -> {
                    this.setCommand(new ListCommand());
                    command.execute();
                }
                case SEARCH -> {
                    this.setCommand(new SearchCommand());
                    command.execute();
                }
                case COUNT -> {
                    this.setCommand(new CountCommand());
                    command.execute();
                }
            }
        }
        SCANNER.close();
    }

    private static List<Contact> openDataBaseFile() {
        System.out.println("open phonebook.db");
        List<Contact> list = new ArrayList<>();
        if (Files.exists(Path.of("D:/STUDY/JAVA/!PROJECTS/Contacts (Java)/Contacts (Java)/task/src/contacts/db/phonebook.db"))) {
            try {
                list = deserialize("D:/STUDY/JAVA/!PROJECTS/Contacts (Java)/Contacts (Java)/task/src/contacts/db/phonebook.db");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {

        }
        return list;
    }
}
