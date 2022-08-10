package Controllers;


import Entities.Flight.Flight;
import Entities.User.Ticket.Ticket;
import Entities.User.TicketAlreadyExistsException;
import Presenters.Customer.LoginConfirmMenu;
import Presenters.Customer.FlightMenu;

import Presenters.Customer.PurchaseMenu;
import UseCases.*;
import UseCases.Admin.GetUser;
import UseCases.Customer.BuyTicket;
import UseCases.Customer.SeatViewer;
import UseCases.Customer.ShowFlight;

import java.util.Objects;

/**
 * A controller that prompts the User to Login again to confirm their ticketPurchase, and to update the seat to now
 * be occupied. Allows User to keep buying additional tickets, or return the User to the Flight Menu.
 */
public class PurchaseMenuC {

    /**
     * Allows the user to purchase a ticket for a flight and a specific seat on that flight based on the seat's row and
     * column.
     *
     * @param username The username of the current user.
     * @param flight flight to purchase
     * @param row row of the requested seat
     * @param column column of the requested seat
     * @throws TicketAlreadyExistsException if the ticket already exists
     * @throws FlightNotFoundException if the flight does not exist
     */
    public PurchaseMenuC(String username, Flight flight, Integer row, Integer column) throws TicketAlreadyExistsException, FlightNotFoundException {

        String ans = LoginConfirmMenu.loginConfirmPrompt(username);
        if (Objects.equals(ans, "exit")){
            PurchaseMenu.purchaseMenuPrompt(username, ShowFlight.getFlightID(flight));
        }
        else {
            Ticket PlaneTicket = new Ticket(flight, 0, GetUser.returnUser(ans).getUsername() ,
                    SeatViewer.getSeat(flight, row, column));
            BuyTicket.purchasedTicket(GetUser.returnUser(ans), PlaneTicket);
            SeatViewer.fillSeat(flight, row, column);
            String AnotherTicket = PurchaseMenu.purchaseAnotherTicket();
            if (AnotherTicket.equals("yes")){
                PurchaseMenu.purchaseMenuPrompt(username, ShowFlight.getFlightID(flight));
            }
            else{
                FlightMenu.flightMenuPrompt(username);
            }
        }

        }
    }
