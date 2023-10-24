package contacts.strategies;

import contacts.contact.Contact;

import java.io.Serializable;

public interface BehaviourStrategy extends Serializable {
    <T extends Contact> void info(T t);
    <T extends Contact> void edit(T t);
    <T extends Contact> boolean search(T t, String query);
}
