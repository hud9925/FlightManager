package CustomerUseCaseTests;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;
import UseCases.Admin.AddFlight;
import UseCases.Admin.CancelFlight;
import UseCases.Customer.GetFlightList;
import UseCases.Customer.ShowFlight;
import UseCases.FlightNotFoundException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerFlightUseCaseTests {
    @Test(timeout = 50)
    public void testCancelFlight(){
        Flight f2 = new Flight("AC546", 5, 3);
        AddFlight.NewFlight(f2);
        CancelFlight.RemoveFlight("AC546");
        assertNull(FlightTracker.getInstance().getFlight("AC546"));
}
    @Test(timeout = 50)
    public void testShowFlight() throws FlightNotFoundException {
        Flight f1 = new Flight("BC123", 8, 8);
        AddFlight.NewFlight(f1);
        assertEquals(f1, ShowFlight.getFlight("BC123"));
        assertEquals("BC123", ShowFlight.getFlightID(f1));
    }
    @Test(timeout = 50)
    public void testGetFlightListFlightMap(){
        Flight f1 = new Flight("BC123", 8, 8);
        Flight f2 = new Flight("AC567", 4, 8);
        Flight f3 = new Flight("AD789", 3, 2);
        AddFlight.NewFlight(f1);
        AddFlight.NewFlight(f2);
        AddFlight.NewFlight(f3);
        assertTrue(GetFlightList.FlightMap().containsKey("BC123"));
        assertTrue(GetFlightList.FlightMap().containsKey("AC567"));
        assertTrue(GetFlightList.FlightMap().containsKey("AD789"));
        assertEquals(GetFlightList.FlightMap().size(), 3);
    }
    // Does not work currently
    @Test(timeout = 50)
    public void testGetFlightListFlightInfo(){
        AddFlight.addFirstFlight();
        assertTrue(GetFlightList.FlightInfo("MC123").containsValue("AirCanada"));

    }

}

