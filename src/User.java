import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import java.sql.*;

/**
 * The user is the superclass that is used to describe all the users on the app. <br>
 * A user can branch to a {@link Manager}, or a {@link Person} <br>
 * A user has an email (username) and a password
 * @see Manager
 * @see Person
 */
public abstract class User {
    String email;
    private byte[] hashed_password;

    // ****************** Database stuff ************************

    String myDriver = "com.mysql.cj.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/qhb21193";
    {
        try {
            Class.forName(myDriver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    Connection conn;

    {
        try {
            conn = DriverManager.getConnection(myUrl, "qhb21193", "notmypassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // **********************************************************

    public User(String email) {
        this.email = email;
        try {
            this.hashed_password = hash(passwordMaker(new StringAsker(System.in, System.out)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor used purely for JUnit Mockito testing
     *
     * @param email
     * @param asker
     */
    public User(String email, StringAsker asker) {
        this.email = email;
        try {
            this.hashed_password = hash(passwordMaker(asker));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public void insert(String user_type) throws SQLException {
        String sql = "insert into users (user_type, email, hashed_password)"
                + "values(?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user_type);
        ps.setString(2, email);
        ps.setString(3, toHexString(hashed_password));

        ps.execute();
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
     * @return String
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
        // limit length password
        if (!password.matches(".{8,64}")) {
            return "Password too long, cannot be longer than 64 characters";
        }
        return "valid";
    }

    /**
     * Uses SHA-256 algorithm to hash the password to create a more secure version of the password for storing
     *
     * @param input
     * @return {@link MessageDigest#digest(byte[])}
     * @throws NoSuchAlgorithmException
     */
    private byte[] hash(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing sha
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of input and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Converts the hashed password bye array into a comprehensible hexadecimal readout
     *
     * @param hash
     * @return String value of the hashed password
     */
    String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);

        StringBuilder hexString = new StringBuilder(number.toString(16));

        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();

    }

    public String getPassword() {
        return toHexString(hashed_password);
    }

    public String getEmail() {
        return email;
    }

    public abstract void insert() throws SQLException;
}

//TODO: sign up
//TODO: login
//TODO: update password
