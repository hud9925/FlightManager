package Presenters;
import java.util.HashMap;
import java.util.Map;

import Entities.Flight.Flight;
import UseCases.FlightNotFoundException;
import UseCases.GetFlightList;

/**
 * A Presenter Menu that Retrieves UseCase Information about Flights
 *
 */

public class FlightMenu {
    /**
     * Presents All Available Flights(by their Id) with its Arrival Location, as a map
     */
    public static void ShowDestinations(){
        Map<String, String> destinations = new HashMap<>();
        for (Map.Entry<String, Flight> flight: GetFlightList.FlightMap().entrySet()){
            String flightkey = flight.getKey();
            String destination = flight.getValue().getArrivallocation();
            destinations.put(flightkey, destination);
        }
        System.out.println("\n**********************************");
        System.out.println("Here Are All The Current Flights and Their Destinations: ");
        System.out.println("    Flight Number  "+ "    Flight Destination");
        for (Map.Entry<String, String> flight: destinations.entrySet()){
            System.out.println("    "+flight.getKey()+"    "+flight.getValue());
        }
        System.out.println("\n**********************************");
    }
    /**
     * Presents the Desired Flight with the given FlightiD
     */
    public static String SelectFlight() {
        return Console.prompt("Please enter the flight number of the flight you wish to view: ", "[A-Z]{2}[0-9]{3}");
    }

    /**
     * Presents All Current Flights as a Map
     */
    public static Map<String, Flight> ShowFlights(){
        return GetFlightList.FlightMap();

    }


}
