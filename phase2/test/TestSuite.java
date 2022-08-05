import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;
import Entities.User.UserTracker;
import UseCases.*;
import UseCases.Admin.AddAdmin;
import UseCases.Admin.AddFlight;
import UseCases.Admin.CancelFlight;
import UseCases.Admin.GetUser;
import UseCases.Customer.LoginUseCase;
import UseCases.Customer.RegisterUseCase;
import UseCases.Customer.ShowFlight;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestSuite {

    @Test(timeout = 50)
    public void testAddFirstAdmin(){
        AddAdmin.addFirstAdmin();
        assertEquals(UserTracker.getTotalUserCount(),1);
    }
    @Test(timeout = 50)
    public void testAddNewAdmin(){
        AddAdmin.newAdmin("someone", "probably", LocalDate.of(2000,10,20),
                "amy");
        assertEquals(UserTracker.getTotalUserCount(),1);

        UserTracker ut3 = new UserTracker("someone");
        UserTracker ut4 = new UserTracker("Administrator");
        assertTrue(ut3.userExists());
        assertFalse(ut4.userExists());
    }
    @Test(timeout = 50)
    public void testAddFirstFlight(){
        AddFlight.addFirstFlight();
        assertEquals(FlightTracker.getInstance().numFlights(),1);
        assertTrue(FlightTracker.getInstance().verifyFlight("AB123"));
    }

    @Test(timeout = 50)
    public void testAddFlight(){
        Flight f1 = new Flight("BC123", 8, 8);
        AddFlight.newFlight(f1);
        assertTrue(FlightTracker.getInstance().verifyFlight("BC123"));
    }
    @Test(timeout = 50)
    public void testRemoveUser(){
        UserTracker ut3 = new UserTracker("someone");
        ut3.removeCurrentUser();
        assertFalse(ut3.userExists());

    }
    @Test(timeout = 50)
    public void testCancelFlight(){
        Flight f2 = new Flight("AC546", 5, 3);
        AddFlight.newFlight(f2);
        CancelFlight.removeFlight("AC546");
        assertNull(FlightTracker.getInstance().getFlight("AC546"));

    }
    @Test(timeout = 50)
    public void testReturnUser(){
        AddAdmin.newAdmin("someone", "probably",  LocalDate.of(2000,10,20),
                "amy");
        assertEquals(GetUser.returnUser("someone").getUsername(), "someone");

    }
    @Test(timeout = 50)
    public void testLoginUseCase(){
        AddAdmin.newAdmin("someone", "probably",  LocalDate.of(2000,10,20),
                "amy");
        ArrayList<Boolean> Predicates = new ArrayList<>();
        Predicates.add(true);
        Predicates.add(true);
        assertEquals(Predicates, LoginUseCase.userType("someone", "probably"));
    }
    @Test(timeout = 50)
    public void testRegisterUseCase(){
        assertTrue(RegisterUseCase.newUser("C1", "P1", LocalDate.of(1111, 12, 21)
                , "ma214"));
        assertFalse(RegisterUseCase.newUser("C1", "P1", LocalDate.of(1111, 12, 21)
                , "ma214"));
    }
    @Test(timeout = 50)
    public void testShowFlight() throws FlightNotFoundException {
        Flight f1 = new Flight("BC123", 8, 8);
        AddFlight.newFlight(f1);
        assertEquals(f1, ShowFlight.getFlight("BC123"));
        assertEquals("BC123", ShowFlight.getFlightID(f1));
    }
}
