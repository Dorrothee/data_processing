package back.lab7.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="watches_lab7")
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String look;
    private String model;
    private Integer price;
}
