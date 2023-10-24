package contacts.enums;

public enum ContactField {
    NAME("name"),
    SURNAME("surname"),
    BIRTH("birth"),
    GENDER("gender"),
    NUMBER("number"),
    ADDRESS("address");

    ContactField(String field) {
        this.field = field;
    }

    private final String field;

    public String getField() {
        return field;
    }

    public static ContactField byContactField(String string) {
        for (ContactField s : ContactField.values()) {
            if (string.equalsIgnoreCase(s.name())) {
                return s;
            }
        }
        return null;
    }
}
