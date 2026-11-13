import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    /*
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {

    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){

    }

    public List<Vehicle> getVehiclesByYear(int min, int max){

    }

    public List<Vehicle> getVehiclesByColor(String color){

    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){

    }

    public List<Vehicle> getVehiclesByType(String vehicleType){

    }

    public List<Vehicle> getAllVehicles(){

    }

    public void addVehicle(Vehicle){

    }

    public void removeVehicle(Vehicle){

    } */
}
