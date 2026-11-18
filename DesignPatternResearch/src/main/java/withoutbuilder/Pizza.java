package withoutbuilder;

public class Pizza {
    private final String size;
    private final String crust;
    private boolean cheese = true;
    private boolean pepperoni = false;
    private boolean mushrooms = false;
    private boolean pineapple = false;

    public Pizza(String size, String crust, boolean cheese, boolean pepperoni, boolean mushrooms, boolean pineapple){
        this.size = size;
        this.crust = crust;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.mushrooms = mushrooms;
        this.pineapple = pineapple;
    }

    public Pizza(String size, String crust, boolean cheese, boolean pepperoni, boolean mushrooms){
        this.size = size;
        this.crust = crust;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.mushrooms = mushrooms;
    }

    public Pizza(String size, String crust, boolean cheese, boolean pepperoni){
        this.size = size;
        this.crust = crust;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
    }

    public Pizza(String size, String crust, boolean cheese){
        this.size = size;
        this.crust = crust;
        this.cheese = cheese;
    }

    public Pizza(String size, String crust){
        this.size = size;
        this.crust = crust;
    }

    public String getSize() {
        return size;
    }

    public String getCrust() {
        return crust;
    }


    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public boolean isMushrooms() {
        return mushrooms;
    }

    public void setMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
    }

    public boolean isPineapple() {
        return pineapple;
    }

    public void setPineapple(boolean pineapple) {
        this.pineapple = pineapple;
    }
}
