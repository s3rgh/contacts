package contacts.enums;

public enum ContactType {
    PERSON,
    ORGANIZATION;

    public static ContactType byString(String string) {
        for (ContactType s : ContactType.values()) {
            if (string.equalsIgnoreCase(s.name())) {
                return s;
            }
        }
        return null;
    }
}
