package com.archsoft;

import java.io.Console;
import java.util.Arrays;

// Sample from: https://www.jetbrains.com/help/idea/debug-a-java-application-using-a-dockerfile.html#create-app

public class Main {

    public static void main (String[] args) {
        Console c = System.console();
        String login = c.readLine("Enter your login: ");
        char[] oldPassword = c.readPassword("Enter your old password: ");

        if (verify(login, oldPassword)) {
            boolean match =false;
            while(!match) {
                char[] newPassword1 = c.readPassword("Enter your new password: ");
                char[] newPassword2 = c.readPassword("Enter new password again: ");
                match = Arrays.equals(newPassword1, newPassword2);
                if (match) {
                    change(login, newPassword1);
                    c.format("Password for %s changed.%n", login);
                } else {
                    c.format("Passwords don't match. Try again.%n");
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            }
        }

        Arrays.fill(oldPassword, ' ');
    }

    // Dummy verify method
    static boolean verify(String login, char[] password) {
        return true;
    }

    // Dummy change method
    static void change(String login, char[] password) {
    }
}
