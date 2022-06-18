import ControllersAndPresenters.LoginMenu;
import UseCases.Load;
import UseCases.Save;

import java.io.IOException;
import java.text.ParseException;

public class MainApplication {
    public static void main(String[] args) throws IOException, ParseException {
        new Load();
        // Call LoginMenu ...
        LoginMenu.loginPage();
        new Save();
    }
}
