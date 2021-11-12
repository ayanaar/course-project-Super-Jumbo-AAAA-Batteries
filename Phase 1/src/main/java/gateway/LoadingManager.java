package gateway;

import entities.Item;
import entities.FoodItem;
import entities.InventoryList;
import entities.ShoppingList;
import use_cases.InventoryUseCases;
import use_cases.ShoppingListUseCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * This Class is an Interface Adapter that incorporates the methods that convert
 * data from the format suitable to uses cases and entities to the format suitable
 * to external csv database.
 */
public class LoadingManager {

    /**
     * This is the method that converts the Inventory Lists to csv convertable format and
     * runs the interaction between the use cases and the database.
     */
    public static InventoryList InventoryListLoader() {
        InventoryList inventoryList = new InventoryList();
        String fileName = "src/resources/inventory_list.csv";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            inputStream.nextLine();
            while (inputStream.hasNext()) {
                String data = inputStream.next();
                String[] values = data.split(",");
                String name = values[1];
                int quantity = Integer.parseInt(values[2]);
                LocalDate expiryDate = LocalDate.parse(values[3]);
                FoodItem item = new FoodItem(name, quantity, expiryDate);
                inventoryList.addItem(item);
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

    /**
     * This is the method that converts the Shopping Lists to csv convertable format and
     * runs the interaction between the use cases and the database.
     */
    public static ShoppingList ShoppingListLoader() {
        ShoppingList shoppingList = new ShoppingList();
        String fileName = "src/resources/shopping_list.csv";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            inputStream.nextLine();
            while (inputStream.hasNext()) {
                String data = inputStream.next();
                String[] values = data.split(",");
                String name = values[1];
                int quantity = Integer.parseInt(values[2]);
                Item item = new Item(name, quantity);
                shoppingList.addItem(item);
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return shoppingList;
    }
}

