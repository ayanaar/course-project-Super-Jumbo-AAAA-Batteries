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

    @RequestMapping(value = "/item_added_inventory", method = RequestMethod.GET)
    public ModelAndView ItemAddedInventory() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("item_added_inventory.html");
        return modelAndView;
    }

    @RequestMapping(value = "/item_removed_inventory", method = RequestMethod.GET)
    public ModelAndView ItemRemovedInventory() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("item_removed_inventory.html");
        return modelAndView;
    }

    @RequestMapping(value = "/item_added_shoppinglist", method = RequestMethod.GET)
    public ModelAndView ItemAddedShoppingList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("item_added_shoppinglist.html");
        return modelAndView;
    }

    @RequestMapping(value = "/item_removed_shoppinglist", method = RequestMethod.GET)
    public ModelAndView ItemRemovedShoppingList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("item_removed_shoppinglist.html");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addItemToShoppingList(@RequestParam String name, @RequestParam int quantity) {
        listManager.addShoppingListItem(name, quantity);
        return new ModelAndView("redirect:/item_added_shoppinglist");
    }

    @PostMapping("/remove")
    public ModelAndView RemoveItemFromShoppingList(@RequestParam int index) {
        listManager.removeShoppingListItem(index);
        return new ModelAndView("redirect:/item_removed_shoppinglist");
    }

    @GetMapping("/list")
    public String getShoppingListItems() {
        return listManager.printShoppingList().replaceAll("\n", "<br>");
    }

    @PostMapping("/add_inventory")
    public ModelAndView addItemToInventoryList(@RequestParam String name, @RequestParam int quantity, @RequestParam String expiryDate) {
        listManager.addInventoryItem(name, quantity, expiryDate);
        return new ModelAndView("redirect:/item_added_inventory");
    }

    @PostMapping("/remove_inventory")
    public ModelAndView RemoveItemFromInventoryList(@RequestParam int index) {
        listManager.removeInventoryItem(index);
        return new ModelAndView("redirect:/item_removed_inventory");
    }

    @GetMapping("/list_inventory")
    public String getInventoryListItems() {
        return listManager.printInventory().replaceAll("\n", "<br>");
    }

    @PostMapping("/save")
    public String saveList() {
        listManager.sortLists();
        listManager.saveLists(signedInUser);
        return "List saved!";
    }
}