import java.util.Date;

/**
 * A Lecturer is a subclass of {@link Person} and a sub-subclass of a {@link User} <br>
 * A Lecturer has different permissions to a {@link Student}
 *
 * <ul>
 *     <li>update module information</li>
 *     <li>upload or update module materials in each week - <em>lecture notes and lab notes</em></li>
 *     <li>display enrolled students in their modules</li>
 *     <li>update the exam record of every enrolled student</li>
 * </ul>
 *
 * @see Person
 * @see User
 * @see Student
 */
public class Lecturer extends Person{
    public Lecturer(String email,String firstName, String secondName, String gender, Date DOB) {
        super(email, firstName, secondName, gender, DOB);
    }
}

//TODO: update module information
//TODO: upload or update module materials in each week - <em>lecture notes and lab notes</em>
//TODO: display enrolled students in their modules
//TODO: update the exam record of every enrolled student
