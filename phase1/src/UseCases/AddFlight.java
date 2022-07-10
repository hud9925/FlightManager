package UseCases;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

// A Use Case that adds a flight to the entity FlightTracker

public class AddFlight {
    /**
     Adds a flight to FlightTracker
     */
    public void NewFlight(Flight newFlight){
        FlightTracker.addFlight(newFlight);
    }
}
