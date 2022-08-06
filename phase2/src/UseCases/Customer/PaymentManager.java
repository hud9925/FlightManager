package UseCases.Customer;

import Entities.User.Customer;
import Entities.User.PaymentMethod;
import UseCases.Admin.GetUser;

public class PaymentManager {

    public void createPaymentMethod(String username, int cardNumber, int balance, int pin){
        Customer user = (Customer) GetUser.returnUser(username);
        PaymentMethod pm = new PaymentMethod(username, cardNumber, balance, pin);
        user.setPaymentMethod(pm);
    }

    public int purchase(String username, int cost){
        Customer user = (Customer) GetUser.returnUser(username);
        user.getPaymentMethod().pay(cost);
        return user.getPaymentMethod().getBalance();
    }

    public int deposit(String username, int deposit){
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
