package Gateways;

import Entities.User.Admin;
import Entities.User.Customer;
import Entities.User.User;
import Entities.User.UserTracker;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserTrackerConnector implements DatabaseConnector {

    private final String filepath;

    /**
     * Connect to the database.
     * <p>
     * This constructor will search for the 'UserDatabase.csv' file in the working directory first. If not found, it
     * will search the 'phase1/' subdirectory of the working directory for that file. If the file is not found in either
     * place, it will create this file in the working directory.
     *
     * @throws IOException when the file is not found in either place, and cannot be created.
     */
    public UserTrackerConnector() throws IOException{
        String preferredPath = getAbsolutePath("UserDatabase.csv");
        if (fileExists(preferredPath)) {
            this.filepath = preferredPath;
            return;
        }

        String altPath = getAbsolutePath("phase1/UserDatabase.csv");
        if (fileExists(altPath)) {
            this.filepath = altPath;
            return;
        }

        this.filepath = preferredPath;
        File preferredFile = new File(preferredPath);
        if (!preferredFile.createNewFile()) {
            throw new IOException();
        }
    }

    /**
     * Get the absolute path from a relative path.
     *
     * @param relPath The relative path to the working directory.
     * @return The absolute path.
     */
    private String getAbsolutePath (String relPath) {
        return String.valueOf(Paths.get(relPath).toAbsolutePath());
    }

    /**
     * Check if the file of a given path exists.
     *
     * @param path The path of the file to check.
     * @return A boolean indicating whether the file exists.
     */
    private boolean fileExists (String path) {
        File file = new File(path);
        return file.isFile();
    }

    public void Save() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        Map<String, User> allusers = UserTracker.getAllUsers();
        for(User user : allusers.values()){
            pw.write(user.toString() + "\n");
        }
        pw.close();
    }
    public void Load() throws IOException {
//        String filepath = String.valueOf(Paths.get("UserDatabase.csv").toAbsolutePath());
        BufferedReader br = new BufferedReader(new FileReader(this.filepath));
        String line;
        while((line = br.readLine())!= null) {
            User newuser = lineToUser(line);
            UserTracker.addUser(newuser);
        }
        br.close();
    }

    public User lineToUser(String line) {
        User newuser;
        String [] userinfo = line.split(",");
        if (userinfo[9].equals("true")){
            newuser = new Admin(userinfo[0], userinfo[1], Integer.parseInt(userinfo[2]),
                    Integer.parseInt(userinfo[3]), Integer.parseInt(userinfo[4]), userinfo[5],
                    Boolean.parseBoolean(userinfo[6]));
        } else {
            newuser = new Customer(userinfo[0], userinfo[1], Integer.parseInt(userinfo[2]),
                    Integer.parseInt(userinfo[3]), Integer.parseInt(userinfo[4]), userinfo[5],
                    Boolean.parseBoolean(userinfo[6]));
        }
        newuser.changeAddress(userinfo[7]);
        String[] previousdates = userinfo[8].split("\\|");
        if (!previousdates[0].equals("")) {
            newuser.updateDateList(loginDatesReader(previousdates));
        }
        return newuser;
    }
    public List<Date> loginDatesReader(String[] previousdates) {
        List<Date> datelist = new ArrayList<>();
        for(String str: previousdates){
            Date d = new Date(Long.parseLong(str));
            datelist.add(d);
        }
        return datelist;
    }

    public boolean checkEmpty() throws IOException {
//        String filepath = String.valueOf(Paths.get("UserDatabase.csv").toAbsolutePath());
        BufferedReader file = new BufferedReader(new FileReader(this.filepath));
        return file.readLine() == null;
    }
}
