package onlinestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VideoGameStore {
    public static void main(String[] args) {
        // scanner will get userInput
        Scanner scanner = new Scanner(System.in);
        // inventory stores all the current products within the online game store
        List<Game> inventory = FileManager.readFile();
        // shoppingCart stores all the current products the user has in their cart
        List<Game> shoppingCart = new ArrayList<>();
        // userInput will hold users inputs as they navigate the program
        String userInput = "";

        /* for(Game game: inventory){
            System.out.println(game.getName());
        }

        Game newGame = new Game("GM-5", "Test", 19.99f);
        FileManager.writeToFile(newGame);
        inventory = FileManager.readFile();
        for(Game game: inventory){
            System.out.println(game.getName());
        } */

        // Display store usage menu
        System.out.printf("%sWelcome to Pixel and Potion game store%s\n", Constants.BOLD, Constants.RESET);
        displayMenu();
        // While the user hasn't chosen to exit the program, direct them to the correct method based off their input
        while(true){
            userInput = scanner.nextLine().toLowerCase();
            directUser(userInput, inventory, shoppingCart, scanner);
        }
    }

    // Functions

    // Display store usage menu
    public static void displayMenu(){
        System.out.printf("%sStore Guide:%s\n" +
                "%sView all Products%s               : va, view-all\n" +
                "%sDisplay Cart Items%s              : dc, display-cart\n" +
                "%sSearch for a product%s            : sp, search-product\n" +
                "%sAdd a product to your cart%s      : ap, add-product\n" +
                "%sRemove a product from your cart%s : rp, remove-product\n" +
                "%sCheckout%s                        : c, checkout\n" +
                "%sExit Store%s                      : e, exit\n", Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET, Constants.BOLD, Constants.RESET);
    }

    // Direct user based off input
    public static void directUser(String userInput, List<Game>  inventory, List<Game> shoppingCart, Scanner scanner){
        switch (userInput) {
            case "va", "view-all":
                displayAllProducts(inventory);
                break;
            case "dc", "display-cart":
                // code
                break;
            case "sp", "search-product":
                searchForProduct(inventory, scanner);
                break;
            case "ap", "add-product":
                shoppingCart = addToCart(inventory, shoppingCart, scanner);
                break;
            case "rp", "remove-product":
                // code
                break;
            case "c (bonus)", "checkout":
                // code
                break;
            case "e", "exit":
                System.out.println("Goodbye");
                System.exit(0);
                break;
            default:
                displayMenu();
        }
    }

    // Display all products
    public static void displayAllProducts(List<Game> inventory){
        System.out.println("------------------------------------------------------");
        System.out.printf("%sALL GAMES: %s\n", Constants.BOLD, Constants.RESET);
        for(Game game : inventory){
            System.out.printf("%sTitle%s: %s : " +
                    "%sPrice%s: %.2f " +
                    "%sSKU%s: %s\n" +
                    "|\n", Constants.BOLD, Constants.RESET, game.getName(), Constants.BOLD, Constants.RESET, game.getPrice(), Constants.BOLD, Constants.RESET, game.getSku());
        }
        System.out.println("------------------------------------------------------");
        System.out.println("What would you like to do next? (Unsure? Type h or help for the store guide)");
    }

    // Display all products in the cart


    // Search for a product in the store by SKU or title
    public static void searchForProduct(List<Game> inventory, Scanner scanner){
        System.out.println("Please enter the name of the game or sku number you are looking for:");

        // userInput holds the title or sku they are searching for
        String userInput = scanner.next().toLowerCase();
        // searchResults holds the results of the users search
        List<Game> searchResults = new ArrayList<>();

        // For each game in the stores inventory if the title or sku the user entered matches, add it to the searchResults list
        for(Game game : inventory){
            if(game.getName().toLowerCase().contains(userInput) || game.getSku().toLowerCase().contains(userInput)){
                searchResults.add(game);
            }
        }

        // if searchResults is empty inform the search returned back nothing, else print out results
        if(searchResults.isEmpty()){
            System.out.println("------------------------------------------------------");
            System.out.printf("%sSearch Results:%s\n", Constants.BOLD, Constants.RESET);
            System.out.println("No games found :(, please try again");
            System.out.println("------------------------------------------------------");
        }else{
            System.out.println("------------------------------------------------------");
            System.out.printf("%sSearch Results:%s\n", Constants.BOLD, Constants.RESET);
            for (Game game : searchResults) {
                System.out.printf("%sTitle%s: %s : " +
                        "%sPrice%s: %.2f " +
                        "%sSKU%s: %s" +
                        "\n|\n", Constants.BOLD, Constants.RESET, game.getName(), Constants.BOLD, Constants.RESET, game.getPrice(), Constants.BOLD, Constants.RESET, game.getSku());
                System.out.println("------------------------------------------------------");
            }
            System.out.println("What would you like to do next? (Unsure? Type h or help for the store guide)");
        }
        // clear anything stored in scanner
        scanner.nextLine();
    }


    // Add a product to the cart
    public static List<Game> addToCart(List<Game> inventory, List<Game> shoppingCart, Scanner scanner){
        System.out.println("What game would you like to add to cart?:");
        // userInput is the game the user wants to add
        String userInput = scanner.nextLine().toLowerCase();

        // for every game in inventory if the title or sku matches what the user entered then add that game to shopping cart
        for(Game game : inventory){
            if(game.getName().toLowerCase().contains(userInput) || game.getSku().toLowerCase().contains(userInput)){
                System.out.printf("%s successfully added to cart\n", game.getName());
                shoppingCart.add(game);
                break;
            }
        }
        // add error case if cart is empty, aka title or sku dosent exist
        System.out.println("What would you like to do next? (Unsure? Type h or help for the store guide)");
        // return updated shopping cart
        return shoppingCart;
    }


    // Remove item from cart


    // Bonus: Checkout


}
