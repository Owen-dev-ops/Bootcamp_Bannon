import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    public static List<Vehicle> readInventory() {
        List<Vehicle> inventory = new ArrayList<>();
        try {
            // inventory holds the list of games we read from the videogame_product_inventory psv file
            FileReader fileReader = new FileReader("src/main/resources/inventory.psv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String row;

            bufferedReader.readLine();
            while ((row = bufferedReader.readLine()) != null) {
                String[] brokenUpRow = row.split("\\|");
                int vin = Integer.parseInt(brokenUpRow[0]);
                int year = Integer.parseInt(brokenUpRow[1]);
                String make = brokenUpRow[2];
                String model = brokenUpRow[3];
                String vehicleType = brokenUpRow[4];
                String color = brokenUpRow[5];
                int odometer = Integer.parseInt(brokenUpRow[6]);
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(brokenUpRow[7]));

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, amount);

                inventory.add(vehicle);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException ex) {
            System.out.println("Error opening file to read");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Error handling file to read");
            ex.printStackTrace();
        }
        return inventory;
    }

    public static void writeToInventory(Vehicle vehicle){
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory.psv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String newLine = String.format("%d|%d|%s|%s|%s|%s|%d|%s",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice());


            bufferedWriter.flush();
            bufferedWriter.newLine();
            bufferedWriter.write(newLine);
            System.out.println("New transaction added to transaction.psv\n");

            bufferedWriter.close();
            fileWriter.close();
        }catch(IOException ex){
            System.out.println("Error opening file to write to");
            ex.printStackTrace();
        }catch(Exception ex){
            System.out.println("Error handling file to write to");
            ex.printStackTrace();
        }
    }

    public static Dealership getDealership(){
        Dealership dealership = new Dealership("", "", "");
        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.psv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String row;

            row = bufferedReader.readLine();
            String[] brokenUpRow = row.split("\\|");
            String name = brokenUpRow[0];
            String address = brokenUpRow[1];
            String phone = brokenUpRow[2];

            bufferedReader.close();
            fileReader.close();
            return new Dealership(name, address, phone);
        } catch (IOException ex) {
            System.out.println("Error opening file to read");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Error handling file to read");
            ex.printStackTrace();
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership){
        for(Vehicle vehicle : dealership.getInventory()){
            writeToInventory(vehicle);
        }
    }
}
