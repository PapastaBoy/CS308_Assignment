import java.util.Date;

/**
 * A Lecturer is a subclass of {@link Person} and a sub-subclass of a {@link User} <br>
 * A Lecturer has different permissions to a {@link Student}
 * @see Person
 * @see User
 * @see Student
 */
public class Lecturer extends Person{
    public Lecturer(String email, String password, String firstName, String secondName, String gender, Date DOB) {
        super(email, password, firstName, secondName, gender, DOB);
    }
}
