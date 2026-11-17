import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue(){
        LocalDate localYear = LocalDate.now();
        BigDecimal age = new BigDecimal(localYear.getYear() - year);
        BigDecimal value = BigDecimal.ZERO;
        if(age.compareTo(BigDecimal.ZERO) == 1 && age.compareTo(BigDecimal.valueOf(4)) == -1 ){
            value = (getOriginalCost().subtract((getOriginalCost().multiply(BigDecimal.valueOf(0.03)).multiply(age))));
        }else if(age.compareTo(BigDecimal.valueOf(4)) >= 0 && age.compareTo(BigDecimal.valueOf(7)) == -1){
            value = (getOriginalCost().subtract((getOriginalCost().multiply(BigDecimal.valueOf(0.06)).multiply(age))));
        }else if(age.compareTo(BigDecimal.valueOf(7)) >= 0 && age.compareTo(BigDecimal.valueOf(10)) <= 0){
            value = (getOriginalCost().subtract((getOriginalCost().multiply(BigDecimal.valueOf(0.08)).multiply(age))));
        }else if(age.compareTo(BigDecimal.valueOf(10)) == 1){
            value = (BigDecimal.valueOf(1000));
        }
        if(odometer > 100000){
            if(!makeModel.toLowerCase().contains("honda") || !makeModel.toLowerCase().contains("toyota")){
                value = value.subtract(value.multiply(BigDecimal.valueOf(0.25)));
            }
        }
        return value;
    }
}
