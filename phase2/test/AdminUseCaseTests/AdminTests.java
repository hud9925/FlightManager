package AdminUseCaseTests;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;

import Entities.User.Customer;
import Entities.User.UserTracker;
import UseCases.Admin.*;

import UseCases.Customer.ShowFlight;
import UseCases.FlightNotFoundException;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

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
    @Test(timeout = 50)
    public void testDeleteUser(){
        UserTracker ut3 = UserTracker.getInstance("someone");
        assertTrue(ut3.userExists());
        DeleteUser.removeUser("someone");
        assertFalse(ut3.userExists());
    }
    @Test(timeout = 50)
    public void testClearAllUsers(){
        Customer c1 = new Customer("CookieMonster", "cookies", LocalDate.of(2005, 6, 7), "Cookies@gmail.com", false);
        Customer c2 = new Customer("Apple", "cookies", LocalDate.of(2005, 6, 7), "Cookies@gmail.com", false);
        AddAdmin.newAdmin("someone", "probably",  LocalDate.of(2000,10,20),
                "amy");
        UserTracker.getInstance().addUser(c1);
        UserTracker.getInstance().addUser(c2);
        assertEquals(3, UserTracker.getInstance().getTotalUserCount());
        DeleteUser.ClearAllUsers("someone");
        assertEquals(1, UserTracker.getInstance().getTotalUserCount());
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
        String result =  "someone,probably,2000-10-20,amy,false,,true"+"\n";
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
    public void testCancelFlight(){
        CancelFlight.removeFlight("BC123");
        assertFalse(FlightTracker.getInstance().verifyFlight("BC123"));
    }
    @Test(timeout = 50)
    public void testCancelAllFlights(){
        CancelFlight.removeAllFlights();
        assertEquals(FlightTracker.getInstance().numFlights(), 0);
    }
    @Test(timeout = 200)
    public void testFlightDataEditor() throws FlightNotFoundException {
        Flight f1 = new Flight("AB689", 5, 6);
        AddFlight.newFlight(f1);
        FlightDataEditor.Editor("AB689","Air Canada", "Toronto",
                "Madrid",LocalTime.of(6, 7, 8) , LocalDate.now());
        assertEquals(ShowFlight.getFlight("AB689").getAirline(),"Air Canada");
        assertEquals(ShowFlight.getFlight("AB689").getDepartureLocation(), "Toronto");
        assertEquals(ShowFlight.getFlight("AB689").getArrivalLocation(), "Madrid");
        assertEquals(ShowFlight.getFlight("AB689").getDuration(), LocalTime.of(6, 7, 8));
        assertEquals(ShowFlight.getFlight("AB689").getDepartureDate(), LocalDate.now());

    }
    @Test(timeout = 50)
    public void testGenerateFlightsRandomID(){
        assertEquals(5, GenerateFlights.RandomID().length());
    }
    @Test(timeout = 50)
    public void testGenerateFlightsRandomDeparture(){
        assertEquals(10, GenerateFlights.RandomDeparture().toString().length());
    }
    @Test(timeout = 50)
    public void testGenerateFlightsRandomDepartLocation(){
        String[] Locations = new String[]{"Toronto", "Chicago", "New York City", "Vancouver", "Seattle", "Nashville"};
        assertTrue(Arrays.asList(Locations).contains(GenerateFlights.RandomDepartLocation()));
    }
    @Test(timeout = 50)
    public void testGenerateFlightsRandomArrivalLocation(){
        String[] Locations = new String[]{"Madrid", "Venice", "Buenos Aires", "New Delhi", "Moscow", "Shanghai"};
        assertTrue(Arrays.asList(Locations).contains(GenerateFlights.RandomArrivalLocation()));
    }
    @Test(timeout = 50)
    public void testGenerateFlightsRandomArrival(){
        assertEquals(10, GenerateFlights.RandomDeparture().toString().length());
    }
    @Test(timeout = 50)
    public void testGenerateFlightsRandomDuration() {
        assertEquals(8, GenerateFlights.RandomDuration().toString().length());
    }
    @Test(timeout = 200)
    public void testAddFlightGenerateFlights() {
        AddFlight.GenerateFlights();
        assertTrue(1<=FlightTracker.getInstance().numFlights() && FlightTracker.getInstance().numFlights()<=10);
    }

}

