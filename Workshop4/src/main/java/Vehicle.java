import JavaHelpers.ColorCodes;

import java.math.BigDecimal;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private BigDecimal price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, BigDecimal price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getOdometer() {
        return odometer;
    }

    public void printVehicleInfo(){
        // TODO: Make this print like the table in Capstone1
        System.out.printf("\n%s%sVin%s: %-15s" +
                "%s%sYear%s: %-15s" +
                "%s%sMake%s: %-15s" +
                "%s%sModel%s: %-15s" +
                "%s%sVehicle Type%s: %-15s" +
                "%s%sColor%s: %-15s" +
                "%s%sOdometer%s: %-15s" +
                "%s%sPrice%s: %-15s\n" +
                "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n", ColorCodes.BOLD, ColorCodes.BLUE, ColorCodes.RESET, vin, ColorCodes.BOLD, ColorCodes.BLUE, ColorCodes.RESET, year, ColorCodes.BOLD, ColorCodes.BLUE, ColorCodes.RESET, make, ColorCodes.BOLD, ColorCodes.BLUE, ColorCodes.RESET, model, ColorCodes.BOLD, ColorCodes.BLUE, ColorCodes.RESET, vehicleType, ColorCodes.BOLD, ColorCodes.BLUE, ColorCodes.RESET, color, ColorCodes.BOLD, ColorCodes.BLUE, ColorCodes.RESET, odometer, ColorCodes.BOLD, ColorCodes.BLUE, ColorCodes.RESET, price);
    }

}
