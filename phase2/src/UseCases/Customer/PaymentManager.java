package UseCases.Customer;

import Entities.User.Customer;
import Entities.User.PaymentMethod;
import UseCases.Admin.GetUser;

public class PaymentManager {

    public static void createPaymentMethod(String username, int cardNumber, int pin){
        Customer user = (Customer) GetUser.returnUser(username);
        PaymentMethod pm = new PaymentMethod(username, cardNumber, pin);
        user.setPaymentMethod(pm);
    }

    public int purchase(String username, int cost){
        Customer user = (Customer) GetUser.returnUser(username);
        user.getPaymentMethod().pay(cost);
        return user.getPaymentMethod().getBalance();
    }

    public static int deposit(String username, int deposit){
        Customer user = (Customer) GetUser.returnUser(username);
        user.getPaymentMethod().addBalance(deposit);
        return user.getPaymentMethod().getBalance();
    }

    public String accountDetails(String username, int cost){
        Customer user = (Customer) GetUser.returnUser(username);
        PaymentMethod pm = user.getPaymentMethod();
        return "Your Card Number:" + pm.getCardNumber() + "\nYour Balance: " + pm.getBalance();
    }
}
