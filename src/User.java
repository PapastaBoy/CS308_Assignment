import org.jetbrains.annotations.NotNull;

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
    private String password;
    public User(String email) {
        this.email = email;
        this.password = passwordMaker();
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
    public String passwordMaker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Password must contain:\n" +
                " • at least 8 Characters\n" +
                " • at least 1 Capital Letter\n" +
                " • at least 1 Number\n" +
                " • at least 1 special character");
        System.out.print("Please enter password: ");
        String password = scanner.nextLine();

        // check password for security and confirmation
        while (true) {
            while (!checkPass(password)) {
                System.out.println("Please enter password: ");
                password = scanner.nextLine();
            }

            // confirm the user knows their password
            System.out.println("Confirm password: ");
            String pass2 = scanner.nextLine();
            if (pass2.equals(password)) {
                System.out.println("Password entered correctly");
                System.out.println("Successfully created password");
                return password;
            }
        }
    }

    /**
     * checks the password using <a href="https://en.wikipedia.org/wiki/Regular_expression">regex</a>
     * to ensure that all requirements are met then ensure the user can recall their password
     *
     * @param password
     * @return boolean
     */
    private boolean checkPass(@NotNull String password) {
        // check for 8 or more chars
        if (!password.matches(".{8,}+")) {
            System.out.println("Password must contain at least 8 characters");
            return false;
        }
        // check for capital letters
        if (!password.matches("[A-Z]+")) {
            System.out.println("Password must contain at least 1 capital letter");
            return false;
        }
        // check for number
        if (!password.matches("[0-9]+")) {
            System.out.println("Password must contain at least 1 number");
            return false;
        }
        // check for symbols
        if(!password.matches("[!%$?#£*&()^]+")) {
            System.out.println("Password must contain at least 1 special character \n ( !%$?#£*&()^ )");
            return false;
        }
        return true;
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
