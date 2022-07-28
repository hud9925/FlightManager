package Gateways;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;
import Entities.Flight.Seatmap;
import UseCases.GetFlightList;

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
    public void Save() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        Map<String, Flight> allflights = GetFlightList.FlightMap();
        for(Flight flight : allflights.values()){
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
    public void Load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.filepath));
        String line;
        while((line = br.readLine())!= null) {
            String flightdata = line;
            line = br.readLine();
            Seatmap newseatmap = lineToSeatmap(line);
            Flight newflight = lineToFlight(flightdata, newseatmap);
            newflight.setSeats(newseatmap);
            FlightTracker.addFlight(newflight);
        }
        br.close();
    }

    /**
     * Helper method for translating a line into a Seatmap entity
     * @param line the line String read from the document
     * @return a Seatmap object
     */
    private Seatmap lineToSeatmap(String line) {
        String[] stringseatmap = line.split(" ");
        Seatmap sm = new Seatmap(stringseatmap.length, stringseatmap[0].length());
        for(int i = 0; i < stringseatmap.length; i++){
            String[] chars = stringseatmap[i].split("(?!^)");
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
        String[] flightdata = line.split(",");
        Flight flight = new Flight(flightdata[0], sm.getRows(), sm.getColumns());
        flight.setSeats(sm);
        flight.setAirline(flightdata[1]);
        if(flightdata[2].equals("null")){
            flight.setDeparturedate(LocalDate.now());
        } else {
            flight.setDeparturedate(LocalDate.parse(flightdata[2]));
        }
        flight.setDeparturelocation(flightdata[3]);
        flight.setArrivallocation(flightdata[4]);
        if(flightdata[5].equals("null")){
            flight.setDuration(LocalTime.now());
        } else {
            flight.setDuration(LocalTime.parse(flightdata[5]));
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
