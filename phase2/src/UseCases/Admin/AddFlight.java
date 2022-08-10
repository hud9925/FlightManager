package UseCases.Admin;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

// A Use Case that adds a flight to the entity FlightTracker

public class AddFlight {
    /**
     * Adds a flight to FlightTracker.
     * @param newFlight the flight being added
     */
    public static void newFlight(Flight newFlight){
        FlightTracker.getInstance().addFlight(newFlight);
    }

    public static void newFlight(String ID, int col, int rows){
        newFlight(new Flight(ID, col, rows));
    }

    /**
     * To be used if the Flight database is empty
     * Adds the first flight, the default flight.
     */
    public static void addFirstFlight(){
        Flight defaultflight = new Flight("AB123", 5, 5);
        defaultflight.setAirline("Air Canada");
        defaultflight.setDepartureLocation("Toronto");
        defaultflight.setArrivalLocation("Venice");
        defaultflight.setDepartureDate(LocalDate.now());
        defaultflight.setDuration(LocalTime.now());
        FlightTracker.getInstance().addFlight(defaultflight);
    }
    /**
     * Populates FlightTracker with Random number of Flights (up to 10) After initialization
     */
    public static void GenerateFlights(){
        Random rand = new Random();
        int upperBound = 9;
        int numFlights = rand.nextInt(upperBound)+1;
        int n =0;
        while (n < numFlights){
            String id = GenerateFlights.RandomFlight();
            FlightDataEditor.Editor(id, GenerateFlights.RandomAirline(),
                    GenerateFlights.RandomDepartLocation(), GenerateFlights.RandomArrivalLocation(),
                    GenerateFlights.RandomDuration(), GenerateFlights.RandomDeparture());
            n++;
        }
    }
}

