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

    public static Map<String, User> getAllUsers() {
        return new HashMap<String, User>(allUsers); // A shallow copy of allUsers.
    }

    public static void removeUser(String username){
        allUsers.remove(username);
    }

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
        allUsers.remove(this.currentUser.getUsername());
        this.currentUser = null;
    }
}
