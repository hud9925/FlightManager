package Entities.Flight;

import java.util.HashMap;
import java.util.Map;

// An Entity that keeps track of current flights



public class FlightTracker {
    /**
     Hashmap that maps the Flight Id as the key, and the value being the flight itself
     */
    public static Map<Integer, Flight> flightMap = new HashMap<>();

    /**
     Adds a flight to the map
     */
    public static void addFlight(Flight newFlight){
        // adds a new flight to the Map
        flightMap.put(newFlight.getId(), Flight);
    }
    /**
     Returns the number of current flights
     */
    public static int numFlights(){
        return flightMap.size();
    }
    /**
     Removes the flight associated with the inputted ID;
     If present, the flight is removed and returns True.
     Else, returns False
     */
    public static boolean removeFlight(int idNum){
        return flightMap.remove(idNum) != null;
    }
    /**
     Verifies if a flight with the inputted ID exists, returning a boolean
     */

    public static boolean verifyFlight(int idNum){
        return flightMap.containsKey(idNum);
    }
    /**
     Getter to retrieve the flight associated with the inputted Id
     */
    public Flight getFlight(int idNum){
        if (verifyFlight(idNum)){
            return flightMap.get(idNum);
        }
        return null;
    }

    }
