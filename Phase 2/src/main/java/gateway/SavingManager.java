package gateway;

import java.io.PrintWriter;


/**
 * This Class is an Interface Adapter that incorporates the methods that convert
 * data from the format suitable to uses cases and entities to the format suitable
 * to external csv database.
 */
public class SavingManager {
    private static final String INVENTORY_FILE_PREFIX = "src/resources/";
    private static final String SHOPPING_LIST_PREFIX = "src/resources/";
    private static final String INVENTORY_FILE_NAME = "/inventory_list.csv";
    private static final String SHOPPING_LIST_FILE_NAME = "/shopping_list.csv";

    /**
     * This is the method that converts the Inventory Lists to csv convertable format and
     * runs the interaction between the use cases and the database.
     *
     * @param username the username of the user that program is handling the session of
     */
    public static void InventoryListSaver(StringBuilder sbInventoryList, String username) {
        try {
            PrintWriter pw = new PrintWriter(INVENTORY_FILE_PREFIX + "data_" +  username + INVENTORY_FILE_NAME);;

            pw.write(sbInventoryList.toString());
            pw.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * This is the method that converts the Shopping Lists to csv convertable format and
     * runs the interaction between the use cases and the database.
     *
     * @param username the username of the user that program is handling the session of
     */
    public static void ShoppingListSaver(StringBuilder sbShoppingList, String username) {
        try {
            PrintWriter pw = new PrintWriter(SHOPPING_LIST_PREFIX + "data_" + username + SHOPPING_LIST_FILE_NAME);

            pw.write(sbShoppingList.toString());
            pw.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
