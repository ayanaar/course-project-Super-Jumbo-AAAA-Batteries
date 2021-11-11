package driver;

import controller.ListManager;

import java.util.Scanner;


/**
 * This Gyst class is the driver that interacts with the
 * user through the command line.
 */
public class Gyst {
	// The total number of main menu options
	private final static int TOTAL_MAIN_MENU_OPTIONS = 7;

	/**
	 * This is the main method that runs the interaction between
	 * the user and the command line.
	 */
	public static void main(String[] args) {
		boolean isRunning = true;
		ListManager listManager = new ListManager();
		Scanner scanner = new Scanner(System.in);
		String mainMenuOption; 				// Option from main menu user chose
		String name;					// Name of item
		int quantity;					// Quantity of item
		String expiryDate;					// Expiry date of item
		int index;					// Index of item in inventory/shopping list

		System.out.println("*** Hello! Welcome to gyst! Hope you enjoy your stay. ***\n"); // Greet the user

		// Loop until user exits gyst (option 0 from main menu)
		while (isRunning) {
			// Print main menu options
			Gyst.printMainMenu();
			
			// Get input from user (option # from main menu)
			System.out.print("\nEnter a number (0 - " + (Gyst.TOTAL_MAIN_MENU_OPTIONS - 1) + "): ");
			mainMenuOption = scanner.nextLine();

			// Determine next actions based on user's chosen main menu option
			switch (mainMenuOption) {
				case "0": 	// User wants to exit
					isRunning = false;
					System.out.println("\n*** Good-bye! Hope to see you again soon! ***");
					break;

				case "1": 	// User wants to see inventory
					System.out.println("\n* Inventory *");				// Indicate to user that this is their inventory
					System.out.println(listManager.printInventory()); 		// Display numbered list of inventory items
					System.out.println("\nPress 'Enter' to return to Main Menu.");
					scanner.nextLine();
					break;

				case "2": 	// User wants to add item to inventory
					System.out.print("\nEnter item name: "); 				// Get item name from user
					name = scanner.nextLine();
					System.out.print("Enter quantity: "); 					// Get quantity from user
					quantity = Integer.parseInt(scanner.nextLine());
					System.out.print("Enter expiry date (-1 if no expiry date): "); 	// Get expiry date from user
					expiryDate = scanner.nextLine();
					listManager.addInventoryItem(name, quantity, expiryDate); 		// Add item to inventory
					System.out.println("\nSuccessfully added " + quantity + " " + name + " to your inventory." + 
							   "\nPress 'Enter' to return to Main Menu.");
					scanner.nextLine();
					break;

				case "3": 	// User wants to remove item from inventory
					System.out.println("\n* Inventory *");				// Indicate to user that this is their inventory
					System.out.println(listManager.printInventory()); 		// Display numbered list of inventory items
					System.out.print("\nEnter corresponding number of the item you want to remove: "); 	// Get index of item user wants to remove
					index = Integer.parseInt(scanner.nextLine());
					listManager.removeInventoryItem(index); 			// Remove item from inventory
					System.out.println("\nSuccessfully removed item " + index + " from your inventory." +
							   "\nPress 'Enter' to return to Main Menu.");
					scanner.nextLine();
					break;

				case "4": 	// User wants to see shopping list
					System.out.println("\n* Shopping List * ");			// Indicate to user that this is their shopping list
					System.out.println(listManager.printShoppingList()); 		// Display numbered list of shopping list items
					System.out.println("\nPress 'Enter' to return to Main Menu.");
					scanner.nextLine();
					break;

				case "5": 	// User wants to add item to shopping list
					System.out.print("\nEnter item name: "); 		// Get item name from user
					name = scanner.nextLine();
					System.out.print("Enter quantity: "); 			// Get quantity from user
					quantity = Integer.parseInt(scanner.nextLine());
		    			listManager.addShoppingListItem(name, quantity); 	// Add item to shopping list
					System.out.println("\nSuccessfully added " + quantity + " " + name + " to your shopping list." +
							   "\nPress 'Enter' to return to Main Menu.");
					scanner.nextLine();
					break;

				case "6": 	// User wants to remove item from shopping list
					System.out.println("\n* Shopping List * ");			// Indicate to user that this is their shopping list
					System.out.println(listManager.printShoppingList()); 		// Display numbered list of shopping list items
					System.out.print("\nEnter corresponding number of the item you want to remove: "); 	// Get index of item user wants to remove
					index = Integer.parseInt(scanner.nextLine());
					listManager.removeShoppingListItem(index); 			 // Remove item from shopping list
					System.out.println("\nSuccessfully removed item " + index + " from your shopping list." +
							   "\nPress 'Enter' to return to Main Menu.");
					scanner.nextLine();
					break;

				default: 	// User enters invalid input
					System.out.println("Invalid. Please only enter a number 0 through " 
							   + (Gyst.TOTAL_MAIN_MENU_OPTIONS - 1) + "." +
							   "\nPress 'Enter' to return to Main Menu.");
					scanner.nextLine();
			}
		}
	}

	/**
	 * Print the main menu options.
	 */
	private static void printMainMenu() {
		System.out.println("* Main Menu *");
		System.out.println("0. Exit");
		System.out.println("1. See inventory");
		System.out.println("2. Add an item to inventory");
		System.out.println("3. Remove an item from inventory");
		System.out.println("4. See shopping list");
		System.out.println("5. Add an item to shopping list");
		System.out.println("6. Remove an item from shopping list");
	}
}

