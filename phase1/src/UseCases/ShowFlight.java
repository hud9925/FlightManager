package UseCases;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

public class ShowFlight {
    /**
     * This allows the finding of a single flight via the flight tracker.
     */

    private int flightID;

    public Flight getFlight(String flightID){
        if (FlightTracker.verifyFlight(flightID)){
            return FlightTracker.flightMap.get(flightID);
        }
        return null;
    }

}
