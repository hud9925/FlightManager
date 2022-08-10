package CustomerUseCaseTests;
import Entities.Flight.Flight;
import Entities.Flight.Seat;
import Entities.User.Customer;
import Entities.User.Ticket.Ticket;
import java.time.LocalDate;

import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import UseCases.Admin.AddFlight;
import UseCases.Customer.BuyTicket;
import UseCases.Customer.CancelTicket;
import UseCases.Customer.GetTicketList;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for UseCases that utilize tickets
 */
public class TicketUseCaseTests {
    @Test(timeout = 50)
    public void testBuyTicket() throws TicketAlreadyExistsException {
        Customer c1 = new Customer("CookieMonster", "cookies", LocalDate.of(2005, 6, 7), "Cookies@gmail.com", false);
        Flight f1 = new Flight("BC123", 8, 8);
        Seat s1 = new Seat(1, 1);
        Ticket t1 = new Ticket(f1, 0, "CookieMonster", s1);
        BuyTicket.purchasedTicket(c1, t1);
        assertEquals(1, c1.getTickets().length);
    }
    @Test(timeout = 200)
    public  void testCancelTicket() throws TicketNotFoundException, TicketAlreadyExistsException {
        LocalDate date = LocalDate.now();
        Customer c1 = new Customer("CookieMonster", "cookies", date, "Cookies@gmail.com", false);
        Flight f1 = new Flight("BC123", 8, 8);
        Seat s1 = new Seat(1, 1);
        Ticket t1 = new Ticket(f1, 0, "CookieMonster", s1);
        BuyTicket.purchasedTicket(c1, t1);
        assertEquals(1, c1.getTickets().length); // ticket currently has been bought
        CancelTicket.cancelledTicket(c1, t1);
        assertEquals(0, c1.getTickets().length); // ticket has been cancelled

    }
    @Test(timeout = 200)
    public  void testGetTicketListGetTickets() throws TicketAlreadyExistsException {
        LocalDate date = LocalDate.now();
        Customer c1 = new Customer("CookieMonster", "cookies", date, "Cookies@gmail.com", false);
        Flight f1 = new Flight("BC123", 8, 8);
        Seat s1 = new Seat(1, 1);
        Ticket t1 = new Ticket(f1, 0, "CookieMonster", s1);
        BuyTicket.purchasedTicket(c1, t1);
        assertEquals(1, GetTicketList.getTickets(c1).length);
    }
    @Test(timeout = 200)
    public  void testMultipleTicketList() throws TicketAlreadyExistsException {
        LocalDate date = LocalDate.now();
        Customer c1 = new Customer("CookieMonster", "cookies", date, "Cookies@gmail.com", false);

        Flight f1 = new Flight("BC123", 8, 8);
        Seat s1 = new Seat(1, 1);
        Seat s2 = new Seat(4, 2);
        Seat s3 = new Seat(5, 6);

        Ticket t1 = new Ticket(f1, 0, "CookieMonster", s1);
        Ticket t2 = new Ticket(f1, 0, "CookieMonster", s2);
        Ticket t3 = new Ticket(f1, 0, "CookieMonster", s3);

        BuyTicket.purchasedTicket(c1, t1);
        BuyTicket.purchasedTicket(c1, t2);
        BuyTicket.purchasedTicket(c1, t3);
        assertEquals(3, GetTicketList.getTickets(c1).length);

    }
    @Test(timeout = 200)
    public  void testGetTicketListGetOneTicket() throws TicketAlreadyExistsException {
        LocalDate date = LocalDate.now();
        Customer c1 = new Customer("CookieMonster", "cookies", date, "Cookies@gmail.com", false);

        Flight f1 = new Flight("BC123", 8, 8);

        Seat s1 = new Seat(1, 1);
        Seat s2 = new Seat(4, 2);
        Seat s3 = new Seat(5, 6);

        Ticket t1 = new Ticket(f1, 0, "CookieMonster", s1);
        Ticket t2 = new Ticket(f1, 0, "CookieMonster", s2);
        Ticket t3 = new Ticket(f1, 0, "CookieMonster", s3);

        BuyTicket.purchasedTicket(c1, t1);
        BuyTicket.purchasedTicket(c1, t2);
        BuyTicket.purchasedTicket(c1, t3);

        int ticketid =  t1.getTicketID();

        assertEquals(GetTicketList.getOneTicket(c1, ticketid), t1);
    }
    @Test(timeout = 50)
    public void testAddTicket() throws TicketAlreadyExistsException {
        Flight f1 = new Flight("BC123", 8, 8);
        AddFlight.newFlight(f1);
        Customer c1 = new Customer("Test", "test", LocalDate.of(2222,12,12),
                "sample@sample.com", false);
        assertEquals(0, c1.getTickets().length); // At this time, no tickets are found in this Customer
        Seat s1 = new Seat(8, 8);
        Ticket t1 = new Ticket(f1, 800, "Test", s1);
        c1.addTicket(t1);
        assertEquals(1, c1.getTickets().length); // Now c1 has one ticket.
    }

    @Test(timeout = 50)
    public void testRemoveTicket() throws TicketAlreadyExistsException, TicketNotFoundException {
        Flight f1 = new Flight("BC123", 8, 8);
        AddFlight.newFlight(f1);
        Customer c1 = new Customer("Test", "test", LocalDate.of(2222,12,12),
                "sample@sample.com", false);
        Seat s1 = new Seat(8, 8);
        Ticket t1 = new Ticket(f1, 800, "Test", s1);

        c1.addTicket(t1);
        assertEquals(1, c1.getTickets().length); // Now c1 has one ticket.

        c1.removeTicket(t1);
        assertEquals(0, c1.getTickets().length);
    }
}
