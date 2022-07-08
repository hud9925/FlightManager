package Entities.User;

import Entities.Ticket.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

abstract public class User {
    /**
     * The username of this User.
     */
    private final String username;
    /**
     * The password of this User.
     */
    private String password;
    /**
     * The date of birth of this User, stored in the format int[] {birthYear, birthMonth, birthDay}.
     */
    private final int dob[];
    /**
     * The email address of this User.
     */
    private String email;
    /**
     * A boolean indicating whether this User is a member.
     */
    private boolean isMember;
    /**
     * The address of this User.
     */
    private String address;
    /**
     * A list of payment methods for this User.
     * <p>
     * <strong>Payment methods are not yet implemented.</strong>
     */
    private List<Object> paymentMethods;
    /**
     * A list of date when the User logged in.
     */
    private List<Date> dateList;
    /**
     * A list of security questions for this User.
     * <p>
     * Each item in the list is in the format String[] {question, answer}.
     */
    private List<String[]> securityQuestions;
    /**
     * A list of Tickets purchased by the User.
     */
    private List<Ticket> tickets;

    /**
     * Construct a new User.
     * <p>
     * To add other properties not in the constructor like address, security questions, payment methods etc., use the
     * corresponding setters.
     *
     * @param  username The username of the User.
     * @param  password The password of the User.
     * @param  birthYear The year of birth as an integer.
     * @param  birthMonth The month of birth as an integer.
     * @param  birthDay The day of birth as an integer.
     * @param  email The email of the User.
     * @param  isMember A boolean indicating whether this User is a member.
     */
    public User (String username, String password, int birthYear, int birthMonth, int birthDay, String email, boolean isMember) {
        this.username = username;
        this.password = password;
        this.dob= new int[] {birthYear, birthMonth, birthDay};
        this.email = email;
        this.isMember = isMember;
        this.address = "";
        this.paymentMethods = new ArrayList<Object>();
        this.dateList = new ArrayList<Date>();
        this.dateList.add(new Date());
        this.securityQuestions = new ArrayList<String[]>();
        this.tickets = new ArrayList<Ticket>();
    }

    /**
     * Get the username of this User.
     *
     * @return The username.
     */
    public String getUsername () {
        return this.username;
    }

    /**
     * Get the password of this User.
     *
     * @return The password.
     */
    public String getPassword () {
        return this.password;
    }

    /**
     * Get the birth day of this User.
     *
     * @return An integer representing the day of birth of this User.
     */
    public int getBirthDay () {
        return this.dob[2];
    }

    /**
     * Get the birth month of this User.
     *
     * @return An integer representing the month of birth of this User.
     */
    public int getBirthMonth () {
        return this.dob[1];
    }

    /**
     * Get the birth year of this User.
     *
     * @return An integer representing the year of birth of this User.
     */
    public int getBirthYear () {
        return this.dob[0];
    }

    /**
     * Get the email of this User.
     *
     * @return The email.
     */
    public String getEmail () {
        return this.email;
    }

    /**
     * Get if this User is a member or not.
     *
     * @return A boolean indicating whether this User is a member.
     */
    public boolean getMemberStatus () {
        return this.isMember;
    }

    /**
     * Get the address of this User.
     *
     * @return The address.
     */
    public String getAddress () {
        return this.address;
    }

    /**
     * Get the payment methods for this User.
     * <p>
     * <strong>This method is not yet implemented.</strong>
     *
     * @return A list of payment methods for this User.
     */
    public Object getPaymentMethods () {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Get a list of dates when the User logged in.
     * <p>
     * The returned list is a deep copy.
     *
     * @return A deep copy of the list of dates when the User logged in.
     */
    public List<Date> getDateList() {
        List<Date> result = new ArrayList();
        for (Date loginDate : this.dateList) {
            result.add(new Date(loginDate.getTime()));
        }
        return result;
    }

    /**
     * Get an array of security questions for this User.
     *
     * @return An array of security questions in the format String[][] { String[] {question, answer}, String[] {question, answer}, String[] {question, answer}, ... }.
     */
    public String[][] getSecurityQuestions () {
        String result[][] = new String[this.securityQuestions.size()][];
        for (int i = 0; i < this.securityQuestions.size(); i++) {
            result[i] = Arrays.copyOf(this.securityQuestions.get(i),2);
        }
        return result;
    }

    /**
     * Get an array of tickets purchased by the user.
     * <p>
     * The returned array is a shallow copy.
     * <p>
     * <strong>This method is not yet implemented.</strong>
     *
     * @return An array of tickets purchased by the user.
     */
    public Ticket[] getTickets () {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Get if this User is an admin or not.
     *
     * @return A boolean indicating whether this User is an admin.
     */
    public abstract boolean isAdmin();

    /**
     * Change the password of this User.
     *
     * @param newPassword The new password for this User.
     */
    public void changePassword (String newPassword) {
        this.password = newPassword;
    }

    /**
     * Change the email address of this User.
     *
     * @param newEmail The new email address for this User.
     */
    public void changeEmail (String newEmail) {
        this.email = newEmail;
    }

    /**
     * Set if this User is a member or not.
     *
     * @param newStatus A boolean indicating whether to set this User as a member.
     */
    public void changeMemberStatus (boolean newStatus) {
        this.isMember = newStatus;
    }

    /**
     * Change the address of this User.
     *
     * @param newAddress The new address of this User.
     */
    public void changeAddress (String newAddress) {
        this.address = newAddress;
    }

    /**
     * Add a payment method to this User.
     * <p>
     * <strong>This method is not yet implemented.</strong>
     *
     * @param newMethod The new payment method to add.
     */
    public void addPaymentMethod (Object newMethod) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Remove a payment method for this User.
     * <p>
     * <strong>This method is not yet implemented.</strong>
     *
     * @param oldMethod The payment method to remove.
     */
    public void removePaymentMethod (Object oldMethod) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Add the current time to the login time list of this User.
     */
    public void updateDateList () {this.dateList.add(new Date());}

    /**
     * Set the list of login dates.
     * <p>
     * <strong>This method is intended for use by the database load method only and is subjected to deprecation.<strong/>
     *
     * @param ls The new list of login dates.
     */
    public void setDateList (List<Date> ls) {
        this.dateList = ls;
    }

    /**
     * Add a security question to this User.
     *
     * @param question The question.
     * @param answer The answer of the question.
     */
    public void addSecurityQuestion (String question, String answer) {
        this.securityQuestions.add(new String[] {question, answer});
    }

    /**
     * Remove a security question from this User.
     *
     * @param index The index of the question in the list returned by {@code this.getSecurityQuestions()}.
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < this.getSecurityQuestions().size()}).
     */
    public void removeSecurityQuestion (int index) {
        this.securityQuestions.remove(index);
    }

    /**
     * Add a ticket to this User.
     * <p>
     * <strong>This method is not yet implemented.</strong>
     *
     * @param newTicket The new ticket to add.
     */
    public void addTicket (Ticket newTicket) {
        // Pre-condition: 'newTicket' is not in the 'tickets' list.
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Remove a ticket from this User.
     * <p>
     * <strong>This method is not yet implemented.</strong>
     *
     * @param oldTicket The old ticket to remove.
     */
    public void removeTicket (Ticket oldTicket) {
        // Pre-condition: 'oldTicket' is in the 'tickets' list.
        throw new UnsupportedOperationException("Not implemented");
    }
}
