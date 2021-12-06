# Design Document

## Table of Contents

1. [Introduction](#introduction)
   1. [Specification](#specification)
   2. [Changes from Phase 1 to Phase 2](#changes)
2. [Implementation](#implementation)
   1. [Clean Architecture](#clean-architecture)
   2. [Scenario Walkthrough](#scenario)
   3. [SOLID Principles](#solid)
   4. [Major Design Decisions](#major)
3. [Design Nuances](#design-nuances)
   1. [Design Patterns](#design-patterns)
4. [Code Organization](#organization)
   1. [Packaging Strategies](#package)
   2. [Use of GitHub Features](#github)
5. [Progress Report](#progress)
   1. [What Worked Well with Our Design](#worked-well)
   2. [Author Details](#author)
   3. [Significant Pull Requests](#pull-requests)


## 1 Introduction <a name="introduction"></a>
### 1.1 Specification  <a name="specification"></a>

_gyst_ is a web application that organizes your household inventory and assists you in your everyday life. Different requirements such as food and household items can be kept track of in terms of expiry dates (if applicable) and quantity. There are two main lists of items defined. First, we have the list of needs (shopping list) of the user. The second list of items is the inventory of the user. Each item in the inventory will have attributes such as expiry date (if applicable), and the quantity. In the beginning, the list of needed items will be initialized, and the user can add items to that list by logging items one by one. The user can also remove items from their inventory or shopping list one item at a time. The user can see their updated inventory and shopping lists. There is an option for the user to save their inventory and shopping list for later use. This website will allow the user to be efficient and organized by decluttering their life.

### 1.2 Changes from Phase 1 to Phase 2 <a name="changes"></a>

In phase 2, we added entities, use cases, a controller, and unit tests for user authentication. We also updated our data persistence/serialization (via CSV files) accordingly by saving user information and the user’s corresponding inventory and shopping list.

In phase 1, we did not have the website connected to our Java code yet. In phase 2, we were able to connect the program to the website. We also added the user authentication to the website and connected it to the relevant Java code.

We implemented the strategy design pattern in phase 2, which we used to sort the expiry dates of items in a user’s inventory in terms of closest date to expiration. If an item does not have an expiry date, it is sorted alphabetically by name instead. This means that the items in the shopping list are sorted alphabetically. Unit tests for this design pattern were added as well.

In phase 2, we also did some refactoring. For example, most noticeably, we added an interface for the ShoppingList and InventoryList entities since they have a lot of methods in common. We also moved the toStringBuild() method from the entity layer to the use case layer as it seemed to be more UI-specific.

## 2 Implementation <a name="implementation"></a>
### 2.1 Clean Architecture <a name="clean-architecture"></a>

![image](https://user-images.githubusercontent.com/76668055/141663572-04f7cb01-ae35-42c3-8ada-8d6aa204b1c7.png)

In the diagram above, we see where inheritance and interface implementation occurs in each layer. In the entities layer, we see that FoodItem is a child of Item, and it inherits all methods and attributes from the Item class. In the Use Cases layer, we can see that there is a DataHandlingUseCase interface that is implemented by the ShoppingListUseCases class and the InventoryUseCase class.

Our design followed the Clean Architecture principles. We designed _gyst_ so that the user interacts with the website. This ensures that the user can navigate through the inventory system easily, without directly interacting with the high level layer elements such as Entities.

One of the features we implemented for phase 2 was the login system. We used the skeleton of the login system provided to us in lecture (credit to the computer science teaching team). We developed the system further to make it suitable for our project. We also made changes to the system so that it adheres to Clean Architecture.

In addition, we implemented the use case classes under two categories: ShoppingListUseCases and InventoryListUseCases. If we were to complete the implementation through the classic use case class design, there would be duplicate methods that work in the same manner for both the shopping list and the inventory list. With this choice, first, the controller can directly refer to the corresponding list type. Then, the controller can call the method that is required for the specific use case to execute the use-case specific workflow.

The Dependency Rule is consistently followed when interacting with details in the outer layer. For example, when interacting with the database, only the gateways, LoadingManager and SavingManager, interact with the CSV files. These gateways also only interact with the use cases, InventoryUseCases and ShoppingListUseCases, in order to update or get data from the InventoryList and ShoppingList entities. The gateways do not interact with these entities directly.

### 2.2 Scenario Walkthrough <a name="scenario"></a>

Uncle Drew just came home from the grocery store. He bought 99 bananas and wants to update his gyst inventory. Uncle Drew opens the _gyst_ website. The gateway, LoadingManager class, loads the items currently in Uncle Drew's inventory and shopping list from the CSV files. These items are displayed on the website. To add the bananas to his inventory from the website, Uncle Drew enters “bananas” for the input to item name, 99 for the input to quantity, and “2021-11-27” for the input to expiry date. Then, he presses the “Add item” button.

Now, the controller, ListManager, calls a method in the InventoryUseCases class to handle the addition of the item name, quantity, and expiry date to the inventory. This method creates an Item entity with the given item name, quantity and expiry date. Then, it calls a method in the entity, InventoryList, which adds the Item entity to the inventory list. The website is then updated to display Uncle Drew's updated inventory with the 99 bananas. Finally, Uncle Drew presses the "Save" button and the gateway, SavingManager, interacts with the InventoryUseCases and ShoppingListUseCases to save Uncle Drew's inventory and shopping list. Uncle Drew is satisfied and exits the website to go enjoy his 99 bananas.

### 2.3 SOLID Principles <a name="solid"></a>

We consistently checked whether our implementation/design choices adhere to the five SOLID principles of object oriented design.

Our design adheres to the single responsibility principle. For example, the FoodItem class only has the responsibilities related to a food item, such as item name, quantity, expiry date, updating quantity, and comparing expiry date to today's date.

Our design adheres to the open/closed principle and Liskov substitution principle. For example, instead of adding a feature/attribute (that only Foods have) to our Item class, we implemented another class, FoodItem, that extends the Item class and adds the expiry date property.

Our design adheres to the interface segregation principle. For example, we have a DataHandlingUseCase interface that contains one saveList() method. This method is relevant to saving the data of a list (i.e., the inventory and shopping list).

### 2.4 Major Design Decisions <a name="major"></a>

Our serialization for Phase 1 was suitable for a single user only. For this phase, we updated our serialization system to store inventory lists and shopping lists of multiple users for later reference. For such extensions to the gateway classes, we had two options: Our first option was to store all of the inventory and shopping list items at a single CSV file through cross-matching the user information to specific entries of the item list. The second option was to separate the user-specific data into user-specific storage folders. For the implementation of the first option, we needed to store the inventory lists and shopping lists as entries to a column of the CSV file. Yet, since our inventory lists and shopping lists are relatively complex data structures(at least more complex than tuples of two elements), it needed a second layer of conversion from the CSV file to the InventoryList and ShoppingList objects. If we were to use a database management system, this process would be relatively fast. Yet, we have implemented a local serialization system. Therefore, we decided that providing user-specific folders to our system would be faster than the first option. All in all, we ended up implementing the system to create and sustain the data through a user-specific data storage system.

Another major design decision we had to make was regarding an earlier topic introduced in the course, "Inheritance vs Interface". After we received feedback from our TA regarding defining an abstract class for our classes InventoryList and ShoppingList, we started debating over whether to implement an abstract class for our classes or to define an interface that both classes implement. Though the initial advice was to create abstract classes, we decided to go with the interface implementation since InventoryLists store items with the allowance of entering expiry dates while ShoppingLists does not allow an expiry date for a member Item object. With this, we have methods in both these classes that share the same purpose yet differentiate in terms of their explicit implementation and use cases.


## 3 Design Nuances <a name="design-nuances"></a>
### 3.1 Design Patterns <a name="design-patterns"></a>

Our group implemented the dependency injection design pattern. For example, when adding an Item or FoodItem to an InventoryList object, instead of hardcoding the type Item or FoodItem into the InventoryList, the InventoryUseCases class creates the Item and FoodItem objects and injects them into the InventoryList. This way, we avoid a hard dependency between the Item/FoodItem objects and the InventoryList. We allow both the superclass, Item, and the subclass, FoodItem, to be added to the InventoryList.

We also implemented the private class data design pattern in many different classes. The point of this design pattern was to reduce the exposure of instance variables by limiting their visibility outside of the class. This way, these variables cannot be randomly changed without the class’ “permission.” For example, the Item entity class has private name and quantity instance variables so that other classes cannot access them and possibly change them to an unexpected value.

Script: A third design pattern we implemented is the strategy design pattern. We created two helper classes, a Sorter interface and a TimSorter class. These classes are used to sort the InventoryList entity items by expiry date or alphabetically by name if the item does not have an expiry date. The same applies to the ShoppingList entity. The Item and FoodItem entities implement the Comparable interface and the compareTo() method. We sort the inventory and shopping list every time the user saves. Overall, the user can easily see the items closest to expiration at the front of the inventory list.

A third design pattern we implemented is the strategy design pattern. We created two helper classes, a Sorter<T> interface with a sort() method and a TimSorter<T> class that implements this interface. The TimSorter class sorts a List<T>, which we will specifically use to sort the InventoryList items by expiry date (i.e., item closest to expiration). If an item does not have an expiration date, it is sorted alphabetically by name. The ShoppingList items are also sorted alphabetically by name. In order to sort these items, the entities, Item and FoodItem, implement the Comparable<Item> interface, which has the compareTo() method. Two FoodItems will compare expiry dates and two Items will compare their names. When comparing a FoodItem to an Item, the FoodItem always comes first. Overall, the inventory is sorted so that the items closest to expiration are at the front of the inventory list for the user to see easily. Similarly, the shopping list is sorted alphabetically so that the user can find the items easily.


## 4 Code Organization <a name="organization"></a>
### 4.1 Packaging Strategies <a name="package"></a>

The packaging strategies we considered were packaging by layer versus packing by feature. If we packaged by feature, we would group classes related to inventory together and classes related to shopping list together. However, there are common classes between inventory and shopping list such as the Item class. We found packaging by layer intuitively easier to understand as the layers of clean architecture are clearer to us. Therefore, we packaged by layer.


### 4.2 Use of Github Features  <a name="github"></a>

We have used a variety of Github features to complete Phase 2 of our project. Each group member created their own local repository by cloning the remote one, and they updated their local repository by performing the "git pull" function (either from IntelliJ or from Git Bash). Each group member had their own branch, where they pushed code and other work that they did on the project. Whenever a member completed their tasks, they pushed their work onto their local branch, and then they made a pull request. After creating this request, we looked at the work and decided whether to merge it into the main branch.

Since our UI decision was Web App using HTML and CSS, everytime we made changes to our code we had to reopen the new raw version of our HTML file directly from GitHub and get the source code to open it on a browser again. To save time in doing this, we tried to use the action tab feature on GitHub by setting up a new workflow that allows us to view the updated HTML on our repo directly. We manage to retrieve the URL link to the updated HTML by searching through the template marketplace from GitHub and applying the appropriate code.


## 5 Progress Report <a name="progress"></a>

### 5.1 What Worked Well with Our Design <a name="worked-well"></a>

- We followed the dependency rule of Clean Architecture (as shown in the UML diagram).
- We consistently checked whether our implementation/design choices adhere to the five SOLID principles of object oriented design.
- We organized and packaged our code efficiently and effectively.
- The design patterns work well.

### 5.2 Author Details <a name="author"></a>

- Ayanaa: Refactored variable names to follow proper style conventions. Assisted with the creation of use cases and entities for user authentication, unit tests for authentication (use case and controller). Assisted with project accessibility report and design document.

- Jennifer: Implemented the strategy design pattern to sort the items in inventory and shopping list. Created an interface for the common methods of InventoryList and ShoppingList entities. Refactored code, such as moving the toStringBuilder() method from the entity layer to the use case layer. Assisted with project accessibility report and design document.

- Alissa: Assisted with the creation of use cases and entities for user authentication, unit tests for authentication. Assisted with project accessibility report and design document. Also assisted in the development of the login system.

- Ali: Updated data persistence/serialization (via CSV files) to save user information and the user’s corresponding inventory and shopping lists. Assisted with project accessibility report and design document.

- Aamishi: Worked front-end/on the outer layer. Unit tests for user authentication. Assisted with project accessibility report and design document.

- Sam:  Worked front-end/on the outer layer. Connected website to Java code. Assisted with project accessibility report and design document.

### 5.3 Significant Pull Requests  <a name="pull-requests"></a>

- Ayanaa: https://github.com/CSC207-UofT/course-project-Super-Jumbo-AAAA-Batteries/pull/37

I think this demonstrates a significant contribution to the team because testing our code is very important to do, in order to ensure that our user authentication system is working as expected. Additionally, I made some changes and assisted with the implementation of the log-in use case and controller which is a significant aspect of our project and scope.

- Jennifer: https://github.com/CSC207-UofT/course-project-Super-Jumbo-AAAA-Batteries/pull/44


https://github.com/CSC207-UofT/course-project-Super-Jumbo-AAAA-Batteries/pull/46

In this pull request, I implemented the strategy design pattern (second link contains the new classes that weren’t included in the first pull request). I think this demonstrates a significant contribution to the team because this pattern is used to sort the items in a user’s inventory and shopping list (by expiry date and/or alphabetically). This way, the user can easily see which items are the closest to expiration and find the item(s) they’re looking for easily. This pull request also incorporates much of what we learned about design patterns, interfaces, generics, and comparing objects using Comparable<T> and compareTo().

- Alissa: https://github.com/CSC207-UofT/course-project-Super-Jumbo-AAAA-Batteries/pull/42

In this pull request, I added new features to the login system. This feature included exiting the program if incorrect credentials were inputted, which is essential to the functionality of our login system. As well, while I modified most of the code before so that it adheres to Clean Architecture, in this commit, I modified it further so that only the driver (not the controller) prints output.

- Ali:
  https://github.com/CSC207-UofT/course-project-Super-Jumbo-AAAA-Batteries/pull/32

This pull request, combined with the pull request 31 is for the integration of the login system to the gyst structure from phase 1. At this point, due to the conversion from the single-user structure to the multiple-user structure, I implemented the gateway classes to read and write the user information for login use cases, in addition to extending the structure for the storing of the Shopping Lists and Inventory Lists of separate users.

- Aamishi: https://github.com/CSC207-UofT/course-project-Super-Jumbo-AAAA-Batteries/pull/33

Before this pull request, our project was using a command-line interface to interact with our application, gyst. This pull request changes our project’s UI from a CLI to a web-app. The web-app has a landing login page that lets users to type in their username and password and login to gyst to see their Inventory and Shopping List. From there we are sent to the main part of the gyst web application. Here, users can add and save their items to the Inventory and Shopping List. The design of the website is made to be accessible with readable fonts and font sizes.

- Sam: 

