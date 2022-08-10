package Gateways;

import Entities.User.Admin;
import Entities.User.Customer;
import Entities.User.User;
import Entities.User.UserTracker;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class extending the DatabaseConnector
 * Used for saving all the User data in the program
 */
public class UserTrackerConnector extends DatabaseConnector {
    public UserTrackerConnector() throws IOException {
        super();
    }

    /**
     * Implements the abstract save operation of DatabaseConnector
     * Saves the UserTracker to a file with specified filepath
     * @throws IOException - in case of meaningless input
     */
    @Override
    public void save() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        for(User user : UserTracker.getInstance()){
            pw.write(user.toString() + "\n");
        }
        pw.close();
    }

    /**
     * Implements the abstract load operation of DatabaseConnector
     * Reads Users from a file with specified directory and adds them to the UserTracker
     * @throws IOException - in case of meaningless input
     */
    @Override
    public void load() throws IOException {
//        String filepath = String.valueOf(Paths.get("UserDatabase.csv").toAbsolutePath());
        BufferedReader br = new BufferedReader(new FileReader(this.filepath));
        String line;
        while((line = br.readLine())!= null) {
            User newUser = lineToUser(line);
            UserTracker.getInstance().addUser(newUser);
        }
        br.close();
    }

    /**
     * Helper method for translating a line into a User entity
     * @param line the line String read from the document containing User properties
     * @return a User object with the read properties
     */
    private User lineToUser(String line) {
        User newUser;
        String [] userinfo = line.split(",");
        if (userinfo[6].equals("true")){
            newUser = new Admin(userinfo[0], userinfo[1], LocalDate.parse(userinfo[2]), userinfo[3]);
        } else {
            newUser = new Customer(userinfo[0], userinfo[1], LocalDate.parse(userinfo[2]), userinfo[3],
                    Boolean.parseBoolean(userinfo[4]));
            ((Customer)newUser).setLoyaltyPoints(Integer.parseInt(userinfo[7]));
        }
        String[] previousDates = userinfo[5].split("\\|");
        if (!previousDates[0].equals("")) {
            newUser.updateDateList(loginDatesReader(previousDates));
        }
        return newUser;
    }

    /**
     * Helper method for translating a list of previous dates in string format into a list of dates
     * @param previousDates the list of previous dates, in string format
     * @return the list of previous dates, in date format
     */
    private List<LocalDate> loginDatesReader(String[] previousDates) {
        List<LocalDate> dateList = new ArrayList<>();
        for(String str: previousDates){
            LocalDate d = LocalDate.parse(str);
            dateList.add(d);
        }
        return dateList;
    }

    /**
     * Implements the abstract method in DatabaseConnector, with the specified filepath
     * @return the filepath (string)
     */
    @Override
    protected String getDatabaseName () {
        return "UserDatabase.csv";
    }
}
