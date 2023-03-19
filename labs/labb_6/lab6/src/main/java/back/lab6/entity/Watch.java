package back.lab6.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="watches_lab6")
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String look;
    private String model;
    private Integer price;
}
