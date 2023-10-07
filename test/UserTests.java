import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UserTests {

    /**
     * Test for checking if the user enters a correct password the system allows the password to be created
     *
     * @see Test
     */
    @Test
    public void createUser() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(("StrathTest12!\rStrathTest12!").getBytes());
        System.setIn(in);

        User testUser = new User("strath.user.2023@uni.strath.ac.uk");

        System.setIn(sysInBackup);

        Assertions.assertEquals("strath.user.2023@uni.strath.ac.uk", testUser.getEmail());
        Assertions.assertEquals("StrathTest12!", testUser.getPassword());
    }


}
