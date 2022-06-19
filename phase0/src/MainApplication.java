import ControllersAndPresenters.AdminMenu;
import ControllersAndPresenters.LoginMenu;
import UseCases.AddAdmin;
import UseCases.Load;
import UseCases.Save;

import java.io.IOException;
import java.text.ParseException;

public class MainApplication {
    public static void main(String[] args) throws IOException, ParseException {
        new Load();
        if (Load.checkEmpty()){ // Check if file is empty. If empty then create first admin.
            AddAdmin.addFirstAdmin();
            new Save();
        }
        // Call LoginMenu ...
        LoginMenu.loginPage();
        new Save();
    }
}
