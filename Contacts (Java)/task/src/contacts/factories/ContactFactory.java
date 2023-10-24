package contacts.factories;

import contacts.contact.Contact;

import static contacts.utils.ScannerUtils.getScannerInstance;

public interface ContactFactory {
    Contact create();

    default <T extends Contact> T setUpNumber(T t) {
        System.out.println("Enter the number:");
        var number = getScannerInstance().nextLine();
        if (number.matches("\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*")) {
            t.setNumber(number);
        } else {
            System.out.println("Wrong number format!");
            t.setNumber("[no number]");
        }
        return t;
    }
}
