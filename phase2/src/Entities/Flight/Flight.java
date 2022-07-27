package Entities.Flight;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Entity class that represents a flight in the system
 * Stores flight data + getters/setters
 */
public class Flight {

    /**
     * This flight's name (ID)
     */
    private final String flightid;

    /**
     * This flight's airline
     */
    private String Airline;

    /**
     * The seatmap containing this flight's seats
     */
    private Seatmap seats;

    /**
     * This flight's departure date
     */
    private LocalDate departuredate;

    /**
     * This flight's departure location
     */
    private String departurelocation;


    /**
     * This flight's arrival location
     */
    private String arrivallocation;

    /**
     * This flight's duration
     */
    private LocalTime duration;

    /**
     * Constructor that creates a flight object.
     * @param flightid This flight's ID
     * @param rows The number of rows in this flight's seatmap
     * @param columns The number of columns in this flight's seatmap
     */
    public Flight(String flightid, int rows, int columns){
        this.flightid = flightid;
        this.seats = new Seatmap(rows, columns);
    }

    /**
     * Setters for each variable, the parameter takes in what needs to be set.
     */

    public void setAirline(String airline) {
        Airline = airline;
    }


    public void setDeparturedate(LocalDate departuredate) {
        this.departuredate = departuredate;
    }

    public void setDeparturelocation(String departurelocation) {
        this.departurelocation = departurelocation;
    }

    public void setArrivallocation(String arrivallocation) {
        this.arrivallocation = arrivallocation;
    }

    public void setSeats(Seatmap seatmap) { this.seats = seatmap; }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    /**
     * Getters for each variable, returns the variable
     */


    public LocalDate getDeparturedate() {
        return departuredate;
    }

    public String getAirline() {
        return Airline;
    }

    public String getArrivallocation() {
        return arrivallocation;
    }

    public String getDeparturelocation() {
        return departurelocation;
    }

    public String getFlightid() {
        return flightid;
    }

    public Seatmap getSeats() {
        return seats;
    }

    public LocalTime getDuration() {
        return duration;
    }

    /**
     * Method that returns this flight's data, in string format.
     * Each variable is separated by a comma, and the seatmap is in a new line.
     */
    public String toString() {
        return this.flightid + "," + this.Airline + "," + this.departuredate  + ","
        + this.departurelocation + "," + this.arrivallocation + "," + this.duration + "\n" + this.seats;
    }
}
