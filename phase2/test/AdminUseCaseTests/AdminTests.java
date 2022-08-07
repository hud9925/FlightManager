package AdminUseCaseTests;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

import Entities.User.UserTracker;
import UseCases.Admin.*;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Tests for all methods within the Admin UseCase package
 */
public class AdminTests {
    @Test(timeout = 50)
    public void testAddFirstAdmin(){
        AddAdmin.addFirstAdmin();
        assertEquals(UserTracker.getInstance().getTotalUserCount(), 1);

    }
    // Buggy; awaiting completion of UserTracker
    @Test(timeout = 50)
    public void testAddAdmin(){
        AddAdmin.newAdmin("someone", "probably", LocalDate.of(2000,10,20),
                "amy");
        assertEquals(UserTracker.getInstance().getTotalUserCount(),1);
        UserTracker ut3 = UserTracker.getInstance("someone");
        assertTrue(ut3.userExists());
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
    @Test(timeout = 150)
    public void testGetUserReturnAllUser(){
        AddAdmin.newAdmin("someone", "probably",  LocalDate.of(2000,10,20),
                "amy");
        String result =  "someone,probably,2000-10-20,amy,false,,true";
        assertEquals(GetUser.returnAllUsers(), result);
    }
    @Test(timeout = 100)
    public void testAddFirstFlight(){
        assertEquals(FlightTracker.getInstance().numFlights(), 0);
        AddFlight.addFirstFlight();
        assertEquals(FlightTracker.getInstance().numFlights(), 1);
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
    @Test(timeout = 50)
    public void CancelAllFlights(){
        CancelFlight.removeAllFlights();
        assertEquals(FlightTracker.getInstance().numFlights(), 0);
    }

}
