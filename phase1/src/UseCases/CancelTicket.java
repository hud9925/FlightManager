package UseCases;

import Entities.Ticket.Ticket;
import Entities.User.Customer;
import Entities.User.TicketNotFoundException;

// UseCase responsible for removing a Customer's assignment to a ticket (for when a customer cancels a ticket)

public class CancelTicket {

    public void CancelledTicket(Ticket cancelTicket) throws TicketNotFoundException {
        Customer.removeTicket(cancelTicket);}
}
