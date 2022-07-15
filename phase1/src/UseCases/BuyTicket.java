package UseCases;

import Entities.Ticket.Ticket;
import Entities.User.TicketAlreadyExistsException;
import Entities.User.User;

// UseCase responsible for assigning a ticket to a Customer (for when a customer buys the ticket)

public class BuyTicket {
    public static void PurchasedTicket(User user, Ticket newTicket) throws TicketAlreadyExistsException {
        user.addTicket(newTicket);
    }
}
