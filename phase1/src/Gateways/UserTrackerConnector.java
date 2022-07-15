package Gateways;

import Entities.User.Admin;
import Entities.User.Customer;
import Entities.User.User;
import Entities.User.UserTracker;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTrackerConnector extends DatabaseConnector {
    public UserTrackerConnector() throws IOException {
    }

    @Override
    public void Save() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        for(User user : new UserTracker()){
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
            User newUser = lineToUser(line);
            UserTracker.addUser(newUser);
        }
        br.close();
    }

    private User lineToUser(String line) {
        User newUser;
        String [] userinfo = line.split(",");
        if (userinfo[9].equals("true")){
            newUser = new Admin(userinfo[0], userinfo[1], Integer.parseInt(userinfo[2]),
                    Integer.parseInt(userinfo[3]), Integer.parseInt(userinfo[4]), userinfo[5],
                    Boolean.parseBoolean(userinfo[6]));
        } else {
            newUser = new Customer(userinfo[0], userinfo[1], Integer.parseInt(userinfo[2]),
                    Integer.parseInt(userinfo[3]), Integer.parseInt(userinfo[4]), userinfo[5],
                    Boolean.parseBoolean(userinfo[6]));
        }
        newUser.changeAddress(userinfo[7]);
        String[] previousDates = userinfo[8].split("\\|");
        if (!previousDates[0].equals("")) {
            newUser.updateDateList(loginDatesReader(previousDates));
        }
        return newUser;
    }
    private List<Date> loginDatesReader(String[] previousDates) {
        List<Date> dateList = new ArrayList<>();
        for(String str: previousDates){
            Date d = new Date(Long.parseLong(str));
            dateList.add(d);
        }
        return dateList;
    }

    @Override
    protected String getDatabaseName () {
        return "UserDatabase";
    }
}
