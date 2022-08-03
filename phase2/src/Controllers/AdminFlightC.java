package Controllers;

import Presenters.Admin.AdminFlight;
import Presenters.Admin.AdminMenu;
import UseCases.Admin.CancelFlight;
import UseCases.Customer.GetFlightList;

import java.io.IOException;
import java.util.Scanner;

import static UseCases.Admin.AddFlight.NewFlight;

/*
 * This is the controller class for the presenter class AdminFlight, where the input from user will be sent to and
 * being processed, i.e. add flight, cancel flight, return to upper level menu
 */
public class AdminFlightC {
    /**
     * Constructor for AdminFlight Controller, takes in user's choice and assigns it to different options
     * @param whichChoice The user's choice
     */
    public AdminFlightC(int whichChoice) throws IOException {
        switch (whichChoice){
            case 0:
                this.adminMenuOption();
                break;
            case 1:
                this.adminFlightOption();
                break;
            case 2:
                this.addFlightOption();
                break;
            case 3:
                this.cancelFlightOption();
                break;

        }
    }

    /**
     * Helper method creating a new flight based on user input and redirecting the user to the menu prompt
     * @param flightID: the ID of the single flight want to be added;
     * @param col: the number of columns of seats for this flight;
     * @param row: the number of rows of seats for this flight;
     */
    public static void AddFlightResult(String flightID, int col, int row) throws IOException {
        NewFlight(flightID, row, col);
        System.out.println("Flight " + flightID + " has been successfully added! Redirecting...");
        AdminFlight.AdminFlightPrompt();
    }

    /**
     * Helper method cancelling a new flight based on input flight ID and redirecting the user to the menu prompt
     * Notifies if a flight with the given ID does not exist
     * @param flightID: the ID of the flight, if existing.
     */
    public static void CancelFlightResult(String flightID) throws IOException {
        boolean pred = CancelFlight.RemoveFlight(flightID);
        if (pred) {
            System.out.println("Flight " + flightID + " has been removed successfully! Redirecting...");
        }else{
            System.out.println("Flight " + flightID + " does not exist in the database! Redirecting...");
        }
        AdminFlight.AdminFlightPrompt();
    }

    /**
     * Method that redirects admin to the main admin menu
     */
    public void adminMenuOption() throws IOException {
        AdminMenu.AdminPrompt();
    }

    /**
     * Method that shows the current flight list, then redirects admin to the flight prompt menu
     */
    public void adminFlightOption() throws IOException {
        System.out.println(GetFlightList.FlightMap());
        AdminFlight.AdminFlightPrompt();
    }

    /**
     * Method that asks the admin for flight information, then calls helper method to create the flight
     */
    public void addFlightOption() throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Flight ID: \n");
        String flightID = sc.nextLine();
        System.out.println("Enter column number (max 10): \n");
        int col = sc.nextInt();
        System.out.println("Enter row number: \n");
        int row = sc.nextInt();
        AdminFlightC.AddFlightResult(flightID, col-1, row);
    }

    /**
     * Method that asks the admin for flight ID to be cancelled, then calls helper method to cancel the flight
     */
    public void cancelFlightOption() throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Flight ID: \n");
        String flightID = sc.nextLine();
        AdminFlightC.CancelFlightResult(flightID);

    }

}
