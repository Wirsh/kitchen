package by.mensk.kitchen.dto.bean;

import by.mensk.kitchen.model.Product;
import lombok.*;


import java.util.List;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MealBean {

    private  String  name;
    private  String  type;
    private  String  category;
    private Integer amount;
    private Double weight;
    private List<Product> products;
}
