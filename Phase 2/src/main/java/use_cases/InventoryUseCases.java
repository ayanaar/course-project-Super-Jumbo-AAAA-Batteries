package use_cases;

import entities.InventoryList;
import entities.Item;
import entities.FoodItem;
import gateway.SavingManager;
import helpers.Sorter;
import helpers.TimSorter;

import java.time.LocalDate;


/**
 * This class interacts with the inventory entities.
 */
public class InventoryUseCases implements DataHandlingUseCase {
	private final InventoryList inventory;

	/**
	 * Initialize an empty inventory.
	 */
	public InventoryUseCases() {
		Sorter<Item> sorter = new TimSorter<>();
		this.inventory = new InventoryList(sorter);
	}

	/**
	 * Return the user's inventory that will be printed to the user.
	 *
	 * @return the user's inventory.
	 */
	public String returnInventory() {
		return this.inventory.toString();
	}

	/**
	 * Add the given item (name, quantity, and expiry date, if applicable)
	 * to the user's inventory.
	 *
	 * @param name          the name of the item being added.
	 * @param quantity      the quantity of the item being added.
	 * @param expiryDate    the expiry date of the item being added (YYYY-MM-DD).
	 */
	public void addInventoryItem(String name, int quantity, String expiryDate) {
		Item item;
		if (expiryDate.isEmpty()) {
			// Item does not have an expiry date
			item = new Item(name, quantity);
		} else {
			// Item has an expiry date
			item = new FoodItem(name, quantity, LocalDate.parse(expiryDate));
		}
		this.inventory.addItem(item);
	}

	/**
	 * Remove the item at the given index from the inventory.
	 *
	 * @param index the index of the item being removed.
	 */
	public void removeInventoryItem(int index) {
		this.inventory.removeItem(index);
	}

	/**
	 * Sort the inventory items.
	 */
	public void sortInventory() {
		this.inventory.sortItems();
	}

	/**
	 * Save the inventory list to the csv file.
	 *
	 * @param username the username of the user that program is handling the session of
	 */
	public void saveList(String username) {
		SavingManager.InventoryListSaver(this.toStringBuilder(), username);
	}

	/**
	 * Return a string representation of the user's inventory.
	 *
	 * @return a string representation of the user's inventory.
	 */
	private StringBuilder toStringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("index,item name,quantity,expiry date\r\n");
		Item item;

		// Loop through each item in the inventory
		for (int i = 0; i < this.inventory.getSize(); i++) {
			item = this.inventory.getItem(i); // Get item
			sb.append(i).append(","); // Add index
			sb.append(item.getName()).append(",");  // Add item name
			sb.append(item.getQuantity()).append(","); // Add quantity

			if (item instanceof FoodItem) {
				sb.append(((FoodItem) item).getExpiryDate()); // Add expiry date
			}

			sb.append("\r\n");
		}

		return sb;
	}
}
