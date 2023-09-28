import java.util.ArrayList;

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
