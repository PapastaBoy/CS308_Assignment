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
 */
public class Manager extends User{
    public Manager(String email, String password) {
        super(email, password);
    }


}
