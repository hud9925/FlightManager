package Entities.User;

public class PaymentMethod {

    private final String owner;

    private final int cardNumber;

    private int balance;

    private final int pin;

    public PaymentMethod(String username){
        this.owner = username;
        this.balance = 0;
        this.pin = 0;
        this.cardNumber = 0;
    }
    public PaymentMethod(String owner, int cardNumber, int balance, int pin){
        this.owner = owner;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public void addBalance(int deposit){
        this.balance += deposit;
    }

    public void pay(int price){
        this.balance -= price;
    }

    public int getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getOwner() {
        return owner;
    }
}
