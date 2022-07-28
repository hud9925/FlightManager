package Entities.User;

/**
 * An entity class representing an admin in the system
 * They are a "subclass" of the user, extending basic User properties
 */
public class Admin extends User{

    /**
     * Constructor for creating a new Admin
     * @param username Admin's username
     * @param password Admin's password
     * @param birthYear Admin's birthYear
     * @param birthMonth Admin's birthMonth
     * @param birthDay Admin's birthDay
     * @param email Admin's email
     */
    public Admin(String username, String password, int birthYear, int birthMonth, int birthDay, String email) {
        super(username, password, birthYear, birthMonth, birthDay, email, false);
    }

    /**
     * Extends User, represents the Admin property of this subclass
     * @return True --> this class is an admin
     */
    @Override
    public boolean isAdmin() {
        return true;
    }
}
