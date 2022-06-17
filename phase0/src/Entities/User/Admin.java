package Entities.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Admin extends User{

    public Admin(String username, String password, int birthYear, int birthMonth, int birthDay, String email, boolean isMember) {
        super(username, password, birthYear, birthMonth, birthDay, email, isMember);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }

    public String toString(){
        List<Date> ls = super.getDateList();
        String datestrs = "";
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        for(Date d:ls){
            String datestr = dateFormat.format(d);
            datestrs = datestrs + datestr + "|";
        }

        return super.getUsername() + "," + super.getPassword() + "," + super.getBirthYear() + ","
            + super.getBirthMonth() + "," + super.getBirthDay() + "," + super.getEmail() + "," + super.getMemberStatus()
            + "," + super.getAddress() + "," + datestrs + ",true";}
}
