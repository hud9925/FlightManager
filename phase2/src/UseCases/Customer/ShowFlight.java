package UseCases.Customer;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;
import UseCases.FlightNotFoundException;

public class ShowFlight {
    /**
     * This allows the finding of a single flight via the flight tracker, or obtaining the ID of the flight
     */
    
    public static Flight getFlight(String flightID) throws FlightNotFoundException {
        if (FlightTracker.getInstance().verifyFlight(flightID)) {
            return FlightTracker.getInstance().getFlight(flightID);
        } else {
            throw new FlightNotFoundException("Sorry, the flight entered does not exist. Please try again.");
        }

    }
    public static String getFlightID(Flight flight){
        return flight.getFlightID();
    }
}
