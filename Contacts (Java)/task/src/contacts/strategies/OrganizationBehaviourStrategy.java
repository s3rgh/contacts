package contacts.strategies;

import contacts.contact.Contact;
import contacts.contact.Organization;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static contacts.enums.ContactField.byContactField;
import static contacts.utils.ScannerUtils.getScannerInstance;

public class OrganizationBehaviourStrategy implements BehaviourStrategy {

    public <T extends Contact> void info(T t) {
        Organization organization = (Organization) t;
        System.out.println("Organization name: " + organization.getName());
        System.out.println("Address: " + organization.getAddress());
        System.out.println("Number: " + organization.getNumber());
        System.out.println("Time created: " + organization.getCreatedAt());
        System.out.println("Time last edit: " + organization.getUpdatedAt());
    }

    @Override
    public <T extends Contact> void edit(T t) {
        Organization organization = (Organization) t;
        System.out.println("Select a field (name, address, number): ");
        var field = getScannerInstance().nextLine();
        editField(field, organization);
    }

    @Override
    public <T extends Contact> boolean search(T t, String query) {
        Organization organization = (Organization) t;
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern.matcher(organization.getName());
        Matcher matcher2 = pattern.matcher(organization.getName());
        return organization.getName().contains(query) || organization.getNumber().contains(query) || matcher1.find() || matcher2.find();
    }


    public void editField(String field, Organization organization) {
        switch (byContactField(field)) {
            case NAME -> {
                System.out.println("Enter name:");
                organization.setName(getScannerInstance().nextLine());
            }
            case ADDRESS -> {
                System.out.println("Enter address:");
                organization.setAddress(getScannerInstance().nextLine());
            }
            case NUMBER -> {
                System.out.println("Enter number:");
                organization.setNumber(getScannerInstance().nextLine());
            }
        }
    }
}
