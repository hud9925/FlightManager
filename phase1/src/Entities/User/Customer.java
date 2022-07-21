package Entities.User;

/**
 * An entity class representing a customer in the system
 * They are a "subclass" of the user, extending basic User properties
 */
public class Customer extends User{

    /**
     * Constructor for creating a new customer
     * @param username Customer's username
     * @param password Customer's password
     * @param birthYear Customer's birthYear
     * @param birthMonth Customer's birthMonth
     * @param birthDay Customer's birthDay
     * @param email Customer's email
     * @param isMember Whether the customer is/isn't a member
     */
    public Customer(String username, String password, int birthYear, int birthMonth, int birthDay, String email,
                    boolean isMember) {
        super(username, password, birthYear, birthMonth, birthDay, email, isMember);
    }

    /**
     * Extends User, represents the Admin property of this subclass
     * @return False --> this class is a customer, not an admin
     */
    @Override
    public boolean isAdmin() {
        return false;
    }
}
