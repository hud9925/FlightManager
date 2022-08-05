package CustomerUseCaseTests;
import Entities.Flight.Flight;
import Entities.Flight.Seat;
import Entities.User.Customer;
import Entities.User.Ticket.Ticket;
import java.time.LocalDate;
import java.util.Arrays;

import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import UseCases.Customer.BuyTicket;
import UseCases.Customer.CancelTicket;
import UseCases.Customer.GetTicketList;

import org.junit.Test;
import static org.junit.Assert.*;


public class TicketUseCaseTests {
    @Test(timeout = 50)
    public void testBuyTicket() throws TicketAlreadyExistsException, TicketNotFoundException {
        LocalDate date = LocalDate.now();
        Customer c1 = new Customer("CookieMonster", "cookies", date, "Cookies@gmail.com", false);
        Flight f1 = new Flight("BC123", 8, 8);
        Seat s1 = new Seat(1, 1);
        Ticket t1 = new Ticket(f1, 0, c1, s1);
        BuyTicket.PurchasedTicket(c1, t1);
        assertEquals(GetTicketList.getOneTicket(c1, t1.getTicketID()), t1);
        CancelTicket.CancelledTicket(c1, t1);
    }
    @Test(timeout = 50)
    public  void testCancelTicket() throws TicketNotFoundException, TicketAlreadyExistsException {
        LocalDate date = LocalDate.now();
        Customer c1 = new Customer("CookieMonster", "cookies", date, "Cookies@gmail.com", false);
        Flight f1 = new Flight("BC123", 8, 8);
        Seat s1 = new Seat(1, 1);
        Ticket t1 = new Ticket(f1, 0, c1, s1);
        BuyTicket.PurchasedTicket(c1, t1);
        assertEquals(GetTicketList.getOneTicket(c1, t1.getTicketID()), t1);
        CancelTicket.CancelledTicket(c1, t1);

//        assertTrue(Arrays.stream(GetTicketList.getTickets(c1)).noneMatch(ticket -> ticket.getTicketID() == t1.getTicketID()));

    }

}
