package Entities.User;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserTracker implements Iterable<User> {
    /**
     * The UserTracker instance for Singleton design pattern.
     */
    private static final UserTracker instance = new UserTracker();
    /**
     * A HashMap that maps usernames to User objects for all users in the system.
     */
    private final Map<String, User> allUsers = new HashMap<>();
    /**
     * A User object indicate the user currently being tracked.
     */
    private User currentUser = null;

    /**
     * Construct a new UserTracker with no User being tracked.
     */
    private UserTracker () {}

    /**
     * Get the UserTracker instance with the username of the User that will be tracked.
     *
     * @param username The username of the User to track.
     * @return The UserTracker instance.
     */
    public static UserTracker getInstance (String username) {
        instance.changeCurrentUser(username);
        return instance;
    }

    /**
     * Get the UserTracker instance without changing the User that is being tracked.
     *
     * @return The UserTracker instance.
     */
    public static UserTracker getInstance () {
        return instance;
    }

    /**
     * Add a new User to the list of all users.
     *
     * @param  newUser The new User to add.
     */
    public void addUser (User newUser) {
        this.allUsers.put(newUser.getUsername(), newUser);
    }

    /**
     * Add a new User to the list of all users.
     *
     * @return Return an int represent the total number of users in the system.
     */
    public int getTotalUserCount () {
        return this.allUsers.size();
    }

    /**
     * Get the User object of the user currently being tracked.
     *
     * @return Return the User object of the user currently being tracked.
     */
    public User getCurrentUser () {
        return this.currentUser;
    }

    /**
     * Track another User with the username passed in as a String.
     *
     * @param username The username of the new User to track.
     */
    public void changeCurrentUser(String username) {
        this.currentUser = allUsers.get(username);
    }

    /**
     * Check if the User currently being tracked is in the system or not.
     *
     * @return Return a boolean indicate whether the User exists in the system.
     */
    public boolean userExists () {
        return this.currentUser != null;
    }

    /**
     * Remove the currently tracked User from the system.
     */
    public void removeCurrentUser () {
        if (this.userExists()) {
            allUsers.remove(this.currentUser.getUsername());
            this.currentUser = null;
        }
    }
    /**
     * Removes All Users within the system
     */
    public void removeAllUsers(){
        allUsers.clear();
    }

    @Override
    public Iterator<User> iterator() {
        return allUsers.values().iterator();
    }
}
