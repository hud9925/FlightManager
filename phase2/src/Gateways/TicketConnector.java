package Gateways;

import Entities.Flight.Flight;
import Entities.Flight.Seat;
import Entities.User.Ticket.Ticket;
import Entities.User.TicketAlreadyExistsException;
import Entities.User.User;
import Entities.User.UserTracker;
import UseCases.FlightNotFoundException;
import UseCases.Admin.GetUser;
import UseCases.Customer.SeatViewer;
import UseCases.Customer.ShowFlight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TicketConnector extends DatabaseConnector{

    public TicketConnector() throws IOException {
        super();
    }

    /**
     * Gets the name of the database for the tickets
     * @return the name of the database
     */
    @Override
    protected String getDatabaseName() {
        return "TicketBase.csv";
    }

    /**
     * Implements save function for tickets
     */
    @Override
    public void save() throws IOException {
        List<String> allTickets = new ArrayList<>();
        for(User user: UserTracker.getInstance()){
            for(Ticket ticket: user.getTickets()){
                allTickets.add(ticket.simpleToString());
            }
        }
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        for(String string: allTickets){
            pw.write(string + "\n");
        }
        pw.close();
    }

    /**
     * Implements laod function for tickets
     */
    @Override
    public void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.filepath));
        String line;
        while((line = br.readLine())!= null) {
            Ticket ticket = lineToTicket(line);
            try {
                GetUser.returnUser(ticket.getWhom()).addTicket(ticket);
            } catch (TicketAlreadyExistsException e) {
                throw new RuntimeException(e);
            }
        }
        br.close();
    }

    /**
     * Translates a string (a line from a file) into a ticket object
     * @param line the input stream of data
     * @return the ticket object
     */
    private Ticket lineToTicket(String line) {
        String[] ticketData = line.split(",");
        Flight flight;
        Seat seat;
        try {
            flight = ShowFlight.getFlight(ticketData[0]);
            seat = SeatViewer.getSeat(flight, ticketData[2]);
        } catch (FlightNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Ticket(flight, Integer.parseInt(ticketData[1]), ticketData[3], seat);
    }
}
