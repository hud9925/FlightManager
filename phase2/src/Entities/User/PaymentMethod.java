package Entities.User;

/**
 * Entity class representing a customer's saved payment method
 */
public class PaymentMethod {

    /**
     * Variable representing the customer's username
     */
    private final String owner;

    /**
     * Variable representing the customer's card number
     */
    private final long cardNumber;

    /**
     * Variable keeping track of the amount of money in the balance
     */
    private int balance;

    /**
     * The card's pin number
     */
    private final String pin;

    /**
     * Constructor that builds an empty payment method
     * @param username the customer's name
     */
    public PaymentMethod(String username){
        this.owner = username;
        this.balance = 0;
        this.pin = "";
        this.cardNumber = 0;
    }

    /**
     * Constructor that builds a payment method based on given data
     * @param owner the customer's name
     * @param cardNumber the customer's card number
     * @param pin the card's pin
     */
    public PaymentMethod(String owner, long cardNumber, String pin){
        this.owner = owner;
        this.cardNumber = cardNumber;
        this.balance = 0;
        this.pin = pin;
    }

    /**
     * Method that adds a deposit (possibly negative) to the balance
     * @param deposit the money being added/deducted
     */
    public void addBalance(int deposit){
        this.balance += deposit;
    }

    /**
     * Getter for the balance of the account
     * @return the account's balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Method that sets the account's balance to given balance (for reading from a file)
     * @param balance the needed balance
     */
    public void setBalance(int balance){this.balance = balance;}

    /**
     * Getter for the card number
     * @return the card number
     */
    public long getCardNumber() {
        return cardNumber;
    }

    /**
     * Getter for the customer's username
     * @return the customer's name
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Method that translates the data into a string (CSV) format
     * @return the payment method data
     */
    @Override
    public String toString() {return owner + "," + cardNumber + "," + pin + "," + balance;}
}
