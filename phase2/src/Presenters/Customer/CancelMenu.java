package Presenters.Customer;

import Controllers.CancelMenuC;
import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import UseCases.FlightNotFoundException;
import UseCases.Customer.GetTicketList;
import UseCases.Admin.GetUser;

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
        String username = Console.prompt("Please enter your username:");
        if(GetUser.ReturnUser(username) == null){
            System.out.println("Invalid username.\n");
            CancelMenu.CancelMenuPrompt();
        } else if (GetTicketList.getTickets(GetUser.ReturnUser(username)).length <= 0) {
            System.out.println("You have no tickets. Returning you to main menu...");
            try {
                MainMenu.mainPage();
            } catch (FlightNotFoundException | TicketAlreadyExistsException e) {
                throw new RuntimeException(e);
            }
        } else {
            String ticketID = Console.prompt(new String[]{
                    Arrays.toString(GetTicketList.getTickets(GetUser.ReturnUser(username))),
                    "Please enter your ID of ticket you are going to cancel:"
            });
            int ticketIDHash = Integer.parseInt(ticketID);
            new CancelMenuC(username, ticketIDHash);
        }
    }
}
