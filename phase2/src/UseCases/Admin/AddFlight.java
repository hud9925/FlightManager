package UseCases.Admin;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

import java.time.LocalDate;
import java.time.LocalTime;

// A Use Case that adds a flight to the entity FlightTracker

public class AddFlight {
    /**
     * Adds a flight to FlightTracker.
     * @param newFlight the flight being added
     */
    public static void NewFlight(Flight newFlight){
        FlightTracker.addFlight(newFlight);
    }

    public static void NewFlight(String ID, int col, int rows){
        NewFlight(new Flight(ID, col, rows));
    }

    /**
     * To be used if the Flight database is empty
     * Adds the first flight, the default flight.
     */
    public static void addFirstFlight(){
        Flight defaultflight = new Flight("AB123", 5, 5);
        defaultflight.setDeparturedate(LocalDate.now());
        defaultflight.setDuration(LocalTime.now());
        FlightTracker.addFlight(defaultflight);
    }
}
