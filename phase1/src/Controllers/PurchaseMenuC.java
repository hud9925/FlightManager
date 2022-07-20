package Controllers;


import Entities.Flight.Flight;
import Entities.Ticket.Ticket;
import Entities.User.TicketAlreadyExistsException;
import Presenters.LoginConfirmMenu;

import UseCases.FlightNotFoundException;
import UseCases.GetUser;
import UseCases.SeatViewer;
import UseCases.BuyTicket;


public class PurchaseMenuC {
    public PurchaseMenuC(Flight flight, Integer row, Integer column) throws TicketAlreadyExistsException, FlightNotFoundException {
        //BuyTicket
        // For Now --> No Cost
        // Make User login again
        // create instance of ticket

        LoginConfirmMenu.LoginConfirmPrompt();
        Ticket PlaneTicket = new Ticket(flight, 0, GetUser.ReturnUser(LoginConfirmMenu.LoginConfirmPrompt()) ,
                SeatViewer.getSeat(flight, row, column));
        BuyTicket.PurchasedTicket(GetUser.ReturnUser(LoginConfirmMenu.LoginConfirmPrompt()), PlaneTicket);
        }
    }
