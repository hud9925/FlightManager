package Gateways;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;
import Entities.Flight.Seatmap;
import UseCases.Customer.GetFlightList;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

/**
 * Class extending the DatabaseConnector
 * Used for saving all the Flight data in the program
 */
public class FlightTrackerConnector extends DatabaseConnector {

    public FlightTrackerConnector() throws IOException {
        super();
    }

    /**
     * Implements the abstract save operation of DatabaseConnector
     * Saves the FlightTracker to a file with specified filepath
     * @throws IOException - in case of meaningless input
     */
    @Override
    public void save() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        Map<String, Flight> allFlights = GetFlightList.flightMap();
        for(Flight flight : allFlights.values()){
            pw.write(flight.toString() + "\n");
        }
        pw.close();
    }

    /**
     * Implements the abstract load operation of DatabaseConnector
     * Reads flights from a file with specified directory and adds them to the FlightTracker
     * @throws IOException - in case of meaningless input
     */
    @Override
    public void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.filepath));
        String line;
        while((line = br.readLine())!= null) {
            String flightData = line;
            line = br.readLine();
            Seatmap newSeatmap = lineToSeatmap(line);
            Flight newFlight = lineToFlight(flightData, newSeatmap);
            newFlight.setSeats(newSeatmap);
            FlightTracker.getInstance().addFlight(newFlight);
        }
        br.close();
    }

    /**
     * Helper method for translating a line into a Seatmap entity
     * @param line the line String read from the document
     * @return a Seatmap object
     */
    private Seatmap lineToSeatmap(String line) {
        String[] stringSeatmap = line.split(" ");
        Seatmap sm = new Seatmap(stringSeatmap.length, stringSeatmap[0].length());
        for(int i = 0; i < stringSeatmap.length; i++){
            String[] chars = stringSeatmap[i].split("(?!^)");
            for(int j = 0; j < chars.length; j++){
                if(chars[j].equals("O")){
                    sm.getSeat(i,j).fill();
                }
            }
        }
        return sm;
    }
    /**
     * Helper method for translating a line into a User entity
     * @param line the line String read from the document containing flight properties (minus the seatmap)
     * @param sm the flight's seatmap
     * @return a Flight object
     */
    private Flight lineToFlight(String line, Seatmap sm) {
        String[] flightData = line.split(",");
        Flight flight = new Flight(flightData[0], sm.getRows(), sm.getColumns());
        flight.setSeats(sm);
        flight.setAirline(flightData[1]);
        if(flightData[2].equals("null")){
            flight.setDepartureDate(LocalDate.now());
        } else {
            flight.setDepartureDate(LocalDate.parse(flightData[2]));
        }
        flight.setDepartureLocation(flightData[3]);
        flight.setArrivalLocation(flightData[4]);
        if(flightData[5].equals("null")){
            flight.setDuration(LocalTime.now());
        } else {
            flight.setDuration(LocalTime.parse(flightData[5]));
        }
        return flight;
    }

    /**
     * Implements the abstract method in DatabaseConnector, with the specified filepath
     * @return the filepath (string)
     */
    @Override
    protected String getDatabaseName () {
        return "FlightDatabase.txt";
    }
}
