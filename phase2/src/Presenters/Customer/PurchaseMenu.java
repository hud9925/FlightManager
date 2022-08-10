package Presenters.Customer;

import Controllers.PurchaseMenuC;
import Entities.User.TicketAlreadyExistsException;
import Presenters.Console;
import UseCases.FlightNotFoundException;
import UseCases.Customer.GetFlightList;
import UseCases.Customer.SeatViewer;
import UseCases.Customer.ShowFlight;

import java.util.Objects;

/**
 * A Presenter Menu that Displays Flight information including its seat map, prompts the User to select a seat for
 * potential purchase
 *
 */
public class PurchaseMenu {
    public static void purchaseMenuPrompt(String username, String ans) throws FlightNotFoundException {
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
        if (Ans.equalsIgnoreCase("continue")){
            System.out.println(" ");
            System.out.println("To Purchase a seat, Please Select a Row and Column individually.");

            int row = Console.promptForInt("Please Enter the Seat's Row Number", false);
            char column = Console.prompt("Please Enter the Seat's Column Letter", "^[a-zA-Z]$").charAt(0);
            char CharRep = Character.toUpperCase(column);

            if (SeatViewer.getSeat(ShowFlight.getFlight(ans), row, (int) CharRep -65)==null){
                System.out.println("The Seat is not found on the plane. Please Try Again");
                purchaseMenuPrompt(username, ans);
            }
            else if (Objects.requireNonNull(SeatViewer.getSeat(ShowFlight.getFlight(ans), row, (int) CharRep -65)).isFilled()){
                System.out.println(" ");
                System.out.println("This Seat is already Occupied. Please Try Again");
                System.out.println(" ");
                purchaseMenuPrompt(username, ans);
            } else{
                try {
                    new PurchaseMenuC(username, ShowFlight.getFlight(ans), row, (int) CharRep -65);
                } catch (TicketAlreadyExistsException e) {
                    throw new RuntimeException(e);
                }
            }

        } else {
            FlightMenu.flightMenuPrompt(username);
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
