package by.mensk.kitchen.dto.bean;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBean {
    private  String  name;
    private Double weight;
    private Boolean isUsed;
}
