package Entities.Flight;

import java.util.HashMap;
import java.util.Map;

// An Entity that keeps track of current flights

public class FlightTracker {
    /**
     Hashmap that maps the Flight Id as the key, and the value being the flight itself
     */
    private final Map<String, Flight> flightMap = new HashMap<>();
    private static final FlightTracker instance = new FlightTracker();
    private FlightTracker(){}

    public static FlightTracker getInstance() {
        return instance;
    }

    /**
     Adds a flight to the map
     */
    public void addFlight(Flight newFlight){
        // adds a new flight to the Map
        flightMap.put(newFlight.getFlightID(), newFlight);
    }
    /**
     Returns the number of current flights
     */
    public int numFlights(){
        return flightMap.size();
    }
    /**
     Removes the flight associated with the inputted ID;
     If present, the flight is removed and returns True.
     Else, returns False
     */
    public boolean removeFlight(String idNum){
        return flightMap.remove(idNum) != null;
    }

    /**
     * Removes all Flights from the map
     */
    public void clearFlights(){
        flightMap.clear();
    }
    /**
     Verifies if a flight with the inputted ID exists, returning a boolean
     */

    public boolean verifyFlight(String idNum){
        return flightMap.containsKey(idNum);
    }
    /**
    A Getter that returns the FlightMap
     */
    public Map<String, Flight> GetFlights(){return flightMap;}
    /**
     Getter to retrieve the flight associated with the inputted Id
     */
    public Flight getFlight(String idNum){
        if (verifyFlight(idNum)){
            return flightMap.get(idNum);
        }
        return null;
    }
}
