package by.mensk.kitchen.dto.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserBean {
    private  String email;
    private String pass;
    private String passToConfirm;
    private String name;
    private String lastName;
    private Integer phone;

}
