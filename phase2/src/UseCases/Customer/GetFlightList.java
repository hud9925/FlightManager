package UseCases.Customer;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* A Use Case that returns details pertaining to all current Flights including
 * the entire map of Flights; where the Integer keys of Flights Ids correspond with its associated Flight, as well as
 * the number of current flights */

public class GetFlightList {

    /**
     * Displays a Map of all the current flights saved to FlightTracker.
     * @return the map of flights
     */
    public static Map<String, Flight> flightMap(){
        return FlightTracker.getInstance().GetFlights();
    }

    /**
     * Returns a map containing the flight's information (airline, locations, date, duration).
     * @param id the ID of the flight to parse
     * @return the flight's information
     */
    public static Map<String, Object> flightInfo(String id){
        HashMap<String, Object> info = new HashMap<>();
        Flight flight = FlightTracker.getInstance().getFlight(id);
        info.put("Airline:", Objects.requireNonNull(flight).getAirline());
        info.put("Arrival Location:", Objects.requireNonNull(flight).getArrivalLocation());
        info.put("Departure Location:", Objects.requireNonNull(flight).getDepartureLocation());
        info.put("Departure Date:", Objects.requireNonNull(flight).getDepartureDate());
        info.put("Flight Duration:", Objects.requireNonNull(flight).getDuration());
    return info;

    }
}
