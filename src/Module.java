/**
 * A Module is a class that is taught by a lecturer and attended by students.<br>
 * Each module is worth a certain number of credits and has a name and code.<br>
 * Each module will have a certain number of attempts allowed.<br>
 * Each module will store their lecture and lab notes.<br>
 * A module is assigned to a {@link Course}<br>
 * @see Course
 */
public class Module {
    String code;
    String name;
    int maxAttempts;
    int credits;

    public Module(String code, String name, int maxAttempts, int credits) {
        this.code = code;
        this.name = name;
        this.maxAttempts = maxAttempts;
        this.credits = credits;
    }
}
