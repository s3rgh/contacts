package contacts.factories;

import contacts.contact.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static contacts.utils.ScannerUtils.getScannerInstance;

public class PersonFactory implements ContactFactory {

    @Override
    public Person create() {
        var person = new Person();
        setUpName(person);
        setUpSurname(person);
        setUpBirthday(person);
        setUpGender(person);
        setUpNumber(person);
        System.out.println("The record added.");
        return person;
    }

    private Person setUpName(Person person) {
        System.out.println("Enter the name: ");
        person.setName(getScannerInstance().nextLine());
        return person;
    }

    private Person setUpSurname(Person person) {
        System.out.println("Enter the surname: ");
        person.setSurname(getScannerInstance().nextLine());
        return person;
    }

    private Person setUpBirthday(Person person) {
        System.out.println("Enter the birth date: ");
        var birthday = getScannerInstance().nextLine();
        if (birthday.equals("") || birthday.isBlank() || birthday.isEmpty()) {
            System.out.println("Bad birth date!");
            person.setBirthday("[no data]");
            return person;
        }
        person.setBirthday(birthday);
        return person;
    }

    private Person setUpGender(Person person) {
        System.out.println("Enter the gender (M, F):");
        var gender = getScannerInstance().nextLine();
        if (!gender.toLowerCase().matches("[mw]")) {
            System.out.println("Bad gender!");
            person.setGender("[no data]");
            return person;
        }
        person.setGender(gender);
        return person;
    }
}
