import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTests {
    @Test
    public void createUser() {
        User testUser = new User("strath.user.2023@uni.strath.ac.uk");
        Assertions.assertEquals("strath.user.2023@uni.strath.ac.uk", testUser.getEmail());
        Assertions.assertEquals("StrathTest12!", testUser.getPassword());
    }
}
