package Controllers;

import Entities.Flight.Flight;
import Presenters.AdminMenu;
import UseCases.AddFlight;
import UseCases.CancelFlight;
import UseCases.GetFlightList;

import java.io.IOException;
import java.util.Scanner;

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
    public AdminFlightC(String flightID, int col, int row){
        Flight f = new Flight(flightID, col, row);
        AddFlight.NewFlight(f);
    }

    /**
     * Third Constructor for AdminFlight Controller, if the input from client is 3, i.e. canceling flight.
     * @param flightID: the ID of the flight, if existing.
     */
    public AdminFlightC(String flightID) {
        boolean pred = CancelFlight.RemoveFlight(flightID);
        if (pred) {
            System.out.println("Flight " + flightID + " has been removed successfully!");
        }else{
            System.out.println("Flight " + flightID + " does not exist in the database!");
        }
    }

    public void opt0() throws IOException {
        AdminMenu.AdminPrompt();
    }

    public void opt1(){
        GetFlightList.FlightMap();
    }

    public void opt2(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Flight ID: \n");
        String flightID = sc.nextLine();
        System.out.println("Enter column number: \n");
        int col = sc.nextInt();
        System.out.println("Enter row number: \n");
        int row = sc.nextInt();

        new AdminFlightC(flightID, col, row);
        System.out.println("Flight " + flightID + " has been successfully added!");
    }
    public void opt3(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Flight ID: \n");
        String flightID = sc.nextLine();

        new AdminFlightC(flightID);

    }
}
