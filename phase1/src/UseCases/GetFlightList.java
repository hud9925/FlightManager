package UseCases;
import java.util.Map;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

// A Use Case that returns details pertaining to all current Flights including
// a map of Flights; where the Integer keys of Flights Ids correspond with its associated Flight, as well as
// the number of current flights


public class GetFlightList {
    /**
     Returns a Map of all current flights
     */
    public static Map<Integer, Flight> FlightMap(){
        return FlightTracker.flightMap;
    }
    /**
     Returns the number of Current Flights
     */
    public static int NumFlights() {
        return FlightTracker.numFlights();
    }
}
