package Entities.User;

import Entities.Ticket.Ticket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserTracker {
    private static Map<String, User> allUsers = new HashMap<String, User>(); // HashMap for constant lookup time.

    public static boolean userExists (String username) {
        return allUsers.containsKey(username);
    }


    public static void addUser (User newUser) {
        allUsers.put(newUser.getUsername(), newUser);
    }

    public static void removeUser (String username) {
        allUsers.remove(username);
    }

    // Getters for basic user information

    public static Map<String, User> getAllUsers() {return allUsers;}

    public static String getPassword (String username)  {
        return allUsers.get(username).getPassword();
    }

    public static int getBirthDay (String username) {
        return allUsers.get(username).getBirthDay();
    }

    public static int getBirthMonth (String username) {
        return allUsers.get(username).getBirthMonth();
    }

    public static int getBirthYear (String username) {
        return allUsers.get(username).getBirthYear();
    }

    public static String getEmail (String username) {
        return allUsers.get(username).getEmail();
    }

    public static boolean getMemberStatus (String username) {
        return allUsers.get(username).getMemberStatus();
    }

    public static String getAddress (String username) {
        return allUsers.get(username).getAddress();
    }

    public static Object getPaymentMethods (String username) {
        // Not yet implemented
        // We need to decide how we store payment methods. Since there can be multiple payment methods, it's probably a list of some sort.
        return allUsers.get(username).getPaymentMethods();
    }

    public static Date getLastLoginTime (String username) {
        return allUsers.get(username).getLastLoginTime();
    }

    public static String[][] getSecurityQuestions (String username) {
        return allUsers.get(username).getSecurityQuestions(); // String[][] { String[] {question, answer}, String[] {question, answer}, String[] {question, answer}, ... }
    }

    public static Ticket[] getTickets (String username) {
        // Not yet implemented.
        return allUsers.get(username).getTickets();
    }

    public static boolean isAdmin (String username) {
        return allUsers.get(username).isAdmin();
    }

    // Setters for basic user information
    public static void changePassword (String username, String newPassword)  {
        allUsers.get(username).changePassword(newPassword);
    }

    public static void changeEmail (String username, String newEmail) {
        allUsers.get(username).changeEmail(newEmail);
    }

    public static void changeMemberStatus (String username, boolean newStatus)  {
        allUsers.get(username).changeMemberStatus(newStatus);
    }

    public static void changeAddress (String username, String newAddress)  {
        allUsers.get(username).changeAddress(newAddress);
    }

    public static void addPaymentMethod (String username, Object newMethod) {
        // Not yet implemented.
        allUsers.get(username).addPaymentMethod(newMethod);
    }

    public static void removePaymentMethod (String username, Object oldMethod) {
        // Not yet implemented.
        allUsers.get(username).removePaymentMethod(oldMethod);
    }

    public static void updateLastLoginTime (String username) {
        allUsers.get(username).updateLastLoginTime();
    }

    public static void addSecurityQuestion (String username, String question, String answer) {
        allUsers.get(username).addSecurityQuestion(question, answer);
    }

    public static void removeSecurityQuestion (String username, int index) {
        // Pre-condition: index < this.getSecurityQuestions(username).length.
        allUsers.get(username).removeSecurityQuestion(index);
    }

    public static void addTicket (String username, Ticket newTicket) {
        // Not yet implemented.
        // Pre-condition: 'newTicket' is not in the user's 'tickets' list.
        allUsers.get(username).addTicket(newTicket);
    }

    public static void removeTicket (String username, Ticket oldTicket) {
        // Not yet implemented.
        // Pre-condition: 'oldTicket' is in the user's 'tickets' list.
        allUsers.get(username).removeTicket(oldTicket);
    }
}
