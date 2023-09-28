import java.util.Date;

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
