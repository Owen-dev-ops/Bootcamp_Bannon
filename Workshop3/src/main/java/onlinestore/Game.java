package onlinestore;

public class Game {
    private String sku;
    private String name;
    private float price;

    public Game(String sku, String name, float price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
