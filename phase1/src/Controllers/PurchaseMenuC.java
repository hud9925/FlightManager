package Controllers;


import Entities.Flight.Flight;
import Entities.Ticket.Ticket;
import UseCases.GetUser;
import UseCases.SeatViewer;
import UseCases.BuyTicket;

import java.util.Scanner;

public class PurchaseMenuC {
    public PurchaseMenuC(Flight flight, Integer row, Integer column){
        //BuyTicket
        // For Now --> No Cost
        // Make User login again --> for now, only Takes Username
        // create instance of ticket
        Scanner ConfirmUser = new Scanner(System.in);
        System.out.println("Please Enter Your Username again to continue");
        String username = ConfirmUser.nextLine();

        // some kind of bridging between Customer and User

        new Ticket(flight, 0, GetUser.ReturnUser(username) , SeatViewer.getSeat(flight, row, column));
        BuyTicket.PurchasedTicket()
        }
    }
}
