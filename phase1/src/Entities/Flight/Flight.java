package Entities.Flight;

import java.sql.Time;
import java.util.Date;

public class Flight {

    private final String flightid;

    private String Airline;

    private String type;

    private Seatmap seats;

    private Date departuredate;

    private String departurelocation;

    private Date arrivaldate;

    private String arrivallocation;

    private Time duration;

    public Flight(String flightid, int rows, int columns){
        this.flightid = flightid;
        this.seats = new Seatmap(rows, columns);
    }

    public void setAirline(String airline) {
        Airline = airline;
    }

    public void setArrivaldate(Date arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDeparturedate(Date departuredate) {
        this.departuredate = departuredate;
    }

    public void setDeparturelocation(String departurelocation) {
        this.departurelocation = departurelocation;
    }

    public void setArrivallocation(String arrivallocation) {
        this.arrivallocation = arrivallocation;
    }

    public void setSeats(Seatmap seatmap) { this.seats = seatmap; }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Date getArrivaldate() {
        return arrivaldate;
    }

    public Date getDeparturedate() {
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

    public String getType() {
        return type;
    }

    public Seatmap getSeats() {
        return seats;
    }

    public Time getDuration() {
        return duration;
    }

    public String toString() {
        return this.flightid + "," + this.type + "," + this.Airline + "," + this.departuredate + this.arrivaldate + ","
        + this.departurelocation + "," + this.arrivallocation + "," + this.duration + "\n" + this.seats;
    }
}
