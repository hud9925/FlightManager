package Entities.User;

import java.time.LocalDate;

/**
 * An entity class representing a customer in the system
 * They are a "subclass" of the user, extending basic User properties
 */
public class Customer extends User{

    /**
     * An integer value representing the total number of loyalty points acquired by the User.
     */
    private int loyaltyPoints;

    /**
     * This customer's payment method
     * <p>
     * <strong>Payment methods are not yet implemented.</strong>
     */
    private PaymentMethod paymentMethod;

    /**
     * Constructor for creating a new customer
     * @param username Customer's username
     * @param password Customer's password
     * @param email Customer's email
     * @param isMember Whether the customer is/isn't a member
     */
    public Customer(String username, String password, LocalDate dob, String email,
                    boolean isMember) {
        super(username, password, dob, email, isMember);
        this.paymentMethod = new PaymentMethod(username);
        this.loyaltyPoints = 0;
    }

    /**
     * Extends User, represents the Admin property of this subclass
     * @return False --> this class is a customer, not an admin
     */
    @Override
    public boolean isAdmin() {
        return false;
    }

    /**
     * save this user's added method.
     *
     * @param newMethod the user's payment method
     */
    public void setPaymentMethod (PaymentMethod newMethod) {
        this.paymentMethod = newMethod;
    }

    public PaymentMethod getPaymentMethod(){return this.paymentMethod;}

    /**
     * Adds 1000 loyalty points to the User.
     * Use intended when purchasing a new flight.
     */
    public void updateLoyaltyPoints() {
        this.loyaltyPoints += 1000;
    }

    /**
     * Get the total number of Loyalty Points acquired by the user.
     * @return the integer value representing the user's total loyalty points.
     */
    public int getLoyaltyPoints () { return this.loyaltyPoints; }

    /**
     * Set the loyalty points of this customer to input value (intended for file reading)
     * @param loyaltyPoints the input loyalty points
     */
    public void setLoyaltyPoints(int loyaltyPoints){
        this.loyaltyPoints = loyaltyPoints;
    }
    @Override
    public String toString(){
        StringBuilder dateString = new StringBuilder();
        for(LocalDate d : super.getDateList()){
            String dateStr = d.toString();
            dateString.append(dateStr).append("|");
        }
        return super.getUsername() + "," + super.getPassword() + "," + super.getDob()  + "," + super.getEmail()
                + "," + super.getMemberStatus() + "," + dateString + ",false," + loyaltyPoints;
    }
}
