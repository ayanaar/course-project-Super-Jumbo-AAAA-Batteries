package entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests the UserList class.
 */
public class UserListTest {
    User user;
    UserList userList;

    /**
     * Set up for testing UserList class.
     */
    @Before
    public void setUp() {
        user = new User("Aamishi", "Avarsekar");
        userList = new UserList();
    }

    /**
     * Test that the add() method correctly adds a user to the list of users.
     */
    @Test(timeout = 100)
    public void testAdd() {
        UserList.add(user);
        assertEquals(user, userList.getUser("Aamishi"));
    }

    /**
     * Test that the getUser() method correctly returns the User with the associated username.
     */
    @Test(timeout = 100)
    public void testGetUser(){
        assertEquals("Aamishi", user.getUsername());
    }

}
