package Entities.User;

public class TicketNotFoundException extends Exception {
    public TicketNotFoundException(String username) {
        super("User '" + username + "' does not have the requested ticket.");
    }
}
