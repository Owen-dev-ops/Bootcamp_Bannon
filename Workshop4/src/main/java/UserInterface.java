import java.math.BigDecimal;
import java.util.List;
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
        ui.display();
    }

    public void display() {
        System.out.printf("%sWelcome to LotFinder%s\n------------------------------------------\n", ColorCodes.GREEN_BACKGROUND, ColorCodes.RESET);

        // Print Usage menu
        System.out.printf("%s%s%sLotFinder:%s\n" +
                "%s1:%s Find Vehicles within a price range\n" +
                "%s2:%s Find vehicles by makes / model\n" +
                "%s3:%s Find vehicles by year range\n" +
                "%s4:%s Find vehicles by color\n" +
                "%s5:%s Find vehicles by mileage range\n" +
                "%s6:%s Find vehicles by type (car, truck, SUV, van)\n" +
                "%s7:%s List ALL vehicles\n" +
                "%s8:%s Add a vehicle\n" +
                "%s9:%s Remove a vehicle\n" +
                "%s99:%s Quit", ColorCodes.BOLD, ColorCodes.UNDERLINE, ColorCodes.GREEN, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET,ColorCodes.YELLOW, ColorCodes.RESET, ColorCodes.YELLOW, ColorCodes.RESET);

        // get user input

        // switch case for userInput matching there input to the correct process function

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
