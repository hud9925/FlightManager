package Entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserTracker {
    private static Map<String, User> allUsers = new HashMap<String, User>(); // HashMap for constant lookup time.
    private User currentUser;

    // constructors
    public UserTracker (String username) {
        this.currentUser = allUsers.get(username);
    }

    // static methods
    public static void addUser (User newUser) {
        allUsers.put(newUser.getUsername(), newUser);
    }

    public static int getTotalUserCount () {
        return allUsers.size();
    }

    public static Map<String, User> getAllUsers() {
        // Try to avoid using this method. It is very inefficient and created solely for saving the allUser map.
        return new HashMap<String, User>(allUsers); // A shallow copy of allUsers.
    }

    /*  Please use:
        >>> new UserTracker('username').removeCurrentUser();
        to remove users.

    public static void removeUser(String username){
        allUsers.remove(username);
    } */

    // getters
    public User getCurrentUser () {
        return this.currentUser;
    }

    // setters
    public void changeCurrentUser(String username) {
        this.currentUser = allUsers.get(username);
    }

    // methods
    public boolean userExists () {
        return this.currentUser != null;
    }

    public void removeCurrentUser () {
        if (this.userExists()) {
            allUsers.remove(this.currentUser.getUsername());
            this.currentUser = null;
        }
    }
}
