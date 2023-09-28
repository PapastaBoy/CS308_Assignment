/**
 * The user is the superclass that is used to describe all the users on the app. <br>
 * A user can branch to a {@link Manager}, or a {@link Person} <br>
 * A user has an email (username) and a password
 * @see Manager
 * @see Person
 */
public class User {
    String email;
    String password;
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
