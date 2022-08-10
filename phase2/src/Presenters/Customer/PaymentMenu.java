package Presenters.Customer;

import Presenters.Console;
import UseCases.Customer.PaymentManager;

/**
 * The menu for setting up + interacting with a payment method
 */
public class PaymentMenu {

    /**
     * the menu's prompt method, setting up a payment method
     *
     * @param username The username of the current user.
     */
    public static void paymentMenuPrompt(String username){
        String cardNumber = Console.prompt("Please enter your card number:", "^[1-9][0-9]{15}$");
        String pin = Console.prompt("Please enter your pin number (digit only):", "^[0-9]*$");
        PaymentManager.createPaymentMethod(username, Long.parseLong(cardNumber), pin);
        String ans = Console.prompt("Your payment method has been saved. To deposit an amount, press 'd'. Enter any " +
                "other input to go back.");
        if(ans.equalsIgnoreCase("d")){
            PaymentMenu.depositMenuPrompt(username);
        }
        MainMenu.mainPage(username);
    }

    /**
     * the menu's deposit menu method, for when there is money being deposited
     *
     * @param username the user's name
     */
    private static void depositMenuPrompt(String username) {
        int deposit = Console.promptForInt("Please enter the amount you are depositing (integers only): ",
                false);
        System.out.println("Your current balance is: " + PaymentManager.deposit(username, deposit) +
                "\nYou will be redirected to the main menu...");
    }
}
