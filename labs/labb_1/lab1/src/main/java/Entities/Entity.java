package Entities;

public class Entity {
    private String model;
    private int price;

    public Entity(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Entity {" +
                "model = '" + model + '\'' +
                ", price = " + price +
                '}';
    }
}
