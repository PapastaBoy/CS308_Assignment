import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

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

    /**
     * Test for invalid password, can be duplicated to test different areas of password denial
     *
     * Uses {@link org.mockito.Mockito} to test for user input by capturing arguments passed to a
     * {@link StringAsker} wrapper for asking for user input from a {@link java.util.Scanner}.
     *
     * Makes use of {@link ArgumentCaptor}s to collect all the arguments that have been displayed into
     * System.out and check that they are the correct arguments
     *
     * @see List
     * @see Assertions
     * @see StringAsker
     * @see ArgumentCaptor
     * @see java.util.Scanner
     * @see org.mockito.Mockito
     */
    @Test
    public void createUserFailPassword() {
        StringAsker asker = mock(StringAsker.class);
        when(asker.ask("Please enter password: ")).thenReturn("strathtest2023!");
        when(asker.ask("Password must contain at least 1 capital letter, Please try again: ")).thenReturn("StrathTest2023!");
        when(asker.ask("Confirm password: ")).thenReturn("StrathTest2023!");

        User testUser = new User("strath.user.2023@uni.strath.ac.uk", asker);

        ArgumentCaptor<String> arguments = ArgumentCaptor.forClass(String.class);
        verify(asker, atLeastOnce()).ask(arguments.capture());

        List<String> values = arguments.getAllValues();

        Assertions.assertTrue(values.contains("Please enter password: "));
        Assertions.assertTrue(values.contains("Password must contain at least 1 capital letter, Please try again: "));
        Assertions.assertTrue(values.contains("Confirm password: "));
    }


}
