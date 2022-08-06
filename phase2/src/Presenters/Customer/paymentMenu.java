package Presenters.Customer;

import Entities.User.TicketAlreadyExistsException;
import Entities.User.TicketNotFoundException;
import UseCases.Customer.PaymentManager;
import UseCases.FlightNotFoundException;

public class paymentMenu {

    public static void paymentMenuPrompt(){
        String username = UsernameMenu.getUsernamePrompt();
        String cardNumber = Console.prompt("Please enter your card number (integers only):", "^[0-9]*$");
        String pin = Console.prompt("Please enter your pin number (integers only):", "^[0-9]*$");
        PaymentManager.createPaymentMethod(username, Integer.parseInt(cardNumber), Integer.parseInt(pin));
        String ans = Console.prompt("Your payment method has been saved. To deposit an amount, press 'd'. Enter any " +
                "other input to go back.");
        if(ans.equalsIgnoreCase("d")){
            paymentMenu.depositMenuPrompt(username);
        }
        try {
            MainMenu.mainPage();
        } catch (FlightNotFoundException | TicketAlreadyExistsException | TicketNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void depositMenuPrompt(String username) {
        String deposit = Console.prompt("Please enter the amount you are depositing (integers only):",
                "^[0-9]*$");
        System.out.println("Your current balance is: " + PaymentManager.deposit(username, Integer.parseInt(deposit)) +
                "\nYou will be redirected to the main menu...");
    }
}
