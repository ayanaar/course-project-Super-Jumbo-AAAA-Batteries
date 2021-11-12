package gateway;


import entities.InventoryList;
import entities.ShoppingList;
import use_cases.InventoryUseCases;
import use_cases.ShoppingListUseCases;

import java.io.File;
import java.io.PrintWriter;

/**
 * This Class is an Interface Adapter that incorporates the methods that convert
 * data from the format suitable to uses cases and entities to the format suitable
 * to external csv database.
 */
public class SavingManager {

    /**
     * This is the method that converts the Inventory Lists to csv convertable format and
     * runs the interaction between the use cases and the database.
     */
    public static void InventoryListSaver(InventoryList inventoryList) {
        StringBuilder sbInventoryList = inventoryList.toStringBuilder();
        try {
            PrintWriter pw = new PrintWriter(new File("src/resources/inventory_list.csv"));

            pw.write(sbInventoryList.toString());
            pw.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * This is the method that converts the Shopping Lists to csv convertable format and
     * runs the interaction between the use cases and the database.
     */
    public static void ShoppingListSaver(ShoppingList shoppingList) {
        StringBuilder sbShoppingList = shoppingList.toStringBuilder();
        try {
            PrintWriter pw = new PrintWriter(new File("src/resources/shopping_list.csv"));

            pw.write(sbShoppingList.toString());
            pw.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
