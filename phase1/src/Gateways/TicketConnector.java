package Gateways;

import Entities.Flight.Flight;
import Entities.Flight.Seat;
import Entities.Ticket.Ticket;
import Entities.User.TicketAlreadyExistsException;
import Entities.User.User;
import Entities.User.UserTracker;
import UseCases.FlightNotFoundException;
import UseCases.GetUser;
import UseCases.SeatViewer;
import UseCases.ShowFlight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TicketConnector extends DatabaseConnector{

    public TicketConnector() throws IOException {
        super();
    }

    @Override
    protected String getDatabaseName() {
        return "TicketBase.csv";
    }

    @Override
    public void Save() throws IOException {
        List<String> allTickets = new ArrayList<>();
        for(User user: new UserTracker()){
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

    @Override
    public void Load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.filepath));
        String line;
        while((line = br.readLine())!= null) {
            Ticket ticket = lineToTicket(line);
            try {
                ticket.getWhom().addTicket(ticket);
            } catch (TicketAlreadyExistsException e) {
                throw new RuntimeException(e);
            }
        }
        br.close();
    }
    private Ticket lineToTicket(String line) {
        String[] ticketData = line.split(",");
        Flight flight;
        User buyer;
        Seat seat;
        try {
            flight = ShowFlight.getFlight(ticketData[0]);
            seat = SeatViewer.getSeat(flight, ticketData[2]);
            buyer = GetUser.ReturnUser(ticketData[3]);
        } catch (FlightNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Ticket(flight, Integer.parseInt(ticketData[1]),buyer, seat);
    }
}