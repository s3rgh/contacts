package contacts.factories;

import contacts.contact.Organization;

import static contacts.utils.ScannerUtils.getScannerInstance;

public class OrganizationFactory implements ContactFactory {

    @Override
    public Organization create() {
        var organization = new Organization();
        setUpName(organization);
        setUpAddress(organization);
        setUpNumber(organization);
        System.out.println("The record added.");
        return organization;
    }

    private Organization setUpName(Organization organization) {
        System.out.println("Enter the organization name: ");
        organization.setName(getScannerInstance().nextLine());
        return organization;
    }

    private Organization setUpAddress(Organization organization) {
        System.out.println("Enter the address: ");
        organization.setAddress(getScannerInstance().nextLine());
        return organization;
    }
}
