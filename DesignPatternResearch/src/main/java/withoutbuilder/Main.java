package withoutbuilder;

public class Main {
    public static void main(String[] args) {
        // Customer 1
        Pizza pizzaOne = new Pizza("large", "thin", true, true, true);

        // Customer 2
        Pizza pizzaTwo = new Pizza("large", "thick", true);

        // Customer 3
        Pizza pizzaThree = new Pizza("small", "thick", true, true, false, true);

        // Customer 4
        Pizza pizzaFour = new Pizza("medium", "thin");

        // works, but should it? Does it make logical sense to remove pepperoni once the pizza is in the oven?
        pizzaThree.setPepperoni(false);
    }
}
