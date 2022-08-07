package Presenters.Customer;

import Controllers.PurchaseMenuC;
import Entities.User.TicketAlreadyExistsException;
import UseCases.FlightNotFoundException;
import UseCases.Customer.GetFlightList;
import UseCases.Customer.SeatViewer;
import UseCases.Customer.ShowFlight;

import java.util.Objects;
import java.util.Scanner;

/**
 * A Presenter Menu that Displays Flight information including its seat map, prompts the User to select a seat for
 * potential purchase
 *
 */
public class PurchaseMenu {
    public static void purchaseMenuPrompt(String ans) throws FlightNotFoundException, TicketAlreadyExistsException {
        System.out.println("Flight" + " " + ans + " of airline " + GetFlightList.flightInfo(ans).get("Airline:") +
                " departing from " + GetFlightList.flightInfo(ans).get("Departure Location:") +
                " to "+ GetFlightList.flightInfo(ans).get("Arrival Location:") + " departs at " +
                GetFlightList.flightInfo(ans).get("Departure Date:") + "." + " The Flight will take " +
                GetFlightList.flightInfo(ans).get("Flight Duration:") + " long.");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Currently, Here is the Seating Chart. '-'s denote the Seat is Occupied." +
                "Rows start from 0(VIP Row), while the letters identify the columns");
        System.out.println(SeatViewer.stringRepresentation(ShowFlight.getFlight(ans)));
        String Ans  = Console.prompt("Please enter 'continue' to continue and purchase a ticket, or press any other character " +
                "to leave this menu");
        if (Objects.equals(Ans, "continue")){
            System.out.println(" ");
            System.out.println("To Purchase a seat, Please Select a Row and Column individually.");

            Scanner SeatRow = new Scanner(System.in);
            System.out.println("Please Enter the Seat's Row Number");
            int row = SeatRow.nextInt();
            Scanner SeatColumn = new Scanner(System.in);
            System.out.println("Please Enter the Seat's Column Letter");
            //int column = SeatColumn.nextInt();

            char column = SeatColumn.next().charAt(0);
            char CharRep = Character.toUpperCase(column);

            if (SeatViewer.getSeat(ShowFlight.getFlight(ans), row, (int) CharRep -65)==null){
                System.out.println("The Seat is not found on the plane. Please Try Again");
                purchaseMenuPrompt(ans);
            }
            else if (Objects.requireNonNull(SeatViewer.getSeat(ShowFlight.getFlight(ans), row, (int) CharRep -65)).isFilled()){
                System.out.println(" ");
                System.out.println("This Seat is already Occupied. Please Try Again");
                System.out.println(" ");
                purchaseMenuPrompt(ans);
            } else{
                new PurchaseMenuC(ShowFlight.getFlight(ans), row, (int) CharRep -65);
            }

        } else {
            FlightMenu.flightMenuPrompt();
        }

    }
    public static String purchaseAnotherTicket(){
        String ans = Console.prompt("Would You Like to Purchase Another Ticket? To Purchase Another ticket, please press 't,' or " +
                "type any other character to exit.");
        if (ans.equalsIgnoreCase("t")){
            return "yes";
        }
        else{
            return "no";
        }
    }
}
