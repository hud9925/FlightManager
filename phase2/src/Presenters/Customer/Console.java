package Presenters.Customer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Console {

    /**
     * Prompt the user for input.
     *
     * @param message The message to display.
     * @return The user input string.
     */
    protected static String prompt (String message) {
        return prompt(new String[]{message}, ".*");
    }

    /**
     * Prompt the user for input.
     *
     * @param messages An array of messages to display. Each item in the array will be displayed in a new line.
     * @return The user input string.
     */
    protected static String prompt (String[] messages) {
        return prompt(messages, ".*");
    }

    /**
     * Prompt the user for input and verify the input against a regex. If the input does not match the regex, the user
     * is prompt to input again.
     *
     * @param message The message to display.
     * @param regex The regex to check the user input against with.
     * @return The user input string.
     */
    protected static String prompt (String message, String regex) {
        return prompt(new String[]{message}, regex);
    }

    /**
     * Prompt the user for input and verify the input against a regex. If the input does not match the regex, the user
     * is prompt to input again.
     *
     * @param messages An array of messages to display. Each item in the array will be displayed in a new line.
     * @param regex The regex to check the user input against with.
     * @return The user input string.
     */
    protected static String prompt (String[] messages, String regex) {
        for (String message : messages) {
            System.out.println(message);
        }
        return getInput(regex);
    }

    /**
     * Get the user input that match the regex. If the input does not match the regex, the user is prompt to input
     * again.
     *
     * @param regex The regex to check the user input against with.
     * @return The user input string.
     */
    private static String getInput (String regex) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!matchRegex(input, regex)) {
            System.out.println("Invalid input, please try again.");
            input = scanner.nextLine();
        }
        return input;
    }

    /**
     * Check whether a string match a regex, ignoring cases.
     *
     * @param string The string to check.
     * @param regex The regex to check the string against with.
     * @return A boolean indicating whether the string match the regex.
     */
    private static boolean matchRegex (String string, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
