package Presenters.Admin;

import UseCases.Admin.FlightDataEditor;
import UseCases.Customer.GetFlightList;
import Presenters.Console;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * An admin menu to edit a flight's data
 */
public class EditFlightMenu {

    /**
     * The prompt to select a flight to edit
     *
     * @param username The username of the current user.
     */
    public static void EditFlightPrompt(String username) {
        System.out.println("Here is a list of the current flights:\n");
        for(String flightID: GetFlightList.flightMap().keySet()){
            System.out.println(GetFlightList.flightMap().get(flightID) + "\n");
        }
        String ans = Console.prompt("Please enter the ID of the flight you want to edit:");
        if(GetFlightList.flightMap().get(ans) == null){
            System.out.println("A flight with that ID does not exist. Try again.");
            EditFlightPrompt(username);
        } else {
            FlightEditor(username, ans);
        }
    }

    /**
     * The editor, prompting to input flight data and then sending them to appropriate use case
     *
     * @param username The username of the current user.
     * @param ans the flight's ID
     */
    private static void FlightEditor(String username, String ans) {
        String airline = Console.prompt("Please enter the Airline of the flight");
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
        FlightDataEditor.Editor(ans, airline, depLoc, arrLoc, duration, depDate);
        System.out.println("Flight has been edited. Redirecting to main admin menu...");
        AdminMenu.adminPrompt(username);
    }
}
