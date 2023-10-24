package contacts.commands;

import contacts.contact.Contact;

import java.util.ArrayList;

import static contacts.contact.Contacts.getListOfContacts;
import static contacts.enums.Action.*;
import static contacts.utils.ScannerUtils.getScannerInstance;

public class SearchCommand extends Command {
    @Override
    public void execute() {
        if (getListOfContacts().size() == 0) {
            System.out.println("No records to search!");
        } else {
            executeSearch();
            while (true) {
                System.out.println("\n[search] Enter action ([number], back, again): ");
                var action = getScannerInstance().nextLine();
                if (action.matches("[0-9]")) {
                    var index = Integer.parseInt(action) - 1;
                    getListOfContacts().get(index).info();
                    this.recordAction(index);
                    break;
                } else if (byAction(action) == AGAIN) {
                    executeSearch();
                } else if (byAction(action) == BACK) {
                    break;
                }
            }
        }
    }

    private void executeSearch() {
        System.out.println("Enter search query: ");
        var query = getScannerInstance().nextLine();
        var listOfContacts = getListOfContacts();
        var searchResult = new ArrayList<Contact>();
        for (Contact c : listOfContacts) {
            if (c.search(query)) {
                searchResult.add(c);
            }
        }
        System.out.printf("Found %d results:%n", searchResult.size());
        for (int i = 0; i < searchResult.size(); i++) {
            Contact c = searchResult.get(i);
            System.out.println((i + 1) + ". " + c);
        }
    }
}
