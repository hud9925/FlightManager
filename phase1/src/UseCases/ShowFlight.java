package UseCases;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

public class ShowFlight {
    /**
     * This allows the finding of a single flight via the flight tracker, or obtaining the ID of the flight
     */

    private int flightID;

    public static Flight getFlight(String flightID) throws FlightNotFoundException {
        if (FlightTracker.verifyFlight(flightID)) {
            return FlightTracker.getFlight(flightID);
        } else {
            throw new FlightNotFoundException("Sorry, the flight entered does not exist. Please try again.");
        }

    }
    public static String getFlightID(Flight flight){
        return flight.getFlightid();
    }
}
