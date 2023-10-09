//import org.jetbrains.annotations.NotNull;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The user is the superclass that is used to describe all the users on the app. <br>
 * A user can branch to a {@link Manager}, or a {@link Person} <br>
 * A user has an email (username) and a password
 * @see Manager
 * @see Person
 */
public class User {
    String email;
    private final String password;
    public User(String email) {
        this.email = email;
        this.password = passwordMaker(new StringAsker(System.in, System.out));
    }

    /**
     * Constructor used purely for JUnit Mockito testing
     *
     * @param email
     * @param asker
     */
    public User(String email, StringAsker asker) {
        this.email = email;
        this.password = passwordMaker(asker);
    }

    /**
     * This function is used to ask the user to enter their password
     * then check to see if their password meets minimum requirements;
     * checks user password and their recollection of their password
     * to ensure security.
     *
     * @return {@link String} password
     * @see Scanner
     * @see User#checkPass(String)
     */
    public String passwordMaker(StringAsker asker) {

        System.out.println("Password must contain:\n" +
                " • at least 8 Characters\n" +
                " • at least 1 Capital Letter\n" +
                " • at least 1 Number\n" +
                " • at least 1 special character");

        String password = asker.ask("Please enter password: ");

        // check password for security and confirmation
        String password_check_message;
        while (true) {
            password_check_message = checkPass(password);
            while (!password_check_message.equals("valid")) {
                password = asker.ask(password_check_message + ", Please try again: ");
                password_check_message = checkPass(password);
            }

            // confirm the user knows their password
            String pass2 = asker.ask("Confirm password: ");
            if (pass2.equals(password)) {
                System.out.println("Password entered correctly");
                System.out.println("Successfully created password");
                return password;
            }
            password = "";
            System.out.println("Password entered incorrectly, please enter again: ");
        }
    }

    /**
     * checks the password using <a href="https://en.wikipedia.org/wiki/Regular_expression">regex</a>
     * to ensure that all requirements are met then ensure the user can recall their password
     *
     * @param password
     * @return boolean
     */
    private String checkPass(String password) {
        // check for 8 or more chars
        if (!password.matches(".{8,}+")) {
            return "Password must contain at least 8 characters";
        }
        // check for capital letters
        if (!password.matches(".*[A-Z]+.*")) {
            return "Password must contain at least 1 capital letter";
        }
        // check for number
        if (!password.matches(".*[0-9]+.*")) {
            return "Password must contain at least 1 number";
        }
        // check for symbols
        if (!password.matches(".*[!%$?#£*&()^]+.*")) {
            return "Password must contain at least 1 special character ( !%$?#£*&()^ )";
        }
        return "valid";
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

//TODO: sign up
//TODO: login
//TODO: update password
