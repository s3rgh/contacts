package contacts.commands;

public class ExitCommand extends Command {
    @Override
    public void execute() {
        saveAllContacts();
    }
}
