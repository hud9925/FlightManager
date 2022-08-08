package UseCases.Admin;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightDataEditor {
    public static void Editor(String ID, String depLoc, String arrLoc, LocalTime dur, LocalDate date){
        Flight flight = FlightTracker.getInstance().getFlight(ID);
        flight.setDuration(dur);
        flight.setDepartureDate(date);
        flight.setArrivalLocation(arrLoc);
        flight.setDepartureLocation(depLoc);
    }
}
