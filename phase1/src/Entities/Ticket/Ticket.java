package Entities.Ticket;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;
import Entities.Flight.Seat;
import Entities.User.Customer;

public class Ticket {
    private int cost;

    private Flight flight;

    private Customer who;
    private Seat where;

    public Ticket(Flight flight, int cost, Customer who, Seat where){
        if (FlightTracker.verifyFlight(flight.getFlightid())) {
            this.flight = flight;
            this.cost = cost;
            this.who = who;
            this.where = where;
        }

    }
    /**
     * This constructor assigns a ticket with a specific flight, cost, customer and the seat be assigned.
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

    public String toString() {
        return "This ticket is for flight " + getWhatFlight().getAirline() + getWhatFlight().getFlightid() +
                ", with cost " + getCost() + "dollars.\n" +
                "This ticket is assigned to the seat " + getWhere().getSeatnumber() +
                " and " + getWhom().getUsername() + " buys it.";
    }



}
