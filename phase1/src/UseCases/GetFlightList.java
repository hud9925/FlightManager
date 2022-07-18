package UseCases;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

import java.util.Map;

// A Use Case that returns details pertaining to all current Flights including
// the entire map of Flights; where the Integer keys of Flights Ids correspond with its associated Flight, as well as
// the number of current flights


public class GetFlightList {
    /**
     Returns a Map of flights in FlightTracker
     */
    public static Map<String, Flight> FlightMap(){
        return FlightTracker.GetFlights();
    }
    /**
     Returns the number of Current Flights
     */
    public int NumFlights() {
        return FlightTracker.numFlights();
    }
}
