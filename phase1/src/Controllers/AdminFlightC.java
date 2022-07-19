package Controllers;

import Entities.Flight.Flight;
import Presenters.AdminFlight;
import Presenters.AdminMenu;
import UseCases.AddFlight;
import UseCases.CancelFlight;
import UseCases.GetFlightList;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/*
 * This is the controller class for the presenter class AdminFlight, where the input from user will be sent to and
 * being processed, i.e. add flight, cancel flight, return to upper level menu
 */
public class AdminFlightC {
    public AdminFlightC(int whichChoise) throws IOException {
        switch (whichChoise){
            case 0:
                this.opt0();
                break;
            case 1:
                this.opt1();
                break;
            case 2:
                this.opt2();
                break;
            case 3:
                this.opt3();
                break;

        }
    }

    /**
     * Second Constructor for AdminFlight Controller, if the input from client is 2, i.e. adding flight.
     * @param flightID: the ID of the single flight want to be added;
     * @param col: the number of columns of seats for this flight;
     * @param row: the number of rows of seats for this flight;
     */
    public AdminFlightC(String flightID, int col, int row) throws IOException {
        Flight f = new Flight(flightID, col, row);
        AddFlight.NewFlight(f);
        AdminFlight.AdminFlightPrompt();
    }

    /**
     * Third Constructor for AdminFlight Controller, if the input from client is 3, i.e. canceling flight.
     * @param flightID: the ID of the flight, if existing.
     */
    public AdminFlightC(String flightID) throws IOException {
        boolean pred = CancelFlight.RemoveFlight(flightID);
        if (pred) {
            System.out.println("Flight " + flightID + " has been removed successfully! Redirecting...");
        }else{
            System.out.println("Flight " + flightID + " does not exist in the database! Redirecting...");
        }
        AdminFlight.AdminFlightPrompt();
    }

    public void opt0() throws IOException {
        AdminMenu.AdminPrompt();
    }

    public void opt1() throws IOException {
        Map<String, Flight> flightMap = GetFlightList.FlightMap();
        AdminFlight.AdminFlightPrompt();
    }

    public void opt2() throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Flight ID: \n");
        String flightID = sc.nextLine();
        System.out.println("Enter column number: \n");
        int col = sc.nextInt();
        System.out.println("Enter row number: \n");
        int row = sc.nextInt();

        new AdminFlightC(flightID, col, row);
        System.out.println("Flight " + flightID + " has been successfully added! Redirecting...");

    }
    public void opt3() throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Flight ID: \n");
        String flightID = sc.nextLine();

        new AdminFlightC(flightID);

    }

}
