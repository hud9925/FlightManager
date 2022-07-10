package UseCases;

// A Use Case That Cancels a Current Flight in FlightTracker based on the inputted Flight Id

import Entities.Flight.FlightTracker;

public class CancelFlight {
    /**
     Cancels the flight associated with the inputted ID;
     If present, the flight is removed and returns True.
     Else, returns False
     */
    public static boolean RemoveFlight(int id){
        return FlightTracker.removeFlight(id);
    }
}
