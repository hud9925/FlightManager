package UseCases;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Objects;

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
    /**
     Returns A Map Containing the Flight information(departure date, airline, etc)
     */
    public static Map<String, Object> FlightInfo(String id){
        HashMap<String, Object> info = new HashMap<>();
        info.put("Airline:", (Objects.requireNonNull(FlightTracker.getFlight(id))).getAirline());
        info.put("Arrival Location:", Objects.requireNonNull(FlightTracker.getFlight(id)).getArrivallocation());
        info.put("Departure Location:", Objects.requireNonNull(FlightTracker.getFlight(id)).getDeparturelocation());
        info.put("Departure Date:", Objects.requireNonNull(FlightTracker.getFlight(id)).getDeparturedate());
        info.put("Flight Duration:", Objects.requireNonNull(FlightTracker.getFlight(id)).getDuration());
    return info;

    }
}
