package UseCases;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

public class ShowFlight {

    private int flightID;

    public Flight getFlight(int flightID){
        if (FlightTracker.verifyFlight(flightID)){
            return FlightTracker.flightMap.get(flightID);
        }
        return null;
    }
}
