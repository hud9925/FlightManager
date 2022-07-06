import ControllersAndPresenters.LoginMenu;
import UseCases.AddAdmin;
import UseCases.DatabaseConnector;

import java.io.IOException;
import java.text.ParseException;

public class MainApplication {
    public static void main(String[] args) throws IOException, ParseException {
        DatabaseConnector dc = new DatabaseConnector();
        if (dc.checkEmpty()){ // Check if file is empty. If empty then create first admin.
            AddAdmin.addFirstAdmin();
            dc.Save();
        }
        dc.Load();
        // Call LoginMenu ...
        LoginMenu.loginPage();
        dc.Save();
    }
}
