import java.util.Date;

/**
 * A Student is a subclass of {@link Person} and a sub-subclass of a {@link User} <br>
 * A Student has different permissions to a {@link Lecturer}
 * @see Person
 * @see User
 * @see Lecturer
 */
public class Student extends Person{
    public Student(String email, String password, String firstName, String secondName, String gender, Date DOB) {
        super(email, password, firstName, secondName, gender, DOB);
    }
}
