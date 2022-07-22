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
 */

public class FlightMenu {
    /**
     * Presents All Available Flights(by their ID) with its Arrival Location, as a map,
     * and Sends User Input to Controller Class
     */
    public FlightMenu() throws FlightNotFoundException, TicketAlreadyExistsException {
        Map<String, String> destinations = new HashMap<>();
        for (Map.Entry<String, Flight> flight: GetFlightList.FlightMap().entrySet()){
            String flightKey = flight.getKey();
            String destination = flight.getValue().getArrivallocation();
            destinations.put(flightKey, destination);
        }System.out.println("\n**********************************");
        System.out.println("Here Are All The Current Flights and Their Destinations: ");
        System.out.println("    Flight Number  "+ "Flight Destination");
        for (Map.Entry<String, String> flight: destinations.entrySet()){
            System.out.println("    "+flight.getKey()+"          "+ flight.getValue());
        }
        System.out.println("\n**********************************");
        String ans = Console.prompt("Please enter the flight number of the flight you wish to view or 'back' to" +
                "leave this menu: ");
        new FlightMenuC(ans);
    }

    /**
     * Error prompt that arises if the ID inputted by the user does not correspond with an existing
     * flight's ID.
     * @throws FlightNotFoundException if the flight does not exist / isn't found
     * @throws TicketAlreadyExistsException if the ticket already exists
     */
    public static void FlightError() throws FlightNotFoundException, TicketAlreadyExistsException {
        String ans  = Console.prompt("A flight with that ID does not exist. Please re-enter the id of the flight you" +
                "wish to view, or 'back' to leave this menu");
        new FlightMenuC(ans);
    }
}
