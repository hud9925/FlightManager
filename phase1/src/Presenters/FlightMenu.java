package Presenters;
import java.util.Map;

import Entities.Flight.Flight;
import UseCases.FlightNotFoundException;
import UseCases.GetFlightList;
import UseCases.ShowFlight;

/**
 * A Presenter Menu that Retrieves UseCase Information about Flights
 *
 */

public class FlightMenu {
    /**
     * Presents All Current Flights as a Map
     */
    public static Map<String, Flight> ShowFlights(){
        return GetFlightList.FlightMap();
    }
    /**
     * Presents the Desired Flight with the given FlightiD
     */
    public static Flight RetrieveFlight(String FlightId) throws FlightNotFoundException {
        return ShowFlight.getFlight(FlightId);
    }

}
