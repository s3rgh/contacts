package contacts.contact;

import contacts.strategies.PersonBehaviourStrategy;

import java.time.LocalDateTime;

public class Person extends Contact {
    private String surname;
    private String gender;
    private String birthday;

    public Person() {
        super();
        this.strategy = new PersonBehaviourStrategy();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        super.setUpdatedAt(LocalDateTime.now());
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        super.setUpdatedAt(LocalDateTime.now());
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        super.setUpdatedAt(LocalDateTime.now());
    }

    public void info() {
        strategy.info(this);
    }

    @Override
    public String toString() {
        return super.getName() + " " + getSurname();
    }
}
