package Controllers;

import Entities.User.TicketNotFoundException;
import Presenters.Customer.CancelMenu;
import Presenters.Customer.MainMenu;
import UseCases.Customer.CancelTicket;
import UseCases.Customer.GetTicketList;
import UseCases.Admin.GetUser;

/**
 * Controller class for the CancelMenu presenter class. Handles ticket cancellation based on the user's
 * input in the presenter class.
 */
public class CancelMenuC {

    /**
     * Parses the ticket based on the user's username and the ticket ID. Cancels the ticket and
     * updates the user's ticket list.
     * @param username username of the user logging in
     * @param ticketIDHash ticket ID
     */
    public CancelMenuC(String username, int ticketIDHash) {
        try {
            CancelTicket.cancelledTicket(GetUser.returnUser(username),
                    GetTicketList.getOneTicket(GetUser.returnUser(username), ticketIDHash));
        } catch (TicketNotFoundException e) {
            System.out.println("Ticket not found. Please try again.");
            CancelMenu.cancelMenuPrompt(username);
            return;
        }

        System.out.println("Ticket has been successfully deleted! Redirect to the main menu...");
        MainMenu.mainPage(username);
    }
}
