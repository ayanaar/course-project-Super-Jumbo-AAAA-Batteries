package gateway;

import use_cases.InventoryUseCases;
import use_cases.ShoppingListUseCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * This Class is an Interface Adapter that incorporates the methods that convert
 * data from the format suitable to uses cases and entities to the format suitable
 * to external csv database.
 */
public class LoadingManager {
    private static final String INVENTORY_FILE_NAME = "src/resources/inventory_list.csv";
    private static final String SHOPPING_LIST_FILE_NAME = "src/resources/shopping_list.csv";

    /**
     * This is the method that converts the data in the csv file to an inventory list
     * through the InventoryUseCases and runs the interaction between the use cases
     * and the database.
     */
    public static InventoryUseCases InventoryListLoader() {
        InventoryUseCases inventoryUseCases = new InventoryUseCases();
        File file = new File(INVENTORY_FILE_NAME);

        try {
            Scanner inputStream = new Scanner(file);
            inputStream.nextLine();

            // Loop until there are no more lines in the csv file
            while (inputStream.hasNext()) {
                String line = inputStream.next();
                String[] values = line.split(","); // Split index, item name, quantity, expiry date
                inventoryUseCases.addInventoryItem(values[1], Integer.parseInt(values[2]), values[3]); // Add item to inventory
            }

            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return inventoryUseCases;
    }

    /**
     * This is the method that converts the data in the csv file to a shopping list
     * through the ShoppingListUseCases and runs the interaction between the use cases
     * and the database.
     */
    public static ShoppingListUseCases ShoppingListLoader() {
        ShoppingListUseCases shoppingListUseCases = new ShoppingListUseCases();
        File file = new File(SHOPPING_LIST_FILE_NAME);

        try {
            Scanner inputStream = new Scanner(file);
            inputStream.nextLine();

            // Loop until there are no more lines in the csv file
            while (inputStream.hasNext()) {
                String line = inputStream.next();
                String[] values = line.split(","); // Split index, item name, quantity
                shoppingListUseCases.addShoppingListItem(values[1], Integer.parseInt(values[2])); // Add item to shopping list
            }

            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return shoppingListUseCases;
    }
}

