package entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * This class tests the User class.
 */
public class UserTest {
    User user;

    /**
     * Set up for testing User class.
     */
    @Before
    public void setUp() { user = new User("Aamishi", "Avarsekar");
    }

    /**
     * Test that the getName() method returns the User's username.
     */
    @Test(timeout = 100)
    public void testGetName() {
        assertEquals("Aamishi", user.getUsername());
    }

    /**
     * Test that the passwordMatches() method asserts that the user's password is correct.
     */
    @Test(timeout = 100)
    public void testPasswordMatches() {
        assertTrue(user.passwordMatches("Avarsekar"));
    }
}