package Presenters.Admin;

import UseCases.Admin.FlightDataEditor;
import UseCases.Customer.GetFlightList;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class EditFlightMenu {

    public static void EditFlightPrompt() throws IOException {
        System.out.println("Here is a list of the current flights:\n");
        for(String flightID: GetFlightList.flightMap().keySet()){
            System.out.println(GetFlightList.flightMap().get(flightID) + "\n");
        }
        String ans = Console.prompt("Please enter the ID of the flight you want to edit:");
        if(GetFlightList.flightMap().get(ans) == null){
            System.out.println("A flight with that ID does not exist. Try again.");
            EditFlightPrompt();
        } else {
            FlightEditor(ans);
        }
    }
    public static void FlightEditor(String ans) throws IOException {
        String date = Console.prompt("Please enter the date of the flight (yyyy-MM-dd): ",
                "\\d{4}-[01]\\d-[0-3]\\d");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        LocalDate depDate;
        try {
            depDate = df.parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String time = Console.prompt("Please enter the duration of the flight (HH:MM):",
                "^[0-2][0-3]:[0-5][0-9]$");
        LocalTime duration = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        String arrLoc = Console.prompt("Please enter the arrival location of the flight:");
        String depLoc = Console.prompt("Please enter the departure location of the flight:");
        FlightDataEditor.Editor(ans, depLoc, arrLoc, duration, depDate);
        System.out.println("Flight has been edited. Redirecting to main admin menu...");
        AdminMenu.adminPrompt();
    }
}
