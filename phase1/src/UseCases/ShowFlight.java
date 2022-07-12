package UseCases;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

public class ShowFlight {
    /**
     * This allows the finding of a single flight via the flight tracker.
     */

    private int flightID;

    public Flight getFlight(String flightID) throws FlightNotFoundException{
        if (FlightTracker.verifyFlight(flightID)){
            return FlightTracker.flightMap.get(flightID);
        }
        else{
            throw new FlightNotFoundException("Sorry, the flight entered does not exist. Please try again.");
        }
    }

}
