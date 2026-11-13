import java.math.BigDecimal;
import java.util.List;

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

        UserInterface dealership = new UserInterface(DealershipFileManager.getDealership());
        dealership.display();
    }
    // methods
    public void display() {
        System.out.println("Welcome to LotFinder");

        // Print Usage menu

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
