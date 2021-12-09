package com.example.webapp_connection.controller;

import controllers.ListManager;
import controllers.LoginController;
import gateway.LoadingManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebController {
    String signedInUser;
    ListManager listManager;

    public WebController() {
        signedInUser = "";
        listManager = null;
    }

    @RequestMapping(value = "/login_failed", method = RequestMethod.GET)
    public ModelAndView LoginFailed() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("failed_to_login.html");
        return modelAndView;
    }

    @RequestMapping(value = "/login_successful", method = RequestMethod.GET)
    public ModelAndView LoginSuccessful() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("successfully_logged_in.html");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView Login(@RequestParam String username, @RequestParam String password) {
        LoginController.loadingUserList();
        LoginController controller = new LoginController(LoginController.creatingUseCase());

        String[] currentUser = new String[2];
        currentUser = controller.runLogin(username, password);
        if (currentUser[1].equals("Failed")) {
            return new ModelAndView("redirect:/login_failed");
        }
        String result = "";
        if (!currentUser[0].equals("")) {
            result = currentUser[0];
        }

        signedInUser = result;

        listManager = new ListManager(LoadingManager.InventoryListLoader(result), LoadingManager.ShoppingListLoader(result));
        return new ModelAndView("redirect:/login_successful");
    }

    @PostMapping("/add")
    public String addItemToShoppingList(@RequestParam String name, @RequestParam int quantity) {
        listManager.addShoppingListItem(name, quantity);
        return "Successfully added the item to your shopping list.";
    }

    @PostMapping("/remove")
    public String RemoveItemFromShoppingList(@RequestParam int index) {
        listManager.removeShoppingListItem(index);
        return "Successfully removed the item from your shopping list.";
    }

    @GetMapping("/list")
    public String getShoppingListItems() {
        return listManager.printShoppingList();
    }

    @PostMapping("/add_inventory")
    public String addItemToInventoryList(@RequestParam String name, @RequestParam int quantity, @RequestParam String expiryDate) {
        listManager.addInventoryItem(name, quantity, expiryDate);
        return "Successfully added the item to your inventory list.";
    }

    @PostMapping("/remove_inventory")
    public String RemoveItemFromInventoryList(@RequestParam int index) {
        listManager.removeInventoryItem(index);
        return "Successfully removed the item from your inventory list.";
    }

    @GetMapping("/list_inventory")
    public String getInventoryListItems() {
        return listManager.printInventory();
    }

    @PostMapping("/save")
    public String saveList() {
        listManager.sortLists();
        listManager.saveLists(signedInUser);
        return "List saved!";
    }
}