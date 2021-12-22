package entities;
import java.util.HashMap;
import java.util.Map;


/**
 * A map of username —> User object.
 */
public class UserList {
    private static final Map<String, User> users = new HashMap<>();

    /**
     * Add user to this user list.
     * @param user the user to add
     */
    public static void add(User user) {
        users.put(user.getUsername(), user);
    }

    /**
     * Return the User associated with username.
     * @param username the username of the user to get.
     */
    public User getUser(String username) {
        return users.get(username);
    }
}
