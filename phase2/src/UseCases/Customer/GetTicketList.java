package UseCases.Customer;

import Entities.User.Ticket.Ticket;
import Entities.User.User;

import java.util.ArrayList;
import java.util.List;

// A Use Case that returns a list of all the Tickets belonging to a User.

public class GetTicketList {
    /**
     * Gets and returns the current ticket IDs saved to a User's account.
     * @return the list of tickets
     */
    public static Ticket[] getTickets(User user){
        return user.getTickets();
    }

    public static Ticket getOneTicket(User user, int ticketHash){
        Ticket[] tickets = getTickets(user);
        List<Integer> ticketsHashes = new ArrayList<>();
        for (Ticket ticket : tickets){
            ticketsHashes.add(ticket.getTicketID());
        }
        return tickets[ticketsHashes.indexOf(ticketHash)];
    }
}
