package UseCases;

import Entities.User.Admin;
import Entities.User.Customer;
import Entities.User.User;
import Entities.User.UserTracker;

import java.io.*;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DatabaseConnector {

    private final String filepath;

    public DatabaseConnector(){
        this.filepath = String.valueOf(Paths.get("phase1/UserDatabase.csv").toAbsolutePath());
//        this.filepath = String.valueOf(Paths.get("UserDatabase.csv").toAbsolutePath());
//        Above is the reserved code that fails on some devices
    }

    public void Save() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(this.filepath));
        Map<String, User> allusers = UserTracker.getAllUsers();
        for(User user : allusers.values()){
            pw.write(user.toString() + "\n");
        }
        pw.close();
    }
    public void Load() throws IOException, ParseException {
//        String filepath = String.valueOf(Paths.get("UserDatabase.csv").toAbsolutePath());
        BufferedReader br = new BufferedReader(new FileReader(this.filepath));
        String line;
        while((line = br.readLine())!= null) {
            User newuser = lineToUser(line);
            UserTracker.addUser(newuser);
        }
        br.close();
    }

    public User lineToUser(String line) throws ParseException {
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
        newuser.setDateList(loginDatesReader(previousdates));
        return newuser;
    }
    public List<Date> loginDatesReader(String[] previousdates) throws ParseException {
        List<Date> datelist = new ArrayList<>();
        for(String str: previousdates){
            Date d = new SimpleDateFormat("dd/MM/yyyy").parse(str);
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
