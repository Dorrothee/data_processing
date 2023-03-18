package lab5.back.entity;

import jakarta.persistence.*;

@Entity
@Table(name="watches")
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String look;
    private String model;
    private Integer price;


    public Watch() {
    }


    public Watch(Integer id, String look, String model, Integer price) {
        this.id = id;
        this.look = look;
        this.model = model;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Watch{" +
                "id=" + id +
                ", look='" + look + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
