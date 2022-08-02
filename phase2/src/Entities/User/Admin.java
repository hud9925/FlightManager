package Entities.User;

import java.time.LocalDate;

/**
 * An entity class representing an admin in the system
 * They are a "subclass" of the user, extending basic User properties
 */
public class Admin extends User{

    /**
     * Constructor for creating a new Admin
     * @param username Admin's username
     * @param password Admin's password
     * @param email Admin's email
     */
    public Admin(String username, String password, LocalDate dob, String email) {
        super(username, password, dob, email, false);
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
