import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import JavaHelpers.ColorCodes;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public static void run() {
        UserInterface ui = new UserInterface(DealershipFileManager.getDealership());
        ui.dealership.setInventory(DealershipFileManager.readInventory());
        System.out.printf("%sWelcome to LotFinder%s\n", ColorCodes.GREEN_BACKGROUND, ColorCodes.RESET);
        while(true){
            ui.display();
        }
    }


    public void display() {

        System.out.printf("\n%s%s%sLotFinder:%s\n" +
                "%s1:%s Find Vehicles within a price range\n" +
                "%s2:%s Find vehicles by make / model\n" +
                "%s3:%s Find vehicles by year range\n" +
                "%s4:%s Find vehicles by color\n" +
                "%s5:%s Find vehicles by mileage range\n" +
                "%s6:%s Find vehicles by type (car, truck, SUV, van)\n" +
                "%s7:%s List ALL vehicles\n" +
                "%s8:%s Add a vehicle\n" +
                "%s9:%s Remove a vehicle\n" +
                "%s99:%s Quit\n------------------------------------------\n>", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.GREEN, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET);

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        // switch case for userInput matching there input to the correct process function
        switch (userInput){
            case "1", "price-range":
                processGetByPriceRequest();
                break;
            case "2", "make-model":
                processGetByMakeModelRequest();
                break;
            case "3", "year-range":
                processGetByYearRequest();
                break;
            case "4", "color":
                processGetByColorRequest();
                break;
            case "5", "mileage-range":
                processGetByMileageRequest();
                break;
            case "6", "type":
                processGetByVehicleRequest();
                break;
            case "7", "show-all":
                processGetAllVehiclesRequest();
                break;
            case "8", "add-vehicle":
                processAddVehicleRequest();
                break;
            case "9", "remove-vehicle":
                processRemoveVehicleRequest();
                break;
            case "99", "quit":
                System.out.println("Goodbye");
                System.exit(0);
                break;
        }
    }

    public void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);
        boolean validAnswer = false;
        BigDecimal zero = new BigDecimal(0);
        BigDecimal low = null;
        BigDecimal high = null;
        
        // Get low price and validate users input
        while(!validAnswer){
            System.out.printf("%s%sEnter low price%s: \n>", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
            try{
                low = scanner.nextBigDecimal();
                if(low.compareTo(zero) == -1){
                    System.out.println("Low price must be positive");
                    throw new RuntimeException();
                }
                validAnswer = true;
            }catch(Exception ex){
                scanner.nextLine();
                System.out.println("Please enter a valid dollar amount");
            }
        }
        validAnswer = false;

        // get high price and validate users input
        while(!validAnswer){
            System.out.printf("%s%sEnter high price%s: \n>", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
            try{
                high = scanner.nextBigDecimal();
                if(high.compareTo(zero) == -1){
                    System.out.println("High price must be positive");
                    throw new RuntimeException();
                }else if(high.compareTo(low) == -1){
                    System.out.println("High price must be higher than low price");
                    throw new RuntimeException();
                }
                validAnswer = true;
            }catch(Exception ex){
                scanner.nextLine();
                System.out.println("Please enter a valid dollar amount");
            }
        }

        List<Vehicle> searchResults = new ArrayList<>();
        for(Vehicle vehicle : dealership.getInventory()){
            if(vehicle.getPrice().compareTo(low) == 1 && vehicle.getPrice().compareTo(high) == -1){
                searchResults.add(vehicle);
            }
        }

        displayVehicles(searchResults);
    }

    public void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        List <Vehicle> searchResults = new ArrayList<>();

        System.out.printf("%s%sEnter the make and model%s:\n>", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
        String makeAndModel = scanner.nextLine().trim().toLowerCase();
        for (Vehicle vehicle : dealership.getInventory()) {
            String combinedMakeModel = (vehicle.getMake() + " " + vehicle.getModel()).toLowerCase();
            if (combinedMakeModel.contains(makeAndModel)) {
                searchResults.add(vehicle);
            }else if(vehicle.getMake().toLowerCase().contains(makeAndModel) || vehicle.getModel().toLowerCase().contains(makeAndModel)){
                searchResults.add(vehicle);
            }
        }

        displayVehicles(searchResults);
    }

    public void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> searchResults = new ArrayList<>();
        String userInput = "";
        boolean validAnswer = false;
        int lowYear = 0;
        int highYear = 0;

        while(!validAnswer){
            System.out.printf("%s%sEnter vehicle year (low)%s:\n>", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
            userInput = scanner.nextLine();
            validAnswer = validateInt(userInput);
        }
        lowYear = Integer.parseInt(userInput);
        validAnswer = false;

        while(!validAnswer) {
            System.out.printf("%s%sEnter vehicle year (high)%s:\n>", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
            userInput = scanner.nextLine();
            if(validateInt(userInput)){
                if(Integer.parseInt(userInput) < lowYear){
                    System.out.println("Please enter a year greater than the low year");
                }else{
                    validAnswer = true;
                }
            }
        }
        highYear = Integer.parseInt(userInput);

        for(Vehicle vehicle : dealership.getInventory()){
            if(vehicle.getYear() >= lowYear && vehicle.getYear() <= highYear){
                searchResults.add(vehicle);
            }
        }
        displayVehicles(searchResults);
    }

    public void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> searchResults = new ArrayList<>();
        boolean validAnswer = false;

        System.out.printf("%s%sEnter vehicle color (low)%s:\n>", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
        String color = scanner.nextLine().trim();
        for(Vehicle vehicle : dealership.getInventory()){
            if(vehicle.getColor().contains(color)){
                searchResults.add(vehicle);
            }
        }
        displayVehicles(searchResults);
    }

    public void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> searchResults = new ArrayList<>();
        String userInput = "";
        boolean validAnswer = false;
        int lowMileage = 0;
        int highMileage = 0;

        while(!validAnswer){
            System.out.printf("%s%sEnter mileage (low)%s:\n>", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
            userInput = scanner.nextLine();
            validAnswer = validateInt(userInput);
        }
        lowMileage = Integer.parseInt(userInput);
        validAnswer = false;

        while(!validAnswer){
            System.out.printf("%s%sEnter mileage (high)%s:\n>", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
            userInput = scanner.nextLine();
            if(validateInt(userInput)){
                if(Integer.parseInt(userInput) < lowMileage){
                    System.out.println("Please enter a mileage greater than the low mileage");
                }else{
                    validAnswer = true;
                }
            }
        }
        highMileage = Integer.parseInt(userInput);

        for(Vehicle vehicle : dealership.getInventory()){
            if(vehicle.getOdometer() >= lowMileage && vehicle.getOdometer() <= highMileage){
                searchResults.add(vehicle);
            }
        }
        displayVehicles(searchResults);
    }

    public void processGetByVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        List <Vehicle> searchResults = new ArrayList<>();

        System.out.printf("%s%sEnter the vehicle type%s:\n>", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
        String type = scanner.nextLine().trim().toLowerCase();
        for (Vehicle vehicle : dealership.getInventory()) {
            if (vehicle.getVehicleType().contains(type)) {
                searchResults.add(vehicle);
            }
        }

        displayVehicles(searchResults);
    }

    public void processGetAllVehiclesRequest() {
        System.out.printf("\n%s%sAll Vehicles%s:\n ", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }

    private void displayVehicles(List<Vehicle> vehicles){
        if(vehicles.isEmpty()){
            System.out.println("-----------------------\nNo search results\n-----------------------");
        }else{
            System.out.printf("\n%s%sSearch Results%s:\n ", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.RESET);
        }
        for(Vehicle vehicle : vehicles){
            vehicle.printVehicleInfo();
        }
    }

    // TODO: Consolidate repetitive user input validation code above within the process methods
    private boolean validateInt(String input) {
        boolean validAnswer = false;
        try{
            int num = Integer.parseInt(input);
            if(num < 0){
                System.out.println("Input must be positive");
                throw new RuntimeException();
            }
            validAnswer = true;
        }catch(Exception ex){
            System.out.println("Please enter a valid integer value");
        }
        return validAnswer;
    }

    private boolean validateBigDecimal(BigDecimal input){
        return true;
    }
}
