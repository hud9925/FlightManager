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
    private final String flightID;

    /**
     * This flight's airline
     */
    private String airline;

    /**
     * The seatmap containing this flight's seats
     */
    private Seatmap seats;

    /**
     * This flight's departure date
     */
    private LocalDate departureDate;

    /**
     * This flight's departure location
     */
    private String departureLocation;


    /**
     * This flight's arrival location
     */
    private String arrivalLocation;

    /**
     * This flight's duration
     */
    private LocalTime duration;

    /**
     * Constructor that creates a flight object.
     * @param flightID This flight's ID
     * @param rows The number of rows in this flight's seatmap
     * @param columns The number of columns in this flight's seatmap
     */
    public Flight(String flightID, int rows, int columns){
        this.flightID = flightID;
        this.seats = new Seatmap(rows, columns);
    }

    /**
     * Setters for each variable, the parameter takes in what needs to be set.
     */

    public void setAirline(String airline) {
        this.airline = airline;
    }


    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public void setSeats(Seatmap seatmap) { this.seats = seatmap; }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    /**
     * Getters for each variable, returns the variable
     */


    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public String getAirline() {
        return airline;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getFlightID() {
        return flightID;
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
        return this.flightID + "," + this.airline + "," + this.departureDate + ","
        + this.departureLocation + "," + this.arrivalLocation + "," + this.duration + "\n" + this.seats;
    }
}
