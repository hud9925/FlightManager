package Gateways;

import Entities.User.Admin;
import Entities.User.Customer;
import Entities.User.User;
import Entities.User.UserTracker;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserTrackerConnector extends DatabaseConnector {
    public UserTrackerConnector() throws IOException {
    }

    @Override
    public void Save() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        Map<String, User> allusers = UserTracker.getAllUsers();
        for(User user : allusers.values()){
            pw.write(user.toString() + "\n");
        }
        pw.close();
    }

    @Override
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

    private User lineToUser(String line) {
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
    private List<Date> loginDatesReader(String[] previousdates) {
        List<Date> datelist = new ArrayList<>();
        for(String str: previousdates){
            Date d = new Date(Long.parseLong(str));
            datelist.add(d);
        }
        return datelist;
    }

    @Override
    protected String getDatabaseName () {
        return "UserDatabase";
    }
}
