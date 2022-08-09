package UseCases.Admin;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Utility admin class that edits a flight's data
 */
public class FlightDataEditor {

    /**
     * The editor method, setting the data of a flight with the given parameters
     * @param ID Flight's ID
     * @param depLoc the departure location
     * @param arrLoc the arrival location
     * @param dur the duration of flight
     * @param date the date of flight
     */
    public static void Editor(String ID, String airline, String depLoc, String arrLoc, LocalTime dur, LocalDate date){
        Flight flight = FlightTracker.getInstance().getFlight(ID);
        flight.setAirline(airline);
        flight.setDuration(dur);
        flight.setDepartureDate(date);
        flight.setArrivalLocation(arrLoc);
        flight.setDepartureLocation(depLoc);
    }
}
