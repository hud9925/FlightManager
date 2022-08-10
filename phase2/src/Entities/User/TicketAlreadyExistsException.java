package Entities.User;

public class TicketAlreadyExistsException extends Exception {
    public TicketAlreadyExistsException(String username) {
        super("Ticket is already assigned to user '" + username + "'.");
    }
}
