### Progress Report

## Specification

During the past two weeks, we have been planning an inventory system called gyst. 

gyst is a command-line interface that manages your household inventory. 

By using gyst, a user can keep track of their shopping list (what they need to purchase) and their inventory (what they have in their home).

## CRC Model

The CRC model for this project includes four entities (Item, FoodItem, InventoryList, and ShoppingList), 

two use cases classes (InventoryUseCases and ShoppingListUseCases), one controller (ListManager), and one driver (Gyst).

## Scenario Walk-through

The scenario walk-through outlines how a user may use gyst to keep track of their inventory. 

In our example, the user, Uncle Drew, updated his inventory based on the items that he recently bought. 

He used the command-line interface, which interacted with the controller, and the controller utilized the use case classes to modify the entities. 

We wrote our scenario walk-through to demonstrate a typical day-to-day use of gyst. 

## Skeleton Program

The skeleton program consists of a basic command-line interface that the user can work with to see and modify both the inventory and shopping lists.

We modeled the code after our scenario walk-through, where our user was able to add an item (with a quantity and expiry date), 

and see their updated inventory. Our skeleton program also consists of a user-friendly UI, 

where the user can easily navigate through the main menu. We assume that the user always enters valid input. 

## Questions/Concerns

Some of our questions and concerns are as follows: 

<ol>
<li>How should we go about designing global constants?</li>
<li>Stylistically speaking, is our main method considered too lengthy? If so, how could we condense it?</li>
<li>Should we split up our use cases?</li>
<li>We believe that our code follows the single responsibility principle, but we wanted to ask your opinion?</li>
</ol>

## What has Worked Well with our Design

Our design followed the Clean Architecture principles. 

We designed the command-line interface so that the user interacts with the main menu only. 

This ensures that the user can navigate through the inventory system easily, 

without directly interacting with the high level layer elements such as Entities.

In addition, we implemented the use case classes under two categories: ShoppingListUseCases and InventoryListUseCases. 

If we were to complete the implementation through the classic use case class design, 

there would be duplicate methods that work in the same manner for both the shopping list and the inventory list. 

With this choice, first, the controller can directly refer to the corresponding list type. 

Then, the controller can call the method that is required for the specific use case to execute the use-case specific workflow.

We consistently checked whether our implementation/design choices adhere to the five SOLID principles of object oriented design. 

In terms of the Open/Closed principle, instead of adding a feature/attribute(that only Foods have) to our Item class, 

we implemented another class, FoodItem, that extends the Item class and adds the expiry date property.

## Group Contributions 

All participants contributed equally for phase 0. 

We all worked together to complete the CRC cards and had many discussions regarding various design choices (e.g., implementing an interface vs. implementing a class). 

We all came up with a scenario walk-through that touched on the most important classes from the CRC cards. Additionally, 

we split up our group into two sub-groups of 3 to work on the skeleton program. 

One group worked on the entities while the other worked on the controller and use cases. 

We then came together to discuss, create the unit test and implement any changes based on feedback from each other. 

We also equally split up any documentation that we needed to do. Furthermore, for task 6, we each completed one of the sections of this report. 

## Next Steps

Depending on the feedback from the TA, we might consider dividing our use case classes into subclasses so that each use case class corresponds to a single workflow. 

We will need to add and implement an option for the user to move items from their shopping list to their inventory and vice versa. 

Also, at this point, we assumed that the user will always provide valid input, but this will not be the case in the future. 

Therefore, we will need to implement some exception handling.

## Below is a list of what each group member plans to work on next: 

Sam will work on adding additional test cases and debug accordingly

Jennifer will work on incorporating newly introduced classes into our code

Aamishi will work on categorizing food items based on expiry dates

Ali will work on incorporating the clean architecture principles to our code

Alissa will work on the structure of newly introduced classes

Ayanaa will provide detailed documentation to newly introduced classes
