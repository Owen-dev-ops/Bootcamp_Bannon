import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Asset> assets = new ArrayList<>();

        House house1 = new House("Country Home", "2020-04-27", BigDecimal.valueOf(300000), "222 Country Lane", 3, 50000, 3000);
        House house2 = new House("Vacation Home", "2018-02-22", BigDecimal.valueOf(1000000), "Something something California 27485", 4, 75000, 4000);

        Vehicle vehicle1 = new Vehicle("Moped", "2020-02-02", BigDecimal.valueOf(5000), "Honda Moped", 2012, 50000);
        Vehicle vehicle2 = new Vehicle("Car", "2017-06-14", BigDecimal.valueOf(30000), "Lexus S", 2024, 20000);

        assets.add(house1);
        assets.add(house2);
        assets.add(vehicle1);
        assets.add(vehicle2);

        for(Asset asset : assets){
            System.out.println(asset.getDescription());
            System.out.println(asset.getDateAcquired());
            System.out.println(asset.getOriginalCost());
            System.out.println(asset.getValue());

            if(asset instanceof Vehicle){
                System.out.println(((Vehicle) asset).getMakeModel());
            }
        }
    }
}
