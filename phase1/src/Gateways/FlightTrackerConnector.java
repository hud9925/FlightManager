package Gateways;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;
import Entities.Flight.Seatmap;
import UseCases.GetFlightList;

import java.io.*;
import java.util.Map;

public class FlightTrackerConnector extends DatabaseConnector {
    public FlightTrackerConnector() throws IOException {
    }

    @Override
    public void Save() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        Map<String, Flight> allflights = GetFlightList.FlightMap();
        for(Flight flight : allflights.values()){
            pw.write(flight.toString() + "\n");
        }
        pw.close();
    }

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

    private Flight lineToFlight(String line, Seatmap sm) {
        String[] flightdata = line.split(",");
        Flight flight = new Flight(flightdata[0], sm.getRows(), sm.getColumns());
        flight.setSeats(sm);
        flight.setType(flightdata[1]);
        flight.setAirline(flightdata[2]);
        flight.setDeparturelocation(flightdata[5]);
        flight.setArrivallocation(flightdata[6]);
        return flight;
    }

    @Override
    protected String getDatabaseName () {
        return "FlightDatabase.txt";
    }
}
