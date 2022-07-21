import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;
import Entities.User.Customer;
import Entities.User.User;
import Entities.User.UserTracker;
import UseCases.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSuite {

    @Test(timeout = 50)
    public void testAddFirstAdmin(){
        AddAdmin.addFirstAdmin();
        assertEquals(UserTracker.getTotalUserCount(),1);
    }
    @Test(timeout = 50)
    public void testAddNewAdmin(){
        AddAdmin.NewAdmin("someone", "probably", 2111, 12, 31, "amy");
        assertEquals(UserTracker.getTotalUserCount(),1);

        UserTracker ut3 = new UserTracker("someone");
        UserTracker ut4 = new UserTracker("Administrator");
        assertTrue(ut3.userExists());
        assertFalse(ut4.userExists());
    }
    @Test(timeout = 50)
    public void testAddFirstFlight(){
        AddFlight.addFirstFlight();
        assertEquals(FlightTracker.numFlights(),1);
        assertTrue(FlightTracker.verifyFlight("AB123"));
    }

    @Test(timeout = 50)
    public void testAddFlight(){
        Flight f1 = new Flight("BC123", 8, 8);
        AddFlight.NewFlight(f1);
        assertEquals(FlightTracker.numFlights(),1);
        assertTrue(FlightTracker.verifyFlight("BC123"));
    }
    @Test(timeout = 50)
    public void testRemoveUser(){

    }
    @Test(timeout = 50)
    public void testCancelFlight(){

    }

    @Test(timeout = 50)
    public void testReturnUser(){

    }

    @Test(timeout = 50)
    public void testLoginUseCase(){
        
    }
    @Test(timeout = 50)
    public void testRegisterUseCase(){
        assertTrue(RegisterUseCase.NewUser("C1", "P1", 1111, 12, 41, "ma214"));
        assertFalse(RegisterUseCase.NewUser("C1", "P1", 1111, 12, 41, "ma214"));
    }
    @Test(timeout = 50)
    public void testShowFlight() throws FlightNotFoundException {
        Flight f1 = new Flight("BC123", 8, 8);
        AddFlight.NewFlight(f1);
        assertEquals(f1, ShowFlight.getFlight("BC123"));
        assertEquals("BC123", ShowFlight.getFlightID(f1));
    }
    @Test(timeout = 50)
    public void testSeeAccountDetails(){
        User u1 = new Customer("C1", "P1", 1111, 12, 41, "ma214",
                true);
        assertEquals(SeeAccountDetails.AccountDetails("A1"), "User does not exist");
        assertEquals(SeeAccountDetails.AccountDetails("P1"), u1.toString());
    }
}
