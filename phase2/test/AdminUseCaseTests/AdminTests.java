package AdminUseCaseTests;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;
import Entities.User.UserTracker;
import UseCases.Admin.*;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AdminTests {
    @Test(timeout = 50)
    public void testAddFirstAdmin(){
        AddAdmin.addFirstAdmin();
        assertEquals(UserTracker.getTotalUserCount(),1);
    }
    // Buggy; awaiting completion of UserTracker
    @Test(timeout = 50)
    public void testAddAdmin(){
        AddAdmin.NewAdmin("someone", "probably", LocalDate.of(2000,10,20),
                "amy");
        assertEquals(UserTracker.getTotalUserCount(),1);
        UserTracker ut3 = new UserTracker("someone");
        UserTracker ut4 = new UserTracker("Administrator");
        assertTrue(ut3.userExists());
        assertFalse(ut4.userExists());

    }
    // Doesn't work yet; awaiting completion of UserTracker
    @Test(timeout = 50)
    public void testDeleteUser(){
        UserTracker ut3 = new UserTracker("someone");
        assertTrue(ut3.userExists());
        DeleteUser.RemoveUser("someone");
        assertFalse(ut3.userExists());
    }
    @Test(timeout = 50)
    public void testGetUserReturnUser(){
        AddAdmin.NewAdmin("someone", "probably",  LocalDate.of(2000,10,20),
                "amy");
        assertEquals(GetUser.ReturnUser("someone").getUsername(), "someone");

    }
    @Test(timeout = 50)
    public void testGetUserReturnAllUser(){
//        String result = "Administrator Someone";
        String result = "Administrator";
        assertEquals(GetUser.ReturnAllUsers(), result);
    }
    @Test(timeout = 50)
    public void testAddFirstFlight(){
        AddFlight.addFirstFlight();
        assertEquals(FlightTracker.getInstance().numFlights(),1);
//        assertTrue(FlightTracker.getInstance().verifyFlight("AB123"));
    }
    @Test(timeout = 50)
    public void testNewFlight(){
        Flight f1 = new Flight("BC123", 8, 8);
        AddFlight.NewFlight(f1);
        assertTrue(FlightTracker.getInstance().verifyFlight("BC123"));

    }
    @Test(timeout = 50)
    public void CancelFlight(){
        CancelFlight.RemoveFlight("BC123");
        assertFalse(FlightTracker.getInstance().verifyFlight("BC123"));
    }

}
