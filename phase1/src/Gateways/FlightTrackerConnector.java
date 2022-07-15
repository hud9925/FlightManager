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
            Flight newflight = lineToFlight(flightdata, newseatmap.getRows(), newseatmap.getColumns());
            newflight.setSeats(newseatmap);
            FlightTracker.addFlight(newflight);
        }
        br.close();
    }

    private Seatmap lineToSeatmap(String line) {
        // not yet implemented
        return null;
    }

    private Flight lineToFlight(String line, int row, int col) {
        // not yet implemented
        return null;
    }

    @Override
    protected String getDatabaseName () {
        return "UserDatabase";
    }
}
