package Entities.User;

import Entities.Ticket.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

abstract public class User {
    private final String username;
    private String password;
    private final int dob[];
    private String email;
    private boolean isMember;
    private String address;
    private List<Object> paymentMethods;
    private Date lastLoginTime; // If the user just registered but have not logged in, lastLoginTime will be the register time.
    private List<String[]> securityQuestions;
    private List<Ticket> tickets;

    // constructors
    public User (String username, String password, int birthYear, int birthMonth, int birthDay, String email, boolean isMember) {
        // To add other properties like address, security questions, payment methods etc., use corresponding setters.
        this.username = username;
        this.password = password;
        this.dob= new int[] {birthYear, birthMonth, birthDay};
        this.email = email;
        this.isMember = isMember;

        this.address = "";
        this.paymentMethods = new ArrayList<Object>();
        this.lastLoginTime = new Date();
        this.securityQuestions = new ArrayList<String[]>();
        this.tickets = new ArrayList<Ticket>();
    }

    // getters
    public String getUsername () {
        return this.username;
    }

    public String getPassword () {
        return this.password;
    }

    public int getBirthDay () {
        return this.dob[2];
    }

    public int getBirthMonth () {
        return this.dob[1];
    }

    public int getBirthYear () {
        return this.dob[0];
    }

    public String getEmail () {
        return this.email;
    }

    public boolean getMemberStatus () {
        return this.isMember;
    }

    public String getAddress () {
        return this.address;
    }

    public Object getPaymentMethods () {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Date getLastLoginTime () {
        return new Date(this.lastLoginTime.getTime());
    }

    public String[][] getSecurityQuestions () {
        String result[][] = new String[this.securityQuestions.size()][];
        for (int i = 0; i < this.securityQuestions.size(); i++) {
            result[i] = Arrays.copyOf(this.securityQuestions.get(i),2);
        }
        return result;
    }

    public Ticket[] getTickets () {
        throw new UnsupportedOperationException("Not implemented");
    }

    public abstract boolean isAdmin();

    // setters
    public void changePassword (String newPassword) {
        this.password = newPassword;
    }

    public void changeEmail (String newEmail) {
        this.email = newEmail;
    }

    public void changeMemberStatus (boolean newStatus) {
        this.isMember = newStatus;
    }

    public void changeAddress (String newAddress) {
        this.address = newAddress;
    }

    public void addPaymentMethod (Object newMethod) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void removePaymentMethod (Object oldMethod) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void updateLastLoginTime () {
        this.lastLoginTime = new Date();
    }

    public void addSecurityQuestion (String question, String answer) {
        this.securityQuestions.add(new String[] {question, answer});
    }

    public void removeSecurityQuestion (int index) {
        // Pre-condition: index < securityQuestions.size().
        this.securityQuestions.remove(index);
    }

    public void addTicket (Ticket newTicket) {
        // Pre-condition: 'newTicket' is not in the 'tickets' list.
        throw new UnsupportedOperationException("Not implemented");
    }

    public void removeTicket (Ticket oldTicket) {
        // Pre-condition: 'oldTicket' is in the 'tickets' list.
        throw new UnsupportedOperationException("Not implemented");
    }
}
