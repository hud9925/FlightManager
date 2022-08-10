package Entities.User;

import Entities.User.Ticket.Ticket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract public class User {
    /**
     * The username of this User.
     */
    private final String username;
    /**
     * The password of this User.
     */
    private final String password;
    /**
     * The date of birth of this User, stored in the format int[] {birthYear, birthMonth, birthDay}.
     */
    private final LocalDate dob;
    /**
     * The email address of this User.
     */
    private final String email;
    /**
     * A boolean indicating whether this User is a member.
     */
    private boolean isMember;

    /**
     * A list of date when the User logged in.
     */
    private final List<LocalDate> dateList;

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
        this.dateList = new ArrayList<>();
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

    /**
     * Get the password of this User.
     *
     * @return The password.
     */
    public String getPassword () {
        return this.password;
    }

    /**
     * Get the date of birth of this User.
     *
     * @return The password.
     */
    public LocalDate getDob(){
        return this.dob;
    }

    /**
     * Get the login times of this User.
     *
     * @return The password.
     */
    public List<LocalDate> getDateList() {
        return dateList;
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
     * Get this user's email.
     *
     * @return A boolean indicating whether this User is a member.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get if this User is an admin or not.
     *
     * @return A boolean indicating whether this User is an admin.
     */
    public abstract boolean isAdmin();

    /**
     * Set if this User is a member or not.
     *
     * @param newStatus A boolean indicating whether to set this User as a member.
     */
    public void changeMemberStatus (boolean newStatus) {
        this.isMember = newStatus;
    }



    /**
     * Add the current time to the login time list of this User.
     */
    public void updateDateList () {this.dateList.add(LocalDate.now());}

    /**
     * Add a new date to the login time list of this User.
     *
     * @param newDate The new date to add.
     */
    public void updateDateList (LocalDate newDate) {
        this.dateList.add(newDate);
    }

    /**
     * Append dates in a list to the existing login time list of this user.
     *
     * @param newDateList The new dates to append.
     */
    public void updateDateList (List<LocalDate> newDateList) {
        for (LocalDate newDate : newDateList) {
            this.updateDateList(newDate);
        }
    }


    /**
     * Add a ticket to this User.
     *
     * @param newTicket The new ticket to add.
     * @throws TicketAlreadyExistsException if the ticket to add is already added to this User.
     */
    public void addTicket (Ticket newTicket) throws TicketAlreadyExistsException {
        if (this.tickets.contains(newTicket)) {
            throw new TicketAlreadyExistsException(this.username);
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
            throw new TicketNotFoundException(this.username);
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
        StringBuilder dateString = new StringBuilder();
        for(LocalDate d : this.dateList){
            String dateStr = d.toString();
            dateString.append(dateStr).append("|");
        }
        return username + "," + password + "," + dob  + "," + email + "," + isMember + "," +
                dateString + "," + (this.isAdmin()?"true":"false");
    }
}
