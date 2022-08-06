package UseCases.Customer;

import Entities.User.Ticket.Ticket;
import Entities.User.TicketNotFoundException;
import Entities.User.User;

// A Use Case responsible for removing a User's assignment to a ticket (for when a customer cancels a ticket)

public class CancelTicket {

    /**
     * Removes an existing ticket from a specific user,
     * effectively cancelling the ticket.
     * @param user the user cancelling the ticket
     * @param oldTicket the ticket to cancel
     * @throws TicketNotFoundException exception if the ticket does not already exist
     */
    public static void cancelledTicket(User user, Ticket oldTicket) throws TicketNotFoundException {
        user.removeTicket(oldTicket);
        oldTicket.getWhere().empty();
    }
}
