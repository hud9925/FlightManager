package Entities.User;

import Entities.User.Ticket.Ticket;

import java.time.LocalDate;
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
    private final LocalDate dob;
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
    private final List<Object> paymentMethods;
    /**
     * A list of date when the User logged in.
     */
    private final List<Date> dateList;
    /**
     * A list of security questions for this User.
     * <p>
     * Each item in the list is in the format String[] {question, answer}.
     */
    private final List<String[]> securityQuestions;
    /**
     * A list of Tickets purchased by the User.
     */
    private final List<Ticket> tickets;

    /**
     * Construct a new User.
     * <p>
     * To add other properties not in the constructor like address, security questions, payment methods etc., use the
     * corresponding setters.
     *
     * @param  username The username of the User.
     * @param  password The password of the User.
     * @param  email The email of the User.
     * @param  isMember A boolean indicating whether this User is a member.
     */
    public User (String username, String password, LocalDate dob, String email,
                 boolean isMember) {
        this.username = username;
        this.password = password;
        this.dob= dob;
        this.email = email;
        this.isMember = isMember;
        this.address = "";
        this.paymentMethods = new ArrayList<>();
        this.dateList = new ArrayList<>();
        this.securityQuestions = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    /**
     * Get the username of this User.
     *
     * @return The username.
     */
    public String getUsername () {
        return this.username;
    }

    public LocalDate getDob(){return this.dob;}

    /**
     * Get the password of this User.
     *
     * @return The password.
     */
    public String getPassword () {
        return this.password;
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
     * Get an array of dates of when the User logged in.
     * <p>
     * The returned array is a deep copy.
     *
     * @return An array of dates of when the User logged in.
     */
    public Date[] getDateList() {
        Date[] result = new Date[this.dateList.size()];
        for (int i = 0; i < this.dateList.size(); i++) {
            result[i] = new Date(this.dateList.get(i).getTime());
        }
        return result;
    }

    /**
     * Get an array of security questions for this User.
     *
     * @return An array of security questions in the format
     * String[][] { String[] {question, answer}, String[] {question, answer}, String[] {question, answer}, ... }.
     */
    public String[][] getSecurityQuestions () {
        String[][] result = new String[this.securityQuestions.size()][];
        for (int i = 0; i < this.securityQuestions.size(); i++) {
            result[i] = Arrays.copyOf(this.securityQuestions.get(i),2);
        }
        return result;
    }

    /**
     * Get an array of tickets purchased by the user.
     * <p>
     * The returned array is a shallow copy.
     *
     * @return An array of tickets purchased by the user.
     */
    public Ticket[] getTickets() {
        return tickets.toArray(new Ticket[this.tickets.size()]);
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
     * Add a new date to the login time list of this User.
     *
     * @param newDate The new date to add.
     */
    public void updateDateList (Date newDate) {
        this.dateList.add(newDate);
    }

    /**
     * Append dates in a list to the existing login time list of this user.
     *
     * @param newDateList The new dates to append.
     */
    public void updateDateList (List<Date> newDateList) {
        for (Date newDate : newDateList) {
            this.updateDateList(newDate);
        }
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
     */
    public void removeSecurityQuestion (int index) {
        this.securityQuestions.remove(index);
    }

    /**
     * Add a ticket to this User.
     *
     * @param newTicket The new ticket to add.
     * @throws TicketAlreadyExistsException if the ticket to add is already added to this User.
     */
    public void addTicket (Ticket newTicket) throws TicketAlreadyExistsException {
        if (this.tickets.contains(newTicket)) {
            throw new TicketAlreadyExistsException();
        }
        this.tickets.add(newTicket);
    }

    /**
     * Remove a ticket from this User.
     *
     * @param oldTicket The old ticket to remove.
     * @throws TicketNotFoundException if the ticket to remove is not found in this User.
     */
    public void removeTicket (Ticket oldTicket) throws TicketNotFoundException {
        if (!this.tickets.contains(oldTicket)) {
            throw new TicketNotFoundException();
        }
        this.tickets.remove(oldTicket);
    }

    /**
     * Return a string representation of this User.
     *
     * @return The string representation of this User.
     */
    @Override
    public String toString(){
        StringBuilder dateStrs = new StringBuilder();
        for(Date d : this.dateList){
            String dateStr = String.valueOf(d.getTime());
            dateStrs.append(dateStr).append("|");
        }
        return this.getUsername() + "," + this.getPassword() + "," + this.getDob()
                + "," + this.getEmail() + "," + this.getMemberStatus()
                + "," + this.getAddress() + "," + dateStrs + "," + (this.isAdmin()?"true":"false");
    }
}
