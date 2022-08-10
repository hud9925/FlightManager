package Controllers;

import Presenters.Admin.AdminFlight;
import Presenters.Admin.AdminMenu;
import Presenters.Admin.EditFlightMenu;
import UseCases.Admin.CancelFlight;
import UseCases.Customer.GetFlightList;

import java.util.Scanner;

import static UseCases.Admin.AddFlight.newFlight;

/*
 * This is the controller class for the presenter class AdminFlight, where the input from user will be sent to and
 * being processed, i.e. add flight, cancel flight, return to upper level menu
 */
public class AdminFlightC {
    /**
     * Constructor for AdminFlight Controller, takes in user's choice and assigns it to different options
     * @param choice The user's choice
     */
    public AdminFlightC(String choice) {
        switch (choice){
            case "1":
                this.adminFlightOption();
                break;
            case "2":
                this.addFlightOption();
                break;
            case "3":
                this.cancelFlightOption();
                break;
            case "4":
                this.RemoveAllFlights();
                break;
            case "5":
                this.EditFlightOption();
                break;
            default:
                this.adminMenuOption();
                break;
        }
    }

    /**
     * Helper method creating a new flight based on user input and redirecting the user to the menu prompt
     * @param flightID: the ID of the single flight want to be added;
     * @param col: the number of columns of seats for this flight;
     * @param row: the number of rows of seats for this flight;
     */
    public static void addFlightResult(String flightID, int col, int row) {
        newFlight(flightID, row, col);
        System.out.println("Flight " + flightID + " has been successfully added! Redirecting...");
        AdminFlight.adminFlightPrompt();
    }

    /**
     * Helper method cancelling a new flight based on input flight ID and redirecting the user to the menu prompt
     * Notifies if a flight with the given ID does not exist
     * @param flightID: the ID of the flight, if existing.
     */
    public static void cancelFlightResult(String flightID) {
        boolean pred = CancelFlight.removeFlight(flightID);
        if (pred) {
            System.out.println("Flight " + flightID + " has been removed successfully! Redirecting...");
        }else{
            System.out.println("Flight " + flightID + " does not exist in the database! Redirecting...");
        }
        AdminFlight.adminFlightPrompt();
    }

    /**
     * Method that redirects admin to the main admin menu
     */
    public void adminMenuOption() {
        AdminMenu.adminPrompt();
    }

    /**
     * Method that shows the current flight list, then redirects admin to the flight prompt menu
     */
    public void adminFlightOption() {
        System.out.println("Here is a list of the current flights:\n");
        for(String flightID: GetFlightList.flightMap().keySet()){
            System.out.println(GetFlightList.flightMap().get(flightID) + "\n");
        }
        AdminFlight.adminFlightPrompt();
    }

    /**
     * Method that asks the admin for flight information, then calls helper method to create the flight
     */
    public void addFlightOption() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Flight ID: \n");
        String flightID = sc.nextLine();
        System.out.println("Enter the total number of seats per row (max 10): \n");
        int col = sc.nextInt();
        System.out.println("Enter the number of rows: \n");
        int row = sc.nextInt();
        AdminFlightC.addFlightResult(flightID, col, row);
    }

    /**
     * Method that asks the admin for flight ID to be cancelled, then calls helper method to cancel the flight
     */
    public void cancelFlightOption() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Flight ID: \n");
        String flightID = sc.nextLine();
        AdminFlightC.cancelFlightResult(flightID);

    }

    public void EditFlightOption() {
        EditFlightMenu.EditFlightPrompt();
    }
    /**
     * Method that Removes all Flights in the system
     */
    public void RemoveAllFlights() {
        CancelFlight.removeAllFlights();
        System.out.println("All flights in the database have been removed!");
        AdminFlight.adminFlightPrompt();
    }
}
