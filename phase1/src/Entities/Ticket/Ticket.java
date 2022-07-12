package Entities.Ticket;

import Entities.Flight.Flight;
import Entities.Flight.Seat;
import Entities.User.Customer;

public class Ticket {
    private int cost;

    private Flight flight;

    private Customer who;
    private Seat where;

    private String ticketID;

    public Ticket(Flight flight, int cost, Customer who, Seat where) {
        this.flight = flight;
        this.cost = cost;
        this.who = who;
        this.where = where;
        this.ticketID = setTicketID();
    }
    /**
     * This constructor creates a ticket with a specific flight, cost, customer and the seat be assigned. Works iff
     * the flight exists. This can be done through buying ticket use case.
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * @return the cost of the ticket
     */
    public Customer getWhom(){
        return this.who;
    }
    /**
     * @return the customer who buys the ticket
     */

    public Seat getWhere(){
        return this.where;
    }
    /**
     * @return the seat this ticket referring to
     */

    public Flight getWhatFlight(){
        return this.flight;
    }

    /**
     * @return the flight this ticket referring to
     */

    public String setTicketID(){
        return null;
    }

    /**
     * Set the unique ID of this ticket. Code reserved for future development.
     * Style: username + booking date and time + flight id
     */

    public String getTicketID(){
        return this.ticketID;
    }

    /**
     *
     * @return the unique ID of this ticket. Code reserved for future development
     */

    public String toString() {
        return "This ticket is for flight " + getWhatFlight().getAirline() + getWhatFlight().getFlightid() +
                ", with cost " + getCost() + "dollars.\n" +
                "This ticket is assigned to the seat " + getWhere().getSeatid() +
                " and " + getWhom().getUsername() + " buys it.\n" +
                "Ticket ID: " + getTicketID();
    }


}
