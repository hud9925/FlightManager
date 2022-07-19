package Presenters;

import java.util.Objects;
import java.util.Scanner;

import Controllers.PurchaseMenuC;
import UseCases.FlightNotFoundException;
import UseCases.GetFlightList;
import UseCases.SeatViewer;
import UseCases.ShowFlight;

/**
 * A Presenter Menu that Displays Flight information including its seatmap, prompts the User to select a seat for
 * potential purchase
 *
 */
public class PurchaseMenu {
    public static void PurchaseMenuPrompt(String ans) throws FlightNotFoundException {
        System.out.println("The Flight" + ans + "of airline" + GetFlightList.FlightInfo(ans).get("Airline:") +
                "departing from" + GetFlightList.FlightInfo(ans).get("Departure Location:") +
                "to " + GetFlightList.FlightInfo(ans).get("Arrival Location:") + "departs at " +
                GetFlightList.FlightInfo(ans).get("Departure Date:") + "." + " The Flight will take" +
                GetFlightList.FlightInfo(ans).get("Flight Duration:") + "long.");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Currently, Here is the Seating Chart. X's denote the Seat is empty," +
                "while O's are already occupied: ");
        System.out.println(SeatViewer.StringRepresenation(ShowFlight.getFlight(ans)));

        System.out.println("To Purchase a seat, Please Select a Row and Column.");

        Scanner SeatRow = new Scanner(System.in);
        System.out.println("Please Enter the Seat's Row Number");
        int row = SeatRow.nextInt();
        Scanner SeatColumn = new Scanner(System.in);
        System.out.println("Please Enter the Seat's Column Number");
        int column  = SeatColumn.nextInt();

        if (SeatViewer.getSeat(ShowFlight.getFlight(ans), row, column)==null){
            System.out.println("The Seat is not found on the plane. Please Try Again");
            PurchaseMenuPrompt(ans);
    }
        else if (Objects.requireNonNull(SeatViewer.getSeat(ShowFlight.getFlight(ans), row, column)).isFilled()){
            System.out.println("This Seat is already Occupied. Please Try Again");
            PurchaseMenuPrompt(ans);
        } else{
            new PurchaseMenuC(ShowFlight.getFlight(ans), row, column);
        }




}
}
