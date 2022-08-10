package Entities.User.Ticket;

import Entities.Flight.Flight;
import Entities.Flight.Seat;
import java.time.Instant;


public class Ticket {

    /**
     * The cost of the ticket.
     */
    private final int cost;

    /**
     * The flight associated with the ticket.
     */
    private final Flight flight;

    /**
     * The user who owns the ticket.
     */
    private final String who;

    /**
     * The passenger's seat on the flight associated with the ticket.
     */
    private final Seat where;

    /**
     * The ID of the ticket.
     */
    private final int ticketID;

    /**
     * The date and time in UTC.
     */
    private final String when;

    /**
     * This constructor creates a ticket with a specific flight, cost, customer and the seat be assigned. Works iff
     * the flight exists. This can be done through buying ticket use case.
     */
    public Ticket(Flight flight, int cost, String who, Seat where) {
        this.flight = flight;
        this.cost = cost;
        this.who = who;
        this.where = where;
        this.ticketID = setTicketHashID();

        Instant now = Instant.now();
        this.when = now.toString().substring(0, 10) + " " + now.toString().substring(11, 23) + " UTC";
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
    public String getWhom(){
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

        String plainTicketText = getWhom() + "//" +
                                 this.when + "//" +
                                 getWhatFlight().getAirline() + getWhatFlight().getFlightID() + "//" +
                                 getWhere().getSeatID() + "//";

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
        return "Flight ID: " + getWhatFlight().getFlightID() + "\nPrice: " + getCost() +
                "\nSeat ID: " + getWhere().getSeatID() + "\nPayer: " + getWhom() +
                "\nBooking time (UTC): " + getWhen() + "\nTicket ID: " + getTicketID() + "\n";
    }

    public String simpleToString(){
        return getWhatFlight().getFlightID() + "," + getCost() + "," + getWhere().getSeatID() + "," +
                getWhom() + "," + getWhen() + "," + getTicketID();
    }

}
