package contacts.contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contacts implements Serializable {
    private static ArrayList<Contact> CONTACTS;

    private Contacts() {}

    public static List<Contact> getListOfContacts() {
        if (CONTACTS == null) {
            CONTACTS = new ArrayList<>();
        }
        return CONTACTS;
    }

    public static void printList() {
        for (int i = 0; i < CONTACTS.size(); i++) {
            Contact c = CONTACTS.get(i);
            if (c instanceof Person) {
                System.out.println((i + 1) + ". " + c);
            } else if (c instanceof Organization) {
                System.out.println((i + 1) + ". " + c);
            }
        }
    }
}
