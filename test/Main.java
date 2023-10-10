import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Manager man = new Manager("strath.manager@uni.strath.ac.uk");
        man.insert();
    }
}
