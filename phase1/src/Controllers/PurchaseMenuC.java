package Controllers;


import Entities.Flight.Flight;
import Entities.Ticket.Ticket;
import Entities.User.TicketAlreadyExistsException;
import Presenters.LoginConfirmMenu;
import Presenters.FlightMenu;

import Presenters.PurchaseMenu;
import UseCases.*;

import java.util.Objects;

/**
 * A controller that prompts the User to Login again to confirm their ticketPurchase, and to update the seat to now
 * be occupied. Allows User to keep buying additional tickets, or return the User to the Flight Menu.
 */
public class PurchaseMenuC {

    /**
     * Allows the user to purchase a ticket for a flight and a specific seat on that flight based on the seat's row and
     * column.
     * @param flight flight to purchase
     * @param row row of the requested seat
     * @param column column of the requested seat
     * @throws TicketAlreadyExistsException if the ticket already exists
     * @throws FlightNotFoundException if the flight does not exist
     */
    public PurchaseMenuC(Flight flight, Integer row, Integer column) throws TicketAlreadyExistsException, FlightNotFoundException {

        String ans = LoginConfirmMenu.LoginConfirmPrompt();
        if (Objects.equals(ans, "exit")){
            PurchaseMenu.PurchaseMenuPrompt((ShowFlight.getFlightID(flight)));
        }
        else {
            Ticket PlaneTicket = new Ticket(flight, 0, GetUser.ReturnUser(ans) ,
                    SeatViewer.getSeat(flight, row, column));
            BuyTicket.PurchasedTicket(GetUser.ReturnUser(ans), PlaneTicket);
            SeatViewer.fillSeat(flight, row, column);
            String AnotherTicket = PurchaseMenu.PurchaseAnotherTicket();
            if (AnotherTicket.equals("yes")){
                PurchaseMenu.PurchaseMenuPrompt(ShowFlight.getFlightID(flight));
            }
            else{
                new FlightMenu();
            }
        }

        }
    }
