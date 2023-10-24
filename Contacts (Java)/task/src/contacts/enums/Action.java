package contacts.enums;

public enum Action {
    ADD("add"),
    SEARCH("edit"),
    EDIT("edit"),
    COUNT("count"),
    LIST("list"),
    BACK("back"),
    AGAIN("again"),
    DELETE("delete"),
    MENU("menu"),
    EXIT("exit");

    Action(String action) {
        this.action = action;
    }

    private String action;

    public String getAction() {
        return action;
    }

    public static Action byAction(String string) {
        for (Action s : Action.values()) {
            if (string.equalsIgnoreCase(s.name())) {
                return s;
            }
        }
        return EXIT;
    }
}
