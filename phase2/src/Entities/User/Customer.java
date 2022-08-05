package Entities.User;

import java.time.LocalDate;

/**
 * An entity class representing a customer in the system
 * They are a "subclass" of the user, extending basic User properties
 */
public class Customer extends User{

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
}
