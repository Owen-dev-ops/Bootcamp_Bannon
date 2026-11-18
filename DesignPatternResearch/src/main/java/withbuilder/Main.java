package withbuilder;

public class Main {
    public static void main(String[] args) {
        // Builder allows you to create objects on a step by step basis

        // Customer 1
        // Constructor values now telescoped (although IntelliJ does offer this functionality within normal constructors / see withoutbuilder main
        // Multiple constructors not needed
        Pizza pizzaOne = new Pizza.Builder("large", "thin")
                .cheese(true)
                .pepperoni(true)
                .mushrooms(true)
                .build();

        // Customer 2
        Pizza pizzaTwo = new Pizza.Builder("large", "thick")
                .pepperoni(true)
                .build();

        // Customer 3
        Pizza pizzaThree = new Pizza.Builder("small", "thick")
                .cheese(true)
                .pepperoni(true)
                .mushrooms(false)
                .pineapple(true)
                .build();

        // Customer 4
        Pizza pizzaFour = new Pizza.Builder("medium", "thin")
                .cheese(true)
                .pepperoni(true)
                .mushrooms(false)
                .pineapple(true)
                .build();

        // Other use (Two ongoing orders) (Imagine each customer is being served by a different associate)
        Pizza.Builder newPizzaOne = new Pizza.Builder("large", "thick");

        Pizza.Builder newPizzaTwo = new Pizza.Builder("small", "thin");

        // Customer one wants cheese
        newPizzaOne.cheese(true);

        // Customer two also wants cheese
        newPizzaTwo.cheese(true);

        // Customer one wants pepperoni
        newPizzaOne.pepperoni(true);
        // Customer two is all set on pepperoni

        // Customer one isn't sure if they want mushrooms, so customer two is going to pass them in line

        // Customer two wants pineapple
        newPizzaTwo.pineapple(true);
        // Customer two is ready to checkout, make the pizza object (imagine chefs in the back see screen which this newly made pizza object will get sent to
        Pizza pizzaFive = newPizzaTwo.build();

        // Customer one does want mushrooms
        newPizzaOne.mushrooms(true);

        // Customer one also wants pineapple
        newPizzaOne.pineapple(true);

        // Customer one is ready to checkout
        Pizza pizzaSix = newPizzaOne.build();

        // Can we change Customer Ones pizza now?

        // Well we don't have setters since all of Pizza's variables are immutable. And so we have to use the builder. The build() function then has access to mutate the default values of a Pizza. And so you cannot adjust a customers order once its being made. You can only make them a new pizza.
        pizzaSix.setCheese(false);


    }
}
