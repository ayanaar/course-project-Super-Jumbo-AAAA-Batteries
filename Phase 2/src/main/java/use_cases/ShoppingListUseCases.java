package use_cases;

import entities.ShoppingList;
import entities.Item;
import gateway.SavingManager;
import helpers.Sorter;
import helpers.TimSorter;


/**
 * This class interacts with the shopping list entities.
 */
public class ShoppingListUseCases implements DataHandlingUseCase {
	private final ShoppingList shoppingList;

	/**
	 * Initialize an empty shopping list.
	 */
	public ShoppingListUseCases() {
		Sorter<Item> sorter = new TimSorter<>();
		this.shoppingList = new ShoppingList(sorter);
	}

	/**
	 * Return the user's shopping list that will be printed to the user.
	 *
	 * @return the user's shopping list.
	 */
	public String returnShoppingList() {
		return this.shoppingList.toString();
	}

	/**
	 * Add the given item (name and quantity) to the user's shopping list.
	 *
	 * @param name          the name of the item being added.
	 * @param quantity      the quantity of the item being added.
	 */
	public void addShoppingListItem(String name, int quantity) {
		Item item = new Item(name, quantity);
		this.shoppingList.addItem(item);
	}

	/**
	 * Remove the item at the given index from the user's shopping list.
	 *
	 * @param index the index of the item being removed.
	 */
	public void removeShoppingListItem(int index) {
		this.shoppingList.removeItem(index);
	}

	/**
	 * Sort the shopping list items.
	 */
	public void sortShoppingList() {
		this.shoppingList.sortItems();
	}

	/**
	 * Save the shopping list to the csv file.
	 *
	 * @param username the username of the user that program is handling the session of
	 */
	public void saveList(String username) {
		SavingManager.ShoppingListSaver(this.toStringBuilder(), username);
	}


	/**
	 * Return a string representation of the user's shopping list.
	 *
	 * @return a string representation of the user's shopping list.
	 */
	private StringBuilder toStringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("index,item name,quantity\r\n");
		Item item;

		// Loop through each item in the inventory
		for (int i = 0; i < this.shoppingList.getSize(); i++) {
			item = this.shoppingList.getItem(i); // Get item
			sb.append(i).append(","); // Add index
			sb.append(item.getName()).append(",");  // Add item name
			sb.append(item.getQuantity()); // Add quantity
			sb.append("\r\n");
		}

		return sb;
	}
}
