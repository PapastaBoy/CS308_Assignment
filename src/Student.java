import java.util.Date;

/**
 * A Student is a subclass of {@link Person} and a sub-subclass of a {@link User} <br>
 * A Student has different permissions to a {@link Lecturer}
 *
 * <ul><ul>
 *     <li>view their enrolled course and their modules with their marks</li>
 *     <li>download a lecture note</li>
 *     <li>view their decision if it is available <ul>
 *         <li><strong>award </strong>- decision when all module are passed</li>
 *         <li><strong>resit </strong>- decision is given otherwise</li>
 *         <li><strong>withdraw </strong>- decision is given when all attempts allowed have been attempted</li>
 *     </ul></li>
 * </ul></ul>
 *
 * @see Person
 * @see User
 * @see Lecturer
 */
public class Student extends Person{
    int labMark;
    int examMark;
    public Student(String email, String password, String firstName, String secondName, String gender, Date DOB) {
        super(email, password, firstName, secondName, gender, DOB);
    }
}

//TODO: view their enrolled course and their modules with their marks
//TODO: download a lecture note
//TODO: view their decision if it is available
