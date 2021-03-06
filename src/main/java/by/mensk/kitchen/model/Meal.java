package by.mensk.kitchen.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="meal")
public class Meal {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name ="Id")
    private Integer id;
    @Column(name ="name")
    private  String  name;
    @Column(name ="type")
    private  String  type;
    @Column(name ="category")
    private  String  category;
    @Column(name ="amount")
    private Integer amount;
    @OneToMany
    private List<Product> products;
}
