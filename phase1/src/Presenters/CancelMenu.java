package Presenters;

import Controllers.AdminFlightC;
import Controllers.CancelMenuC;
import Entities.Ticket.Ticket;
import Entities.User.TicketNotFoundException;
import UseCases.GetTicketList;
import UseCases.GetUser;

import java.util.Scanner;

/*
 * This is presenter class for Cancel a Ticket with the prompt page and a helper method for generating ticket list.
 * Sending the user's input to the CancelMenuC (controller class).
 */
public class CancelMenu {

    private static String username;
    public static void CancelMenuPrompt() throws TicketNotFoundException {
        System.out.println("You have reached the page of canceling tickets.\n" +
                "You will now reenter your username to get complete list of your purchased lists.\n");

        System.out.println(getEnhancedTicketListStr());

        String ticketID = Console.prompt(new String[]{
                "Please enter your ID of ticket you are going to cancel:"}, "^[0-9]*$");
        int ticketIDHash = Integer.parseInt(ticketID);
        new CancelMenuC(username, ticketIDHash);

    }

    public static String getEnhancedTicketListStr(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Please enter your username: \n");
        username = sc.nextLine();

        Ticket[] tickets = GetTicketList.getTickets(GetUser.ReturnUser(username));

        StringBuilder result = new StringBuilder();
        for (Ticket ticket : tickets){
            result.append(ticket.toString());
        }
        return result.toString();
    }
}