package ControllersAndPresenters;

import UseCases.Save;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveTo {
    public static void SaveTo() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("phase0\\UserDatabase.csv"));
        new Save(pw);
        pw.close();
    }
}
