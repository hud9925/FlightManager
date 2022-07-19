package Controllers;

import Entities.User.TicketNotFoundException;
import Presenters.CancelMenu;
import UseCases.CancelTicket;
import UseCases.GetTicketList;
import UseCases.GetUser;

public class CancelMenuC {
    public CancelMenuC(String username, int ticketIDHash) throws TicketNotFoundException {
        CancelTicket.CancelledTicket(GetUser.ReturnUser(username),
                GetTicketList.getOneTicket(GetUser.ReturnUser(username), ticketIDHash));
        boolean TicketNotFoundException = false;
        if (!TicketNotFoundException){
            System.out.println("Ticket has been successfully deleted! Redirect to the ticket menu...");
        }
        CancelMenu.CancelMenuPrompt();
    }
}
