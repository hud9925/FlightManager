package Controllers;

import Entities.User.TicketNotFoundException;
import UseCases.CancelTicket;
import UseCases.GetTicketList;
import UseCases.GetUser;

public class CancelMenuC {
    public CancelMenuC(String username, int ticketIDHash) throws TicketNotFoundException {
        CancelTicket.CancelledTicket(GetUser.ReturnUser(username),
                GetTicketList.getOneTicket(GetUser.ReturnUser(username), ticketIDHash));
    }
}
