package Presenters;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Console {

    /**
     * Prompt the user for input.
     *
     * @param message The message to display.
     * @return The user input string.
     */
    public static String prompt (String message) {
        return prompt(new String[]{message}, ".*");
    }

    /**
     * Prompt the user for input.
     *
     * @param messages An array of messages to display. Each item in the array will be displayed in a new line.
     * @return The user input string.
     */
    public static String prompt (String[] messages) {
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
    public static String prompt (String message, String regex) {
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
    public static String prompt (String[] messages, String regex) {
        for (String message : messages) {
            System.out.println(message);
        }
        return getInput(regex);
    }

    /**
     * Prompt the user for input, and parse the input to an integer.
     *
     * @param message The message to display.
     * @param allowNegative Whether negative value is accepted.
     * @return The user input integer.
     */
    public static int promptForInt (String message, boolean allowNegative) {
        return promptForInt(new String[]{message}, allowNegative);
    }

    /**
     * Prompt the user for input, and parse the input to an integer.
     *
     * @param messages An array of messages to display. Each item in the array will be displayed in a new line.
     * @param allowNegative Whether negative value is accepted.
     * @return The user input integer.
     */
    public static int promptForInt (String[] messages, boolean allowNegative) {
        String regex;
        if (allowNegative) {
            regex = "^-?\\d+$";
        } else {
            regex = "^\\d+$";
        }
        String intString = prompt(messages, regex);
        int result;
        try {
            result = Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            return promptForInt("Invalid input, please try again.", allowNegative);
        }
        return result;
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
