package Presenters;

import Controllers.CancelMenuC;
import Entities.User.TicketNotFoundException;
import UseCases.GetTicketList;
import UseCases.GetUser;

import java.util.Arrays;

/*
 * This is presenter class for Cancel a Ticket with the prompt page and a helper method for generating ticket list.
 * Sending the user's input to the CancelMenuC (controller class).
 */
public class CancelMenu {

    /**
     * Menu that allows a user to cancel their flight.
     * @throws TicketNotFoundException if the input ticket does not exist
     */
    public static void CancelMenuPrompt() throws TicketNotFoundException {
        String username = Console.prompt("Please enter your username:","^[0-9]*$");
        String ticketID = Console.prompt(new String[]{
                Arrays.toString(GetTicketList.getTickets(GetUser.ReturnUser(username))),
                "Please enter your ID of ticket you are going to cancel:"
                },
                "^[0-9]*$");
        int ticketIDHash = Integer.parseInt(ticketID);
        new CancelMenuC(username, ticketIDHash);
    }
}
