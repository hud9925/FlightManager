package UseCases;

import Entities.Ticket.Ticket;
import Entities.User.User;

import java.util.ArrayList;
import java.util.List;

public class GetTicketList {
    /**
     * @return the list of tickets.
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
