package onlinestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VideoGameStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Game> inventory = FileManager.readFile();
        List<Game> shoppingCart = new ArrayList<>();
        Receipt receipt = new Receipt(shoppingCart);
        String userInput = "";

        System.out.printf("%sWelcome to Pixel and Potion game store%s\n", Constants.BOLD, Constants.RESET);
        // While the user hasn't chosen to exit the program, direct them to the correct method based off their input
        while (true) {
            displayMenu();
            userInput = scanner.nextLine().toLowerCase();
            directUser(userInput, inventory, shoppingCart, scanner, receipt);
        }
    }

    // Functions

    // Display store usage menu
    public static void displayMenu() {
        System.out.printf("\n%sStore Guide:%s\n" +
                "%sView all Products%s               : va, view-all\n" +
                "%sDisplay Cart Items%s              : dc, display-cart\n" +
                "%sSearch for a product%s            : sp, search-product\n" +
                "%sAdd a product to your cart%s      : ap, add-product\n" +
                "%sRemove a product from your cart%s : rp, remove-product\n" +
                "%sCheckout%s                        : c, checkout\n" +
                "%sExit Store%s                      : e, exit\n> ", Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET);
    }

    // Direct user based off input
    public static void directUser(String userInput, List<Game> inventory, List<Game> shoppingCart, Scanner scanner, Receipt receipt) {
        switch (userInput) {
            case "va", "view-all":
                displayAllProducts(inventory);
                break;
            case "dc", "display-cart":
                displayCart(shoppingCart, receipt);
                break;
            case "sp", "search-product":
                searchForProduct(inventory, scanner);
                break;
            case "ap", "add-product":
                shoppingCart = addToCart(inventory, shoppingCart, scanner, receipt);
                break;
            case "rp", "remove-product":
                shoppingCart = removeFromCart(shoppingCart, scanner, receipt);
                break;
            case "c (bonus)", "checkout":
                // code
                break;
            case "e", "exit":
                System.out.println("Goodbye");
                System.exit(0);
                break;
            default:
                System.out.println("Unknown command, please see store guide below: ");
        }
    }

    // Display all products
    public static void displayAllProducts(List<Game> inventory) {
        System.out.println("------------------------------------------------------");
        System.out.printf("%sALL GAMES: %s\n", Constants.BOLD, Constants.RESET);
        for (Game game : inventory) {
            System.out.printf("%sTitle%s: %s : " +
                    "%sPrice%s: %.2f " +
                    "%sSKU%s: %s\n" +
                    "|\n", Constants.BOLD, Constants.RESET, game.getName(), Constants.BOLD, Constants.RESET, game.getPrice(), Constants.BOLD, Constants.RESET, game.getSku());
        }
        System.out.println("------------------------------------------------------");
        System.out.println("What would you like to do next?");
    }

    // Display all products in the cart
    public static void displayCart(List<Game> shoppingCart, Receipt receipt) {
        System.out.println("------------------------------------------------------");
        System.out.printf("%sShopping Cart: %s\n", Constants.BOLD, Constants.RESET);
        if (shoppingCart.isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for (Game game : shoppingCart) {
            System.out.printf("%sTitle%s: %s : " +
                    "%sPrice%s: %.2f " +
                    "%sSKU%s: %s\n" +
                    "|\n", Constants.BOLD, Constants.RESET, game.getName(), Constants.BOLD, Constants.RESET, game.getPrice(), Constants.BOLD, Constants.RESET, game.getSku());
        }
        System.out.printf("Cart Total: $%.2f\n", receipt.getReceiptTotal());
        System.out.println("------------------------------------------------------");
        System.out.println("What would you like to do next?");
    }


    // Search for a product in the store by SKU or title
    public static void searchForProduct(List<Game> inventory, Scanner scanner) {
        System.out.println("Please enter the name of the game or sku number you are looking for:");

        // userInput holds the title or sku they are searching for
        String userInput = scanner.next().toLowerCase();
        // searchResults holds the results of the users search
        List<Game> searchResults = new ArrayList<>();

        // For each game in the stores inventory if the title or sku the user entered matches, add it to the searchResults list
        for (Game game : inventory) {
            if (game.getName().toLowerCase().contains(userInput) || game.getSku().toLowerCase().contains(userInput)) {
                searchResults.add(game);
            }
        }

        // if searchResults is empty inform the search returned back nothing, else print out results
        if (searchResults.isEmpty()) {
            System.out.println("------------------------------------------------------");
            System.out.printf("%sSearch Results:%s\n", Constants.BOLD, Constants.RESET);
            System.out.println("No games found :(, please try again");
            System.out.println("------------------------------------------------------");
        } else {
            System.out.println("------------------------------------------------------");
            System.out.printf("%sSearch Results:%s\n", Constants.BOLD, Constants.RESET);
            for (Game game : searchResults) {
                System.out.printf("%sTitle%s: %s : " +
                        "%sPrice%s: %.2f " +
                        "%sSKU%s: %s" +
                        "\n|\n", Constants.BOLD, Constants.RESET, game.getName(), Constants.BOLD, Constants.RESET, game.getPrice(), Constants.BOLD, Constants.RESET, game.getSku());
                System.out.println("------------------------------------------------------");
            }
        }
        System.out.println("What would you like to do next?");
        // clear anything stored in scanner
        scanner.nextLine();
    }


    // Add a product to the cart
    public static List<Game> addToCart(List<Game> inventory, List<Game> shoppingCart, Scanner scanner, Receipt receipt) {
        System.out.println("What game would you like to add to cart?:");
        String userInput = scanner.nextLine().toLowerCase();
        boolean isEmpty = true;

        // for every game in inventory if the title or sku matches what the user entered then add that game to shopping cart
        for (Game game : inventory) {
            if (game.getName().toLowerCase().contains(userInput) || game.getSku().toLowerCase().contains(userInput)) {
                System.out.printf("%s successfully added to cart\n", game.getName());
                shoppingCart.add(game);
                receipt.addGame(game);
                isEmpty = false;
                break;
            }
        }
        if (isEmpty) {
            System.out.println("No games found :(, please try again");
        }
        System.out.println("What would you like to do next?");
        return shoppingCart;
    }


    // Remove item from cart
    public static List<Game> removeFromCart(List<Game> shoppingCart, Scanner scanner, Receipt receipt) {
        System.out.println("What game would you like to remove from your cart?");
        String userInput = scanner.nextLine().toLowerCase();
        boolean isEmpty = true;

        // for every game in shopping cart if the title or sku matches what the user entered then remove that game from shopping cart
        for (Game game : shoppingCart) {
            if (game.getName().toLowerCase().contains(userInput) || game.getSku().toLowerCase().contains(userInput)) {
                System.out.printf("%s successfully removed from cart\n", game.getName());
                isEmpty = false;
                shoppingCart.remove(game);
                receipt.removeGame(game);
                break;
            }
        }
        if (isEmpty) {
            System.out.println("No games found :(, please try again");
        }
        System.out.println("What would you like to do next?");
        return shoppingCart;
    }

    /* public static Receipt checkOut(){
        //
        return receipt;
    }*/

}      // Bonus: Checkout
