package by.mensk.kitchen.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name ="Id")
    private Integer id;
    @Column(name ="name", unique = true)
    private  String  name;
    @Column(name ="weight")
    private Double weight;



}
