package Entities.Ticket;

import Entities.Flight.Flight;
import Entities.Flight.Seat;
import Entities.User.Customer;
import Entities.User.User;

import java.time.Instant;


public class Ticket {
    private int cost;

    private Flight flight;

    private User who;
    private Seat where;

    private int ticketID;

    private String when;

    /**
     * This constructor creates a ticket with a specific flight, cost, customer and the seat be assigned. Works iff
     * the flight exists. This can be done through buying ticket use case.
     */
    public Ticket(Flight flight, int cost, User who, Seat where) {
        this.flight = flight;
        this.cost = cost;
        this.who = who;
        this.where = where;
        this.ticketID = setTicketHashID();

        Instant now = Instant.now();
        this.when = now.toString();
    }

    /**
     * @return the price of the ticket.
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * @return the customer who buys the ticket
     */
    public User getWhom(){
        return this.who;
    }

    /**
     * @return the seat this ticket referring to
     */
    public Seat getWhere(){
        return this.where;
    }

    /**
     * @return the flight this ticket referring to
     */
    public Flight getWhatFlight(){
        return this.flight;
    }


    /**
     * Set the unique ID of this ticket. Code reserved for future development.
     * Style: username + booking date and time in UTC + flight id -> Hash code
     */
    public int setTicketHashID(){

        String plainTicketText = getWhom().getUsername() + "//" +
                                 this.when + "//" +
                                 getWhatFlight().getAirline() + getWhatFlight().getFlightid() + "//";

        return plainTicketText.hashCode();
    }


    /**
     * @return the unique ID of this ticket.
     */
    public int getTicketID(){
        return this.ticketID;
    }


    /**
     * @return the date and time in UTC.
     */

    public String getWhen(){
        return this.when;
    }



    /**
     * Return the String representation of a ticket.
     */

    public String toString() {
        return "Flight: " + getWhatFlight().getAirline() + getWhatFlight().getFlightid() + "\n" +
                "Price: " + getCost() + " dollars.\n" +
                "Seat ID: " + getWhere().getSeatid() + "\n" +
                "Payer: " + getWhom().getUsername() + "\n" +
                "Booking time (UTC): " + getWhen() +
                "Ticket ID: " + getTicketID() + "\n";
    }

}
