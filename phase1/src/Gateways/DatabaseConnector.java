package Gateways;

import java.io.IOException;
import java.text.ParseException;

public interface DatabaseConnector {


    void Save() throws IOException;
    void Load() throws IOException, ParseException;
    boolean checkEmpty() throws IOException;
}
