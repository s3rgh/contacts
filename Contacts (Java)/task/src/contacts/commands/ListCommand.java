package contacts.commands;

import static contacts.contact.Contacts.getListOfContacts;
import static contacts.contact.Contacts.printList;
import static contacts.enums.Action.*;
import static contacts.utils.ScannerUtils.getScannerInstance;

public class ListCommand extends Command {
    @Override
    public void execute() {
        if (getListOfContacts().size() == 0) {
            System.out.println("No records to display!");
            return;
        }
        printList();
        while (true) {
            System.out.println("\n[list] Enter action ([number], back): ");
            var action = getScannerInstance().nextLine();
            if (action.matches("[0-9]")) {
                var index = Integer.parseInt(action) - 1;
                getListOfContacts().get(index).info();
                this.recordAction(index);
                break;
            } else if (byAction(action) == BACK) {
                break;
            }
        }
    }
}
