package UseCases;

import Entities.Ticket.Ticket;
import Entities.User.TicketNotFoundException;
import Entities.User.User;

// UseCase responsible for removing a Customer's assignment to a ticket (for when a customer cancels a ticket)

public class CancelTicket {
    public static void CancelledTicket(User user, Ticket oldTicket) throws TicketNotFoundException {
        user.removeTicket(oldTicket);
    }
}
