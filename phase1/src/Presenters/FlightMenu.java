package Presenters;

import Controllers.FlightMenuC;
import Entities.Flight.Flight;
import Entities.User.TicketAlreadyExistsException;
import UseCases.FlightNotFoundException;
import UseCases.GetFlightList;

import java.util.HashMap;
import java.util.Map;

/**
 * A Presenter Menu that Retrieves UseCase Information about Flights
 *
 */

public class FlightMenu {
    /**
     * Presents All Available Flights(by their Id) with its Arrival Location, as a map,
     * and Sends User Input to Controller Class
     */
    public FlightMenu() throws FlightNotFoundException, TicketAlreadyExistsException {
        Map<String, String> destinations = new HashMap<>();
        for (Map.Entry<String, Flight> flight: GetFlightList.FlightMap().entrySet()){
            String flightkey = flight.getKey();
            String destination = flight.getValue().getArrivallocation();
            destinations.put(flightkey, destination);
        }System.out.println("\n**********************************");
        System.out.println("Here Are All The Current Flights and Their Destinations: ");
        System.out.println("    Flight Number  "+ "Flight Destination");
        for (Map.Entry<String, String> flight: destinations.entrySet()){
            System.out.println("    "+flight.getKey()+"          "+ flight.getValue());
        }
        System.out.println("\n**********************************");
        String ans = Console.prompt("Please enter the flight number of the flight you wish to view: ", "[A-Z]{2}[0-9]{3}");
        new FlightMenuC(ans);
    }
        public static void FlightError() throws FlightNotFoundException, TicketAlreadyExistsException {
        String ans  = Console.prompt("A flight with that ID does not exist. Please re-enter the id of the flight you" +
                "wish to view, or type 'exit' to exit from this menu");
        new FlightMenuC(ans);

    }

}
