import java.util.ArrayList;

/**
 * Course is a class that has a code, name description and a number of assigned {@link Module}'s.<br>
 * A course can either run semester 1, semester 2 or both semesters.<br>
 *
 * @see Module
 */
public class Course {
    ArrayList<Module> modules = new ArrayList<>();
    String code;
    String name;
    String description;
    boolean[] semesters = new boolean[]{true, true};

    public Course(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }
}
