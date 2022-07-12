package Gateways;

import Entities.Flight.Flight;
import Entities.Flight.FlightTracker;
import Entities.Flight.Seatmap;
import UseCases.GetFlightList;

import java.io.*;
import java.nio.file.Paths;
import java.util.Map;

public class FlightTrackerConnector implements DatabaseConnector {

    private final String filepath;

    public FlightTrackerConnector() throws IOException{
        String preferredPath = getAbsolutePath("FlightDatabase.txt");
        if (fileExists(preferredPath)) {
            this.filepath = preferredPath;
            return;
        }

        String altPath = getAbsolutePath("phase1/FlightDatabase.txt");
        if (fileExists(altPath)) {
            this.filepath = altPath;
            return;
        }

        this.filepath = preferredPath;
        File preferredFile = new File(preferredPath);
        if (!preferredFile.createNewFile()) {
            throw new IOException();
        }
    }
    /**
     * Get the absolute path from a relative path.
     *
     * @param relPath The relative path to the working directory.
     * @return The absolute path.
     */
    private String getAbsolutePath (String relPath) {
        return String.valueOf(Paths.get(relPath).toAbsolutePath());
    }

    /**
     * Check if the file of a given path exists.
     *
     * @param path The path of the file to check.
     * @return A boolean indicating whether the file exists.
     */
    private boolean fileExists (String path) {
        File file = new File(path);
        return file.isFile();
    }

    public void Save() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        Map<String, Flight> allflights = GetFlightList.FlightMap();
        for(Flight flight : allflights.values()){
            pw.write(flight.toString() + "\n");
        }
        pw.close();
    }
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

    public Flight lineToFlight(String line, int row, int col) {
        // not yet implemented
        return null;
    }

    public boolean checkEmpty() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(this.filepath));
        return file.readLine() == null;
    }
}
