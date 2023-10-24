package contacts.strategies;

import contacts.contact.Contact;
import contacts.contact.Person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static contacts.enums.ContactField.byContactField;
import static contacts.utils.ScannerUtils.getScannerInstance;

public class PersonBehaviourStrategy implements BehaviourStrategy {
    @Override
    public <T extends Contact> void info(T t) {
        Person p = (Person) t;
        System.out.println("Name: " + p.getName());
        System.out.println("Surname: " + p.getSurname());
        System.out.println("Birth date: " + p.getBirthday());
        System.out.println("Gender: " + p.getGender());
        System.out.println("Number: " + p.getNumber());
        System.out.println("Time created: " + p.getCreatedAt());
        System.out.println("Time last edit: " + p.getUpdatedAt());
    }

    @Override
    public <T extends Contact> void edit(T t) {
        Person person = (Person) t;
        System.out.println("Select a field (name, surname, birth, gender, number): ");
        var field = getScannerInstance().nextLine();
        editField(field, person);
    }

    @Override
    public <T extends Contact> boolean search(T t, String query) {
        Person person = (Person) t;
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern.matcher(person.getName());
        Matcher matcher2 = pattern.matcher(person.getSurname());
        Matcher matcher3 = pattern.matcher(person.getNumber());
        return person.getName().contains(query) || person.getSurname().contains(query) || person.getNumber().contains(query) ||
                matcher1.find() || matcher2.find() || matcher3.find();
    }


    public void editField(String field, Person person) {
        switch (byContactField(field)) {
            case NAME -> {
                System.out.println("Enter the name:");
                person.setName(getScannerInstance().nextLine());
            }
            case SURNAME -> {
                System.out.println("Enter the surname:");
                person.setSurname(getScannerInstance().nextLine());
            }
            case BIRTH -> {
                System.out.println("Enter the birth:");
                person.setBirthday(getScannerInstance().nextLine());
            }
            case GENDER -> {
                System.out.println("Enter the gender:");
                person.setGender(getScannerInstance().nextLine());
            }
            case NUMBER -> {
                System.out.println("Enter the number:");
                person.setNumber(getScannerInstance().nextLine());
            }
        }
    }
}
