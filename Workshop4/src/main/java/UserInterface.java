import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import JavaHelpers.ColorCodes;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public static void run() {

        // Test file manager read and write functions
        /*
        List<Vehicle> vehicles = DealershipFileManager.readInventory();
        for(Vehicle vehicle : vehicles){
            vehicle.printVehicleInfo();
        }
        Vehicle test = new Vehicle(44506, 2000, "honda", "civic", "car", "blue", 25025, BigDecimal.valueOf(10000));
        DealershipFileManager.writeToInventory(test);
         */

        UserInterface ui = new UserInterface(DealershipFileManager.getDealership());
        while(true){
            ui.display();
        }
    }

    public void display() {
        System.out.printf("%sWelcome to LotFinder%s\n------------------------------------------\n", ColorCodes.GREEN_BACKGROUND, ColorCodes.RESET);

        System.out.printf("%s%s%sLotFinder:%s\n" +
                "%s1:%s Find Vehicles within a price range\n" +
                "%s2:%s Find vehicles by make / model\n" +
                "%s3:%s Find vehicles by year range\n" +
                "%s4:%s Find vehicles by color\n" +
                "%s5:%s Find vehicles by mileage range\n" +
                "%s6:%s Find vehicles by type (car, truck, SUV, van)\n" +
                "%s7:%s List ALL vehicles\n" +
                "%s8:%s Add a vehicle\n" +
                "%s9:%s Remove a vehicle\n" +
                "%s99:%s Quit", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.GREEN, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET);

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
            case "10", "quit":
                System.exit(0);
                break;
        }
    }

    public void processGetByPriceRequest() {

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleRequest() {

    }

    public void processGetAllVehiclesRequest() {

    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }
}
