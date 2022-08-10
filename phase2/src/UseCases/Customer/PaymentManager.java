package UseCases.Customer;

import Entities.User.Customer;
import Entities.User.PaymentMethod;
import UseCases.Admin.GetUser;

/**
 * A class that manages a User's payment method
 */
public class PaymentManager {

    /**
     * A method to create a new payment method for the User
     * @param username the user's name
     * @param cardNumber the number of their card
     * @param pin the pin number of their card
     */
    public static void createPaymentMethod(String username, long cardNumber, String pin){
        Customer user = (Customer) GetUser.returnUser(username);
        PaymentMethod pm = new PaymentMethod(username, cardNumber, pin);
        user.setPaymentMethod(pm);
    }

    /**
     * A method to purchase something, updating the payment method of the user
     * @param username the user's name
     * @param cost the cost that they are paying
     * @return the user's balance in their account
     */
    public static int purchase(String username, int cost){
        Customer user = (Customer) GetUser.returnUser(username);
        user.getPaymentMethod().addBalance(cost*(-1));
        return user.getPaymentMethod().getBalance();
    }

    /**
     * a method to deposit money into the account
     * @param username the user's name
     * @param deposit the money amount that they are entering
     * @return the user's balance in their account
     */
    public static int deposit(String username, int deposit){
        Customer user = (Customer) GetUser.returnUser(username);
        user.getPaymentMethod().addBalance(deposit);
        return user.getPaymentMethod().getBalance();
    }

    /**
     * A method to return the purchasing account details of the user
     * @param username the user's name
     * @return the user's card number + balance
     */
    public static String accountDetails(String username){
        Customer user = (Customer) GetUser.returnUser(username);
        PaymentMethod pm = user.getPaymentMethod();
        return "Your Card Number:" + pm.getCardNumber() + "\nYour Balance: " + pm.getBalance();
    }
}
