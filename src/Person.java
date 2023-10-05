import java.util.Date;
/**
 * The Person is the subclass of {@link User} that is used to describe active users <br>
 * A Person can branch to a {@link Lecturer}, or a {@link Student} <br>
 * A Person has a:
 * <ul><ul>
 *     <li>email - {@link String}</li>
 *     <li>password - String</li>
 *     <li>first name - String</li>
 *     <li>second name - String</li>
 *     <li>gender - String</li>
 *     <li>Date of Birth - {@link Date}</li>
 * </ul></ul>
 *  
 * @see User
 * @see Lecturer
 * @see Student
 */


 // testing hahahaha

 
public class Person extends User{
    String firstName;
    String secondName;
    String gender;
    Date DOB;
    public Person(String email, String password, String firstName, String secondName, String gender, Date DOB) {
        super(email, password);
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.DOB = DOB;
    }
}
