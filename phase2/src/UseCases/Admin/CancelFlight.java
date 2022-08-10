package UseCases.Admin;

// A Use Case That Cancels a Current Flight in FlightTracker based on the inputted Flight ID

import Entities.Flight.FlightTracker;

public class CancelFlight {

    /**
     * Cancels the flight associated with the inputted ID;
     * If present, the flight is removed and returns True.
     * Else, returns False.
     * @param id ID of the cancelled flight
     * @return the flight's cancellation status
     */
    public static boolean removeFlight(String id){
        return FlightTracker.getInstance().removeFlight(id);
    }

    /**
     * Removes all Flights in FlightTracker
     *
     */
    public static void removeAllFlights(){
        FlightTracker.getInstance().clearFlights();
        }
    }
