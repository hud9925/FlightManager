package Presenters.Customer;

import Controllers.CancelMenuC;
import Presenters.Console;
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
     */
    public static void cancelMenuPrompt() {
        String username = Console.prompt("Please enter your username:");
        if(GetUser.returnUser(username) == null){
            System.out.println("Invalid username.\n");
            CancelMenu.cancelMenuPrompt();
        } else if (GetTicketList.getTickets(GetUser.returnUser(username)).length <= 0) {
            System.out.println("You have no tickets. Returning you to main menu...");
            MainMenu.mainPage();
        } else {
            String ticketID = Console.prompt(new String[]{
                    Arrays.toString(GetTicketList.getTickets(GetUser.returnUser(username))),
                    "Please enter your ID of ticket you are going to cancel:"
            });
            int ticketIDHash = Integer.parseInt(ticketID);
            new CancelMenuC(username, ticketIDHash);
        }
    }
}
