package Presenters;

import Controllers.CancelMenuC;
import Entities.Ticket.Ticket;
import Entities.User.TicketNotFoundException;
import UseCases.GetTicketList;
import UseCases.GetUser;

import java.util.Arrays;

/*
 * This is presenter class for Cancel a Ticket with the prompt page and a helper method for generating ticket list.
 * Sending the user's input to the CancelMenuC (controller class).
 */
public class CancelMenu {

    public static void CancelMenuPrompt() throws TicketNotFoundException {
        String username = Console.prompt("Please enter your username:","^[0-9]*$");
        Ticket[] tickets = GetTicketList.getTickets(GetUser.ReturnUser(username));
        String ticketID = Console.prompt(new String[]{
                Arrays.toString(tickets),
                "Please enter your ID of ticket you are going to cancel:"
                },
                "^[0-9]*$");
        int ticketIDHash = Integer.parseInt(ticketID);
        new CancelMenuC(username, ticketIDHash);
    }
}