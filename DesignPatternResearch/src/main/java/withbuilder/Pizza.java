package withbuilder;


// A pizza once submitted to be made shouldn't change, the Builder allows all variables to be final and immutable.
// Where as without the builder cheese, pepperoni, mushrooms, and pineapple had to be left mutable so each constructor
// would work.

// Notice too, far less constructors.
public class Pizza {
    private final String size;
    private final String crust;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;
    private final boolean pineapple;

    public Pizza(Builder builder){
        this.size = builder.size;
        this.crust = builder.crust;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.pineapple = builder.pineapple;
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

    public boolean isPepperoni() {
        return pepperoni;
    }

    public boolean isMushrooms() {
        return mushrooms;
    }

    public boolean isPineapple() {
        return pineapple;
    }

    // The Builder design pattern suggest we extract the object construction or creation code out of its own class and into
    // a class called Builder.
    public static class Builder {
        // Required fields
        private final String size;
        private final String crust;

        // Optional fields
        private boolean cheese = true;
        private boolean pepperoni = false;
        private boolean mushrooms = false;
        private boolean pineapple = false;

        public Builder(String size, String crust){
            this.size = size;
            this.crust = crust;
        }

        public Builder cheese(boolean value){
            this.cheese = value;
            return this;
        }

        public Builder pepperoni(boolean value){
            this.pepperoni = value;
            return this;
        }

        public Builder mushrooms(boolean value){
            this.mushrooms = value;
            return this;
        }

        public Builder pineapple(boolean value){
            this.pineapple = value;
            return this;
        }
        // If in the future more toppings are added put builder method here like above, vs having to create a new constructor as in withoutbuilder

        // Return instance of the object this builder is supposed to create
        public Pizza build(){
            return new Pizza(this);
        }
    }
}
