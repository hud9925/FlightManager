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
        assertEquals(UserTracker.getInstance().getTotalUserCount(),1);
    }
    // Buggy; awaiting completion of UserTracker
    @Test(timeout = 50)
    public void testAddAdmin(){
        AddAdmin.newAdmin("someone", "probably", LocalDate.of(2000,10,20),
                "amy");
        assertEquals(UserTracker.getInstance().getTotalUserCount(),1);
        UserTracker ut3 = UserTracker.getInstance("someone");
        UserTracker ut4 = UserTracker.getInstance("Administrator");
        assertTrue(ut3.userExists());
        assertFalse(ut4.userExists());

    }
    // Doesn't work yet; awaiting completion of UserTracker
    @Test(timeout = 50)
    public void testDeleteUser(){
        UserTracker ut3 = UserTracker.getInstance("someone");
        assertTrue(ut3.userExists());
        DeleteUser.removeUser("someone");
        assertFalse(ut3.userExists());
    }
    @Test(timeout = 50)
    public void testGetUserReturnUser(){
        AddAdmin.newAdmin("someone", "probably",  LocalDate.of(2000,10,20),
                "amy");
        assertEquals(GetUser.returnUser("someone").getUsername(), "someone");

    }
    @Test(timeout = 50)
    public void testGetUserReturnAllUser(){
//        String result = "Administrator Someone";
        String result = "Administrator";
        assertEquals(GetUser.returnAllUsers(), result);
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
        AddFlight.newFlight(f1);
        assertTrue(FlightTracker.getInstance().verifyFlight("BC123"));

    }
    @Test(timeout = 50)
    public void CancelFlight(){
        CancelFlight.removeFlight("BC123");
        assertFalse(FlightTracker.getInstance().verifyFlight("BC123"));
    }

}
