package UseCases;

import Entities.Ticket.Ticket;
import Entities.User.Customer;
import Entities.User.TicketAlreadyExistsException;

// UseCase responsible for assigning a ticket to a Customer (for when a customer buys the ticket)

public class BuyTicket {

    public void PurchasedTicket(Ticket newTicket) throws TicketAlreadyExistsException {
        Customer.addTicket(newTicket);}
}
