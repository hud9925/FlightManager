package Controllers;

import Presenters.Admin.AdminFlight;
import Presenters.Admin.AdminMenu;
import Presenters.Admin.EditFlightMenu;
import Presenters.Console;
import UseCases.Admin.CancelFlight;
import UseCases.Customer.GetFlightList;

import static UseCases.Admin.AddFlight.newFlight;

/*
 * This is the controller class for the presenter class AdminFlight, where the input from user will be sent to and
 * being processed, i.e. add flight, cancel flight, return to upper level menu
 */
public class AdminFlightC {
    /**
     * Constructor for AdminFlight Controller, takes in user's choice and assigns it to different options
     *
     * @param username The username of the current user.
     * @param choice The user's choice
     */
    public AdminFlightC(String username, String choice) {
        switch (choice){
            case "1":
                this.adminFlightOption(username);
                break;
            case "2":
                this.addFlightOption(username);
                break;
            case "3":
                this.cancelFlightOption(username);
                break;
            case "4":
                this.RemoveAllFlights(username);
                break;
            case "5":
                this.EditFlightOption(username);
                break;
            default:
                this.adminMenuOption(username);
                break;
        }
    }

    /**
     * Helper method creating a new flight based on user input and redirecting the user to the menu prompt
     *
     * @param username The username of the current user.
     * @param flightID: the ID of the single flight want to be added;
     * @param col: the number of columns of seats for this flight;
     * @param row: the number of rows of seats for this flight;
     */
    private static void addFlightResult(String username, String flightID, int col, int row) {
        newFlight(flightID, row, col);
        System.out.println("Flight " + flightID + " has been successfully added! Redirecting...");
        AdminFlight.adminFlightPrompt(username);
    }

    /**
     * Helper method cancelling a new flight based on input flight ID and redirecting the user to the menu prompt
     * Notifies if a flight with the given ID does not exist
     *
     * @param username The username of the current user.
     * @param flightID: the ID of the flight, if existing.
     */
    private static void cancelFlightResult(String username, String flightID) {
        boolean pred = CancelFlight.removeFlight(flightID);
        if (pred) {
            System.out.println("Flight " + flightID + " has been removed successfully! Redirecting...");
        }else{
            System.out.println("Flight " + flightID + " does not exist in the database! Redirecting...");
        }
        AdminFlight.adminFlightPrompt(username);
    }

    /**
     * Method that redirects admin to the main admin menu
     *
     * @param username The username of the current user.
     */
    private void adminMenuOption(String username) {
        AdminMenu.adminPrompt(username);
    }

    /**
     * Method that shows the current flight list, then redirects admin to the flight prompt menu
     *
     * @param username The username of the current user.
     */
    private void adminFlightOption(String username) {
        System.out.println("Here is a list of the current flights:\n");
        for(String flightID: GetFlightList.flightMap().keySet()){
            System.out.println(GetFlightList.flightMap().get(flightID) + "\n");
        }
        AdminFlight.adminFlightPrompt(username);
    }

    /**
     * Method that asks the admin for flight information, then calls helper method to create the flight
     *
     * @param username The username of the current user.
     */
    private void addFlightOption(String username) {
        String flightID = Console.prompt("Enter Flight ID: ", ".+");
        System.out.println("Enter the total number of seats per row (max 10): \n");
        int col = Integer.parseInt(Console.prompt("Enter the total number of seats per row (max 10): ",
                "^(\\d|(10))$"));
        System.out.println("Enter the number of rows: \n");
        int row = Console.promptForInt("Enter the number of rows: ", false);
        AdminFlightC.addFlightResult(username, flightID, col, row);
    }

    /**
     * Method that asks the admin for flight ID to be cancelled, then calls helper method to cancel the flight
     *
     * @param username The username of the current user.
     */
    private void cancelFlightOption(String username) {
        String flightID = Console.prompt("Enter Flight ID: ", ".+");
        AdminFlightC.cancelFlightResult(username, flightID);
    }

    private void EditFlightOption(String username) {
        EditFlightMenu.EditFlightPrompt(username);
    }
    /**
     * Method that Removes all Flights in the system
     *
     * @param username The username of the current user.
     */
    private void RemoveAllFlights(String username) {
        CancelFlight.removeAllFlights();
        System.out.println("All flights in the database have been removed!");
        AdminFlight.adminFlightPrompt(username);
    }
}
