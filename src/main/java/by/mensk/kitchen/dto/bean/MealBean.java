package by.mensk.kitchen.dto.bean;

import by.mensk.kitchen.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MealBean {

    private  String  name;
    private  String  type;
    private  String  category;
    private Integer amount;
    private List<Product> products;
}
