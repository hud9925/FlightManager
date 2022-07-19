package Entities.Ticket;

import Entities.Flight.Flight;
import Entities.Flight.Seat;
import Entities.User.Customer;

import java.time.Instant;


public class Ticket {
    private int cost;

    private Flight flight;

    private Customer who;
    private Seat where;

    private int ticketID;

    private String when;

    /**
     * Docstrings are below each method/constructor.
     */
    public Ticket(Flight flight, int cost, Customer who, Seat where) {
        this.flight = flight;
        this.cost = cost;
        this.who = who;
        this.where = where;
        this.ticketID = setTicketHashID();

        Instant now = Instant.now();
        this.when = now.toString();
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

    public int setTicketHashID(){

        String plainTicketText = getWhom().getUsername() + "//" +
                                 this.when + "//" +
                                 getWhatFlight().getAirline() + getWhatFlight().getFlightid() + "//";

        return plainTicketText.hashCode();
    }

    /**
     * Set the unique ID of this ticket. Code reserved for future development.
     * Style: username + booking date and time in UTC + flight id -> Hash code
     */

    public int getTicketID(){
        return this.ticketID;
    }

    /**
     * @return the unique ID of this ticket.
     */

    public String getWhen(){
        return this.when;
    }

    /**
     * @return the date and time in UTC.
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
