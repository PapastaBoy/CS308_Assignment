/**
 * A Manager is a subclass of {@link User} and has the most permissions over the app</li>
 * <ul> 
 *     <li>A manager can view sign-up workflow</li>
 *     <li>Approve Users who signed up to create their accounts. </li>
 *     <li>Approve {@link Lecturer}s who signed up to create their account.</li>
 *     <li>Manage other Users accounts </li>
 *     <li>Assign a module to a given Lecturer.</li>
 *     <li>Enrol {@link Student} in a given course. </li>
 *     <li>Issue Student decision</li>
 *     <li>Add a business rule</li>
 *     <li>Add new course</li>
 *     <li>Add module</li>
 *     <li>Assign module to course</li>
 *     <li>Display course details</li>
 *     <li>Display module details</li>
 *     <li>Update course information</li>
 * </ul>
 *
 * @see User
 * @see Lecturer
 * @see Student
 * @author Connor
 */
public class Manager extends User{
    public Manager(String email, String password) {
        super(email, password);
    }
}

//TODO A manager can view sign-up workflow
//TODO Approve Users who signed up to create their accounts.
//TODO Approve Lecturers who signed up to create their account.
//TODO Manage other Users accounts
//TODO Assign a module to a given Lecturer.
//TODO Enrol Student in a given course.
//TODO Issue Student decision
//TODO Add a business rule
//TODO Add new course
//TODO Add module
//TODO Assign module to course
//TODO Display course details
//TODO Display module details
//TODO Update course information
