package Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="entity")
public class Watches implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String look;
    private String model;
    private int price;

    public Watches(){}

    public Watches(int id, String look, String model, int price) {
        this.id = id;
        this.look = look;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLook() { return look; }

    public void setLook(String look) { this.look = look; }

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
        return "{\"id\": \""+id+"\", \"look\": \""+look+"\", \"model\": \""+model+"\", \"price\": "+price+"}";
    }
}
