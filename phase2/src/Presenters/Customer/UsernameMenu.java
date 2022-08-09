package Presenters.Customer;

import Presenters.Console;

public class UsernameMenu {

    public static String getUsernamePrompt(){
        return Console.prompt("Please enter your username: ");
    }
}
